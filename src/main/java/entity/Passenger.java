package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Passenger
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pID")
    int pID;
    
    @Column(name="firstName")
    int firstName;
    
    @Column(name="lastName")
    int lastName;
    
    @ManyToMany
    @JoinTable(
      name="RESERVATION_PASSENGER",
      joinColumns=@JoinColumn(name="passenger_ID", referencedColumnName="pID"),
      inverseJoinColumns=@JoinColumn(name="reservation_ID", referencedColumnName="rID"))
    private List<Reservation> reservations;
    
}
