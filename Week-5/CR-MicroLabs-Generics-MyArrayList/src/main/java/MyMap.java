public class MyMap<K, V> {
    private MyArrayList<MyEntry> myEntries = new MyArrayList<>();

    public MyMap() {

    }

    public void put(int i, String s) {
        myEntries.add(new MyEntry(i, s));
    }

    public MyArrayList<K> keySet() {

        MyArrayList<K> keys = new MyArrayList<>();
        Object[] entries = myEntries.getMyArrayList();
        for (int i = 0; i < myEntries.getSize(); i++) {
            MyEntry entry = (MyEntry) entries[i];
            keys.add((K)entry.getKey());
        }

        return keys;
    }

    public MyArrayList<V> valueSet() {
        MyArrayList<V> values = new MyArrayList<>();
        Object[] entries = myEntries.getMyArrayList();
        for (int i = 0; i < myEntries.getSize(); i++) {
            MyEntry entry = (MyEntry) entries[i];
            values.add((V)entry.getValue());
        }

        return values;
    }

    public V get(K key) {
        Object[] entries = myEntries.getMyArrayList();
        for (int i = 0; i < myEntries.getSize(); i++) {
            MyEntry entry = (MyEntry) entries[i];
            if (entry.getKey().equals(key)) {
                return (V) entry.getValue();
            }
        }
        return null;
    }

    public MyArrayList<MyEntry> getMyEntries() {
        return myEntries;
    }

}
