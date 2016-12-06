package entity;

import java.util.ArrayList;

public class ReservationTemporary
{
    String flightID; 
    int numberOfSeats; 
    String reserveeName; 
    int reservePhone;
    String reserveeEmail; 
    ArrayList<Passenger> passengers = new ArrayList(); 

    public ReservationTemporary(String id, int noSeats, String name, int phone, String email, ArrayList<Passenger> passenger)
    {
        flightID = id; 
        numberOfSeats = noSeats; 
        reserveeName = name; 
        reservePhone = phone; 
        reserveeEmail = email; 
        passengers = passenger; 
    }
    
    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName()
    {
        return reserveeName;
    }

    public void setReserveeName(String reserveeName)
    {
        this.reserveeName = reserveeName;
    }

    public int getReservePhone()
    {
        return reservePhone;
    }

    public void setReservePhone(int reservePhone)
    {
        this.reservePhone = reservePhone;
    }

    public String getReserveeEmail()
    {
        return reserveeEmail;
    }

    public void setReserveeEmail(String reserveeEmail)
    {
        this.reserveeEmail = reserveeEmail;
    }

    public String getFlightID()
    {
        return flightID;
    }

    public void setFlightID(String flightID)
    {
        this.flightID = flightID;
    }

    public ArrayList<Passenger> getPassengers()
    {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers)
    {
        this.passengers = passengers;
    }
    
    
    
}
