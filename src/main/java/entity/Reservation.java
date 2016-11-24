package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Reservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rID")
    private int rID;
    
    @Column(name="totalPrice")
    private double totalPrice;
    
    @ManyToMany(mappedBy="reservations")
    private List<Passenger> passengers;
}
