package org.zipcoder.store;

public class Entry {
    private User key;
    private Cart value;

    public Entry(User key, Cart value) {
        this.key = key;
        this.value = value;
    }

    public User getKey() {
        return key;
    }

    public Cart getValue() {
        return value;
    }

    public void setValue(Cart value) {
        this.value = value;
    }
}