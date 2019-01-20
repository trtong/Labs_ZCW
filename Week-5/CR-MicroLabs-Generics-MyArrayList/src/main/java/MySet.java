import java.util.Iterator;

public class MySet<T> extends MyArrayList<T> implements Iterable<T> {

    public MySet() {
    }

    private class SetIterator implements Iterator<T> {
        int current = 0;

        public boolean hasNext() {
            if (current < getSize()) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return (T) getMyArrayList()[current++];
        }

        @Override
        public void remove() {
            // removes current -1
            if (current < getSize()) {
                MySet.this.remove((T) getMyArrayList()[current]);
            }

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator();
    }

    public boolean hasItem(T data) {
        for (Object o: getMyArrayList()) {
            if (o.equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T data){
        // Sets cannot have duplicates
        boolean hasItem = hasItem(data);

        if (!hasItem) {
            Object[] tempArray1 = new Object[getSize() + 1];
            copy(tempArray1, getMyArrayList());
            tempArray1[getSize()] = data;
            setMyArrayList(tempArray1);
            setSize(getSize() + 1);
        }
    }
}
