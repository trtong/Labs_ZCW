package io.zipcoder.interfaces;

import java.util.ArrayList;

public abstract class People<E extends Person> {

    ArrayList<E> personList;

    public People() {
        personList = new ArrayList<E>();
    }

    public void add(E p) {
        this.personList.add(p);
    }

    public int getCount() {
        return personList.size();
    }

    public void remove(Person person) {
        personList.remove(person);
    }

    public void remove(long id) {

        for (int i = 0; i < this.getCount(); i ++) {
            if (personList.get(i).getId() == id) {
                personList.remove(personList.get(i));
            }
        }
    }

    public abstract E[] getArray();

    public void removeAll() {

        personList.clear();
    }

    /// CHeck me

    public E findById(long id) {

        Person person = null;

        for (Person p : personList) {
            if (p.getId() == id) {
                person = p;
            }
        }

        return (E) person;
    }
}


//Create a testFindById method which ensures that a respective Person object with a respective
// id field is returned upon invokation of the findById method on a respective People object.
//The class should define a method named findById which makes use of a long
// id parameter to return a Person object with the respective id field.