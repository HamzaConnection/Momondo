package entity;

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
    private int flightNumber;
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
    private List<FlightInstance> flightInstance;

    public Flight(){}
    
    public List<FlightInstance> getFlightInstance()
    {
        return flightInstance;
    }

    public void setFlightInstance(List<FlightInstance> flightInstance)
    {
        this.flightInstance = flightInstance;
    }

    
    public int getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber)
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
