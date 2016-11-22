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
public class Airline
{
    // Vi skal have flightnumber som fremmet nølge
    @Column(name="name")
    String name; 
}
