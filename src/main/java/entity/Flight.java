package entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "flightNumber")
    private String flightNumber;
    @Column(name = "seats")
    private int seats;
    @Column(name = "flightTime")
    private int flightTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "airlineID")
    private Airline airline;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport origin;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport destination;
    
    @OneToMany(mappedBy = "flight")
    private List<FlightInstance> flightInstance = new ArrayList();

    public Flight(){}
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public List<FlightInstance> getFlightInstance()
    {
        return flightInstance;
    }

    public void addFlightInstance(FlightInstance fi)
    {
        this.flightInstance.add(fi);
    }

    
    public String getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public int getSeats()
    {
        return seats;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }

    public int getFlightTime()
    {
        return flightTime;
    }

    public void setFlightTime(int flightTime)
    {
        this.flightTime = flightTime;
    }

    public Airline getAirline()
    {
        return airline;
    }

    public void setAirline(Airline airline)
    {
        this.airline = airline;
    }

    public Airport getOrigin()
    {
        return origin;
    }

    public void setOrigin(Airport origin)
    {
        this.origin = origin;
    }

    public Airport getDestination()
    {
        return destination;
    }

    public void setDestination(Airport destination)
    {
        this.destination = destination;
    }
}
