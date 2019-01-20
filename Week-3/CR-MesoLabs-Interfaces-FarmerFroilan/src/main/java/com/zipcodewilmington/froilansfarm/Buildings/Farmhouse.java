package com.zipcodewilmington.froilansfarm.Buildings;

import com.zipcodewilmington.froilansfarm.Animal.Horse;
import com.zipcodewilmington.froilansfarm.Person.Person;
import com.zipcodewilmington.froilansfarm.Storer;

import java.util.ArrayList;

public class Farmhouse implements Storer<Person> {

    private ArrayList<Person> people;

    // Stores people

    public Farmhouse() {
        people = new ArrayList<>();
    }

    public void store(Person p) {
        people.add(p);
    }

    public ArrayList<Person> getHouse() {
        return this.people;
    }

    public int howManyPeople() {
        return this.people.size();
    }
}

