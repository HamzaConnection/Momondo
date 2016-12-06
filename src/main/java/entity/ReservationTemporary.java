package entity;

public class ReservationTemporary
{
    String flightId; 
    int numberOfSeats; 
    String reserveeName; 
    String reservePhone;
    String reserveeEmail; 

    public ReservationTemporary(String id, int noSeats, String name, String phone, String email)
    {
        flightId = id; 
        numberOfSeats = noSeats; 
        reserveeName = name; 
        reservePhone = phone; 
        reserveeEmail = email; 
    }
    
    public String getFlightId()
    {
        return flightId;
    }

    public void setFlightId(String flightId)
    {
        this.flightId = flightId;
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
