package facade;

import com.google.gson.Gson;
import entity.ReservationTemporary;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RESTFacade
{
    private static final String ENDPOINT = "http://airline-plaul.rhcloud.com/api";
    private static RESTFacade instance;

    private RESTFacade()
    {
    }

    public static RESTFacade getInstance()
    {
        if(instance == null)
        {
            instance = new RESTFacade();
        }
        return instance;
    }

    public String getFlightsFrom(String from, String date, int ticket)
    {
        System.out.println("Inside RestFacade");
        String[] array = date.split("-");
        Calendar c = Calendar.getInstance();

        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        c.set(year, month - 1, day);

        String url = ENDPOINT + "/flightinfo/" + from + "/" + formatDate(c.getTime()) + "/" + ticket;
        System.out.println("From " + from);
        System.out.println("Array index 0 " + year);
        System.out.println("Array index 1 " + month);
        System.out.println("Array index 2 " + day);
        System.out.println("Date Object " + c.getTime());
        
        String response;
        try
        {
            response = sendGet(url);
            JSONObject o = new JSONObject(response);
            return o.toString(2);
        } catch (IOException ex)
        {
            Logger.getLogger(RESTFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HTTPException ex)
        {
            Logger.getLogger(RESTFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Failed to get flights from"+from;
    }
    
    public String getFlightsBetween(String from, String to, String date, int ticket)
    {
        System.out.println("Inside RestFacade");
        String[] array = date.split("-");
        Calendar c = Calendar.getInstance();

        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);

        c.set(year, month - 1, day);
        String url = ENDPOINT + "/flightinfo/" + from + "/" + to + "/" + formatDate(c.getTime()) + "/" + ticket;
        System.out.println(url);
        String response;
        try
        {
            response = sendGet(url);
            JSONObject o = new JSONObject(response);
            return o.toString(2);
        }   catch (IOException ex)
        {
            Logger.getLogger(RESTFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HTTPException ex)
        {
            Logger.getLogger(RESTFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Failed to get flights from "+from+" to "+to;
    }

    
    public String makeReservation( String flightID, String content) throws MalformedURLException, ProtocolException, IOException, UnsupportedEncodingException, JSONException
    {
        String url = ENDPOINT + "/flightreservation";
        System.out.println("Inside MakeReservation");
        ReservationTemporary res = new Gson().fromJson(content, ReservationTemporary.class);

        JSONObject obj = new JSONObject();
        obj.put("flightID", flightID);
        obj.put("numberOfSeats", res.getNumberOfSeats());
        obj.put("reserveeName", res.getReserveeName());
        obj.put("reservePhone", res.getReservePhone());
        obj.put("reserveeEmail", res.getReserveeEmail());

        JSONArray passengers = new JSONArray();
        for (int i = 0; i < res.getPassengers().size(); i++)
        {
            JSONObject a = new JSONObject();
            a.put("firstName", res.getPassengers().get(i).getFirstName());
            a.put("lastName", res.getPassengers().get(i).getLastName());
            passengers.put(a);
        }

        
        obj.put("passengers", passengers);
        String response = sendPost(url, obj.toString());
        JSONObject o = new JSONObject(response);

        return o.toString(2);

    }
    
    
    private String formatDate(Date date)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return df.format(date);
    }

    
    private class HTTPException extends Exception
    {

        public HTTPException(String message)
        {
            super(message);
        }
    }

    private String sendGet(String url) throws MalformedURLException, IOException, HTTPException
    {
        String response;
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200)
        {
            response = getResponseBody(conn.getInputStream());
        } else
        {
            response = getResponseBody(conn.getErrorStream());
            //throw new HTTPException(conn.getResponseCode()+" "+conn.getResponseMessage());
        }
        return response;
    }

    private String sendPost(String url, String postBody) throws MalformedURLException, ProtocolException, IOException
    {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        conn.setDoOutput(true);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(postBody);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        String response;
        if (responseCode == 200)
        {
            response = getResponseBody(conn.getInputStream());
        } else
        {
            response = getResponseBody(conn.getErrorStream());
            //throw new HTTPException(conn.getResponseCode()+" "+conn.getResponseMessage());
        }
        return response.toString();
    }

    private String getResponseBody(InputStream is) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
