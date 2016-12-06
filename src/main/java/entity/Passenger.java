package entity;

import java.util.ArrayList;
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
    String firstName;
    
    @Column(name="lastName")
    String lastName;
    
    @ManyToMany
    @JoinTable(
      name="RESERVATION_PASSENGER",
      joinColumns=@JoinColumn(name="passenger_ID", referencedColumnName="pID"),
      inverseJoinColumns=@JoinColumn(name="reservation_ID", referencedColumnName="rID"))
    private List<Reservation> reservations = new ArrayList();

    public Passenger()
    {
    }
    
    
    public int getpID()
    {
        return pID;
    }

    public void setpID(int pID)
    {
        this.pID = pID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public List<Reservation> getReservations()
    {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations)
    {
        this.reservations = reservations;
    }
    
}
