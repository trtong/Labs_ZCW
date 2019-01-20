package org.zipcoder.store;

import java.util.Objects;

public class Cart {
    private final long id;

    public Cart(long id) {
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return getId() == cart.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
