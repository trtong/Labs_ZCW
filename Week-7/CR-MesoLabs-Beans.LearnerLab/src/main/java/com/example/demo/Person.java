package com.example.demo;

public class Person {

    private final long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setName(String n) {
        this.name =  n;
    }

    public String getName() {
        return name;
    }
}
