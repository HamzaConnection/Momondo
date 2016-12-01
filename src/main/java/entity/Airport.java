package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airportID")
    private int airportID;
     
    @Column(name="IATACode")   
    private String IATACode;
    
    @Column(name="timeZone")
    private String timezone;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;

    @OneToMany(mappedBy = "origin")
    private List<Flight> departing = new ArrayList();
    
    @OneToMany(mappedBy = "destination")
    private List<Flight> arriving = new ArrayList();
    
    public Airport()
    {
    }
    
    public Airport(String code)
    {
        this.IATACode = code;
    } 

    public int getAirportID()
    {
        return airportID;
    }

    public void setAirportID(int airportID)
    {
        this.airportID = airportID;
    }

    public String getIATACode()
    {
        return IATACode;
    }

    public void setIATACode(String IATACode)
    {
        this.IATACode = IATACode;
    }

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public List<Flight> getDeparting()
    {
        return departing;
    }

    public void addDepartingFlight(Flight f)
    {
        this.departing.add(f);
    }

    public List<Flight> getArriving()
    {
        return arriving;
    }

    public void addArrivingFlight(Flight f)
    {
        this.arriving.add(f);
    }
    
}
