/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hamzalaroussi
 */
@Entity
public class FlightInstance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FlightId")
    int flightId;
    
    @Column(name="date")
    Date date;
    
    @Column(name="time")
    int time;
    
    @Column(name="availableSeats")
    int availableSeats;
    
    @Column(name="price")
    double price;
    
    
}
