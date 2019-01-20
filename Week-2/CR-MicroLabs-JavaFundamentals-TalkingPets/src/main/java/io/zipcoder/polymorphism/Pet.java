package io.zipcoder.polymorphism;

public abstract class Pet {

    public String name;

    public abstract String speak();

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return this.name;
    }
}
