/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.RESTFacade;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hamzalaroussi
 */
public class MakeReservationJUnitTest
{
    RESTFacade rf = RESTFacade.getInstance();
    private static final String ENDPOINT = "http://airline-plaul.rhcloud.com/api";
    
    public MakeReservationJUnitTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void makeReservation() throws MalformedURLException, ProtocolException, IOException, UnsupportedEncodingException, JSONException
    {
        
        
        
        
        JSONObject expectedJSON = new JSONObject();
        String flightID = "3256-1483488000000";
		expectedJSON.put("date", "2017-01-03T19:00:00.000Z");      
                expectedJSON.put("numberOfSeats",3);
		expectedJSON.put("reserveeName", "Bob Hansen");
                
        JSONArray passengers = new JSONArray();
		JSONObject a = new JSONObject();
		a.put("firstName", "Peter");
		a.put("lastName", "Peterson");
		passengers.put(a);
		JSONObject b = new JSONObject();
		b.put("firstName", "Jane");
		b.put("lastName", "Peterson");
		passengers.put(b);
                
		expectedJSON.put("passengers", passengers);
                expectedJSON.put("origin", "Copenhagen Kastrup(CPH)");
                expectedJSON.put("destination", "London Stansted(STN)");
                expectedJSON.put("flightTime", 90);
                expectedJSON.put("flightNumber", "COL3256");
                
                JSONObject obj = new JSONObject();
        obj.put("flightID", flightID);
        obj.put("numberOfSeats", 3);
        obj.put("reserveeName", "Bob Hansen");
        obj.put("reservePhone", "12345678");
        obj.put("reserveeEmail", "peter@peter.dk");
        obj.put("passengers", passengers);
        System.out.println(obj.toString(2));
        String expectedResult = expectedJSON.toString(2);
               String result = rf.makeReservation(flightID, expectedJSON.toString(2));
               
               
        assertEquals(expectedResult, result);
    }
}
