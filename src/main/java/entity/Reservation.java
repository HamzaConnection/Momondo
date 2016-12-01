package entity;

import java.util.ArrayList;
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
    private List<Passenger> passengers  = new ArrayList();

    public Reservation()
    {
    }

    public int getrID()
    {
        return rID;
    }

    public void setrID(int rID)
    {
        this.rID = rID;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public List<Passenger> getPassengers()
    {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers)
    {
        this.passengers = passengers;
    }
}
