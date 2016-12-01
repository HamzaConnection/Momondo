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
public class Airline
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airlineID")
    private int airlineID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList();

    public Airline(){}
    
    public int getAirlineID()
    {
        return airlineID;
    }

    public void setAirlineID(int airlineID)
    {
        this.airlineID = airlineID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Flight> getFlights()
    {
        return flights;
    }

    public void addFlight(Flight f)
    {
        this.flights.add(f);
    }
}
