package com.example.demo;

import java.util.*;

public abstract class People<PersonType extends Person> implements Iterable<PersonType> {

    private ArrayList<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = new ArrayList<>(personList);
    }

    public People() {
        personList = new ArrayList<>();
    }

    public People(PersonType... p) {
        personList = new ArrayList<>(Arrays.asList(p));
    }

    public void addAll(Iterable<PersonType> objects) {
        objects.forEach(personType -> personList.add(personType));
    }

    public void add(PersonType p) {
        this.personList.add(p);
    }

    public int size() {
        return personList.size();
    }

    public void remove(Person person) { this.personList.remove(person); }

    public ArrayList<PersonType> findall () {
        return this.personList;
    }

    public void clear() {
        personList.clear();
    }

    public PersonType findById(long id) {
        for (PersonType p : personList) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    @Override
    public Iterator<PersonType> iterator() {
        return personList.iterator();
    }

    @Override
    public Spliterator<PersonType> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }

}