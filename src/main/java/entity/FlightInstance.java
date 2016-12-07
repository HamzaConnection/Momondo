package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FlightInstance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public FlightInstance(String flightID, int time, int availableSeats, double price, Flight flight)
    {
        this.flightID = flightID;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
        this.price = price;
        this.flight = flight;
    }
    
    @Column(name="flightID")
    private String flightID;
    
    @Column(name="date")
    private String date;
    
    @Column(name="time")
    private int time;
    
    @Column(name="availableSeats")
    private int availableSeats;
    
    @Column(name="price")
    private double price;
    
    @ManyToOne
    private Flight flight;

    public FlightInstance(){}
    
    public Flight getFlight()
    {
        return flight;
    }

    public void addFlight(Flight flight)
    {
        this.flight = flight;
    }

    public String getFlightID()
    {
        return flightID;
    }

    public void setFlightID(String flightID)
    {
        this.flightID = flightID;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats)
    {
        this.availableSeats = availableSeats;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
}
