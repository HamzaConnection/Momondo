package entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightNumber")
    int flightNumber;
    @Column(name = "seats")
    int seats;
    @Column(name = "flightTime")
    int flightTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airline airline;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Airport origin;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport destination;
}
