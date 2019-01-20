public class MaxMin{
    private int max = Integer.MAX_VALUE;
    private int min = Integer.MIN_VALUE;

    public MaxMin(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public MaxMin() {

    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }


}