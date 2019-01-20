package com.example.demo;

import org.springframework.data.annotation.Id;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Steak {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String cheese = "provolone";
    String roll = "Sarcones";

    public Steak() {
    }

    public Steak(String cheese) {
        this.cheese = cheese;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
