package com.example.bakerylab.models;

import javax.persistence.*;

@Entity
public class Muffin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FLAVOR")
    private String flavor;

    public Muffin() {
    }

    public Muffin(String flavor) {
        this.flavor = flavor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
