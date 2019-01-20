public class TwoSmallest {
    private int smallest = Integer.MIN_VALUE;
    private int second_smallest= Integer.MIN_VALUE;

    public TwoSmallest() {
    }

    public TwoSmallest(int smallest, int second_smallest) {
        this.smallest = smallest;
        this.second_smallest = second_smallest;
    }

    public int getSmallest() {
        return smallest;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public int getSecond_smallest() {
        return second_smallest;
    }

    public void setSecond_smallest(int second_smallest) {
        this.second_smallest = second_smallest;
    }
}
