package org.zipcoder.store;

import java.util.*;

public class MyHashMap implements MyMap{
    // final field that doesn't change for any object
    private static final int BUCKET_SIZE = 15;

    // instance field that can only be set once. It is different for every Object
    private final List<Entry>[] entries;

    public MyHashMap(){
        entries = new List[BUCKET_SIZE];

        for(int i = 0; i < BUCKET_SIZE; i++) {
            entries[i] = new ArrayList<>();
        }
    }

    public List<Entry>[] getEntries() {
        return entries;
    }

    @Override
    public int size() {
        int count = 0;
        for (List<Entry> e: entries) {
            count += e.size();
        }
        return count;
    }

    @Override
    public boolean isEmptry() {
        return this.size() == 0;
    }

    @Override
    public Cart get(User key) {
            int bucket = bucketIndex(key);

            for (Entry e : getEntries()[bucket]) {
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        return null;
    }

    @Override
    public void put(User key, Cart value) {

//        if(get(key) != null) {
//            for (Entry e: getEntries()[bucketIndex(key)]) {
//                if (e.getKey().equals(key)) {
//                    e.setValue(value);
//                }
//            }
//        } else {
//            getEntries()[bucketIndex(key)].add(new Entry(key, value));
//        }

        if (!getKeys().contains(key)) {
            entries[bucketIndex(key)].add(new Entry(key, value));
        } else {
            for (Entry e: entries[bucketIndex(key)]) {
                if (e.getKey().equals(key)) {
                    e.setValue(value);
                }
            }
        }


    }

    @Override
    public List<User> getKeys() {
        List<User> keys = new ArrayList<>();
        for (List<Entry> list: getEntries()) {
            for (Entry e: list)
                keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public List<Cart> getValues() {
        List<Cart> values = new ArrayList<>();
        for (List<Entry> list:entries) {
            for (Entry e: list )
                values.add(e.getValue());
        }
        return values;
    }

    @Override
    public Cart remove(User key) {
        int bucket = bucketIndex(key);
        Entry e = new Entry(null, null);
        Iterator<Entry> iterator = entries[bucket].iterator();
        while (iterator.hasNext()) {
            e = iterator.next();
            if (e.getKey().equals(key)) {
                getEntries()[bucket].remove(e);
                break;
            }
        }
        return e.getValue();
    }

    private int bucketIndex(User key){
        return Math.abs(key.hashCode()) % entries.length;
    }
}
