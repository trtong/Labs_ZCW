package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany
    List<Steak> steaks;

    @ManyToOne
    Person customer;

    public Order() {
    }

    public Order(Person customer, List<Steak> steaks) {
        this.steaks = steaks;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Steak> getSteaks() {
        return steaks;
    }

    public void setSteaks(List<Steak> steaks) {
        this.steaks = steaks;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }
}
