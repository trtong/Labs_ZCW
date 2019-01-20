package org.zipcoder.store;

import java.util.List;

public interface MyMap {

    /**
     * @return the number of entry in the map
     */
    public int size();

    /**
     * @return true if the map has one or more item in it. False otherwise.
     */
    public boolean isEmptry();

    /**
     * Return the cart associated with the user
     * @param key
     * @return The cart associated with the user, null if none exist.
     */
    public Cart get(User key);

    /**
     * Associate the user with the cart. If user already has a cart, then replace the old cart with this one.
     * @param key The key to associate the cart
     * @param value The cart to be associated
     */
    public void put(User key, Cart value);

    /**
     * @return All the users in the map
     */
    public List<User> getKeys();

    /**
     * @return All the carts in the map
     */
    public List<Cart> getValues();

    /**
     * Remove the user & cart from the map
     * @param key The user to remove
     * @return The cart associated with the user
     */
    public Cart remove(User key);
}
