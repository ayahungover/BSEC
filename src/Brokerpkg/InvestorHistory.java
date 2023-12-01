/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Brokerpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hp
 */
public class InvestorHistory implements Serializable{
    int id;
    String name;
    LocalDate lastInteraction;
    String interaction;

    public InvestorHistory(int id, String name, LocalDate lastInteraction, String Interaction) {
        this.id = id;
        this.name = name;
        this.lastInteraction = lastInteraction;
        this.interaction = interaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastInteraction() {
        return lastInteraction;
    }

    public void setLastInteraction(LocalDate lastInteraction) {
        this.lastInteraction = lastInteraction;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    


    
    
    
}
