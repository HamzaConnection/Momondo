package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import facade.RESTFacade;
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

@Path("flights")
public class FlightREST
{

    RESTFacade rf = RESTFacade.getInstance();
    private static final String ENDPOINT = "http://airline-plaul.rhcloud.com/api";

    @Context
    private UriInfo context;

    public FlightREST()
    {
    }
    
    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{flightId}")
    public String test(@PathParam("flightId") String from) throws IOException
    {
        System.out.println("Inside getFlightsBetween");
        return from;
    }
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{flightID}")
    public String makeReservation(@PathParam("flightID") String flightID, String content) throws MalformedURLException, ProtocolException, IOException, UnsupportedEncodingException, JSONException
    {
        String url = ENDPOINT + "/flightreservation";
        System.out.println("Inside MakeReservation");
        JSONObject obj = new JSONObject();
        obj.put("flightID", flightID);
        obj.put("numberOfSeats", 2);
        obj.put("reserveeName", "hey");
        obj.put("reservePhone", 23432);
        obj.put("reserveeEmail", "hamza@gmail.com");

        JSONArray passengers = new JSONArray();
        JSONObject a = new JSONObject();
        a.put("firstName", "Naum");
        a.put("lastName", "Taneski");
        passengers.put(a);
        JSONObject b = new JSONObject();
        b.put("firstName", "Mila");
        b.put("lastName", "Milkovska Taneska");
        passengers.put(b);

        obj.put("passengers", passengers);
        String response = sendPost(url, obj.toString());
        JSONObject o = new JSONObject(response);
        System.out.println("JSON " + content);
        return o.toString(2);

        /*	
                JsonObject body = new JsonParser().parse(content).getAsJsonObject(); // laver string om til JsonObject
                String firstName = "";
                String lastName = "";
              // hvad gør du når der er flere firstnames og lastnames  
              if (body.has("passengers"))
        {
            JSONArray ja = body.get("passengers"); // find ud af hvordan man få fat i arrayest.
        }
 
              if (body.has("firstName"))
        {
            firstName = body.get("firstName").getAsString();
        }
                
                
                   if (body.has("lastName"))
        {
            lastName = body.get("lastName").getAsString();
        }
         
        JSONObject obj = new JSONObject();
        obj.put("flightID", flightID);

        //JSONArray passengersArray = new JSONArray();
         */

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{from}/{to}/{date}/{ticket}")
    public String getFlightsBetween(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("ticket") int ticket) throws IOException
    {
        System.out.println("Inside getFlightsBetween");
        return rf.getFlightsBetween(from, to, date, ticket);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{from}/{date}/{ticket}")
    public String getFlightsFrom(@PathParam("from") String from, @PathParam("date") String date, @PathParam("ticket") int ticket)
    {
        System.out.println("Inside getFlightsFrom");
        return rf.getFlightsFrom(from, date, ticket);
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String makeReservation(int flightId)
//    {
//        System.out.println("POSTSOMETHING");
//
//        return "{\"success\":true}";
//    }
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
