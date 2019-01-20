
import java.util.Arrays;

public class MyArrayList<T> {
    private final static int INITIAL_SIZE = 0;
    private Object[] myArrayList;
    private int size;

    public MyArrayList() {
        this(INITIAL_SIZE);
        this.size = myArrayList.length;
    }

    public MyArrayList(int size) {
        this.myArrayList = new Object[size];
        this.size = size;
    }

    public T[] getMyArrayList() {
        return (T[]) myArrayList;
    }

    public void add(T data) {

        Object[] tempArray1 = new Object[getSize() + 1];
        copy(tempArray1, myArrayList);
        tempArray1[getSize()] = data;
        myArrayList = tempArray1;
        setSize(getSize() + 1);

    }

    public void copy(Object[] newArr, Object[] src) {
        for (int i = 0; i < src.length; i++) {
            newArr[i] = src[i];
        }
    }

    public void add(int index, T data) {
        Object[] newArray = new Object[getSize()];
        Object[] firstArray = Arrays.copyOfRange(myArrayList, 0, index);
        for (int i = 0; i < firstArray.length; i++) {
            newArray[i] = firstArray[i];
        }

        Object[] secondArray = Arrays.copyOfRange(myArrayList, index, getSize());
        int count = 1;
        newArray[index] = data;
        for (int i = index + 1; i < newArray.length; i++) {

            newArray[i] = secondArray[count++];
        }

        setSize(newArray.length);
        myArrayList = newArray;

    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void resetSize() {
        this.size = INITIAL_SIZE;
    }

    public void decreaseSize() {
        this.size--;
    }

    public T get(int i) {
        return (T) this.myArrayList[i];
    }

    public void remove(T data) {
        // removes first instance of that data

        Object[] smallerArray = new Object[this.myArrayList.length - 1];
        int counter = 0;
        for (int i = 0; i < myArrayList.length; i++) {

            if (!myArrayList[i].equals(data)) {
                smallerArray[counter++] = myArrayList[i];
            }
        }

        this.myArrayList = smallerArray;
        decreaseSize();
    }

    public void set(int i, T data) throws ArrayIndexOutOfBoundsException {
        try {
            this.myArrayList[i] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("That index is not in my array list!");
        }
    }

    public void clear() {
        Object[] tempArr = new Object[INITIAL_SIZE];
        resetSize();

        myArrayList = tempArr;
    }

    public boolean isEmpty() {
        return (getSize() == 0);
    }

    public boolean contains(T data) {

        for (int i = 0; i < getSize(); i++) {
            if (myArrayList[i].equals(data))
                return true;
        }
        return false;
    }


    public int indexOf(T findMe) {
        int count = -1;
        for (Object o: myArrayList) {
            count++;
            if (o.equals(findMe)) {
                return count;
            }
        }
        return count;
    }

    public void setMyArrayList(Object[] myArrayList) {
        this.myArrayList = myArrayList;
    }
}
