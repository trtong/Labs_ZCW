package org.zipcoder.store;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListMap implements MyMap {
    // instance field that is intialize to an ArrayList
    private List<Entry> entries = new ArrayList<>();

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmptry() {
        return (this.size() == 0);
    }

    @Override
    public Cart get(User key) {
        // find the cart associate with the key

            for (Entry e: entries) {
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        return null;
    }

    @Override
    public void put(User key, Cart value) {
        if (get(key) == null) {
            entries.add(new Entry(key, value));
        } else {
            for (Entry e: entries) {
                if (e.getKey().equals(key)) {
                    e.setValue(value);
                }
            }
        }
    }

    @Override
    public List<User> getKeys() {
        // get all the keys in the map

        List<User> idSet = new ArrayList<>();

        for (Entry e:entries) {
            idSet.add(e.getKey());
        }
        return idSet;
    }

    @Override
    public List<Cart> getValues() {
        List<Cart> valueSet = new ArrayList<>();
        for (Entry e: entries) {
            valueSet.add(e.getValue());
        }
        return valueSet;
    }

    @Override
    public Cart remove(User key) {
        Entry eTemp = null;

        for (Entry e: entries) {
            if (e.getKey().equals(key)) {
                eTemp = e;
                entries.remove(e);
                return eTemp.getValue();
            }
        }
        return null;
    }
}
