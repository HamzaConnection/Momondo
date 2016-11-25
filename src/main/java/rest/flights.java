/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.UnsupportedEncodingException;

/**
 * REST Web Service
 *
 * @author hamzalaroussi
 */
@Path("flights")
public class flights
{

    private static final String ENDPOINT = "http://airline-plaul.rhcloud.com/api";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public flights()
    {
    }

    /**
     * Retrieves representation of an instance of rest.flights
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hey")
    public String getTest()
    {
        System.out.println("getTest");
        return "hey";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hey2/{hey}")
    public String getTest2(String hey)
    {
        System.out.println("getTest");

        return new Gson().toJson(hey);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{flightID}/{numberOfSeats}/{reserveeName}/{reserveePhone}/{reserveeEmail}/{passengers}")
    public String makeReservation(@PathParam("from") String flightID, @PathParam("numberOfSeats") int numberOfSeats, @PathParam("reserveeName") String reserveeName, @PathParam("reserveePhone") String reserveePhone, @PathParam("reserveeEmail") String reserveeEmail, @PathParam("passengers")JSONArray passengers) throws MalformedURLException, ProtocolException, IOException, UnsupportedEncodingException, JSONException{
		String url = ENDPOINT+"/flightreservation";
		JSONObject obj = new JSONObject();
		obj.put("flightID", flightID);
		obj.put("numberOfSeats", numberOfSeats);
		obj.put("reserveeName", reserveeName);
		obj.put("reservePhone", reserveePhone);
		obj.put("reserveeEmail", reserveeEmail);
		obj.put("passengers", passengers);
		String response = sendPost(url, obj.toString());
		JSONObject o = new JSONObject(response);
		return o.toString(2);
	}

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{from}/{to}/{date}/{ticket}")
    public String getFlightsbetween(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date ,@PathParam("ticket") int ticket) throws IOException
    {
        
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
        } catch (MalformedURLException ex)
        {
            Logger.getLogger(flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HTTPException ex)
        {
            Logger.getLogger(flights.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        return "Failed"; // return en fejl besked her
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{from}/{date}/{ticket}")
    public String getFlightsFrom(@PathParam("from") String from, @PathParam("date") String date, @PathParam("ticket") int ticket)
    {
        String[] array = date.split("-");
        Calendar c = Calendar.getInstance();

        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);

        c.set(year, month - 1, day);

        //String url = ENDPOINT+"/flightinfo/"+from+"/"+formatDate(date)+"/"+tickets;
        String url2 = ENDPOINT + "/flightinfo/" + from + "/" + formatDate(c.getTime()) + "/" + ticket;

        System.out.println("From " + from); // skal ikke convertets
        System.out.println("Array index 0 " + year);
        System.out.println("Array index 1 " + month);
        System.out.println("Array index 2 " + day);
        System.out.println("Date Object " + c.getTime());

        String response;

        try
        {
            response = sendGet(url2);
            JSONObject o = new JSONObject(response);

            return o.toString(2);
        } catch (IOException ex)
        {
            Logger.getLogger(flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HTTPException ex)
        {
            Logger.getLogger(flights.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String makeReservation(int flightId)
    {
        System.out.println("POSTSOMETHING");

        return "{\"success\":true}";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content)
    {
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
