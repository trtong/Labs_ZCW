package org.zipcoder.store;

import java.util.Objects;

public class User {

    private long id;
    private String name;

    public User(){}

    public User(long id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

     @Override
    public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return id == user.id &&
                                Objects.equals(name, user.name);
           }

    public int hashCode() {
        Objects.hash(getId(), getName());
        return Objects.hash(getId(), getName());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
