package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airlineID")
    private int airlineID;

    @Column(name = "name")
    private String name;

    // Vi skal have flightnumber som fremmet nøgle
    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;
}
