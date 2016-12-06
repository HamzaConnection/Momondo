package entity;

public class ReservationTemporary
{
    String flightID; 
    int numberOfSeats; 
    String reserveeName; 
    String reservePhone;
    String reserveeEmail; 

    public ReservationTemporary(String id, int noSeats, String name, String phone, String email)
    {
        flightID = id; 
        numberOfSeats = noSeats; 
        reserveeName = name; 
        reservePhone = phone; 
        reserveeEmail = email; 
    }
    
    public String getFlightId()
    {
        return flightID;
    }

    public void setFlightId(String flightId)
    {
        this.flightID = flightId;
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

    public String getReservePhone()
    {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone)
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
    
    
}
