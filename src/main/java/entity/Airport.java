/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author hamzalaroussi
 */
@Entity
public class Airport
{
    @Column(name="IATACode")
    String IATACode;
    @Column(name="Timezone")
    String timezone;
    @Column(name="Name")
    String name;
    @Column(name="Country")
    String country;
    @Column(name="City")
    String city;
    
}
