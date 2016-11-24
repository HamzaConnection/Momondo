package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FlightInstance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flightID")
    int flightId;
    
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    Date date;
    
    @Column(name="time")
    int time;
    
    @Column(name="availableSeats")
    int availableSeats;
    
    @Column(name="price")
    double price;
    
    
}
