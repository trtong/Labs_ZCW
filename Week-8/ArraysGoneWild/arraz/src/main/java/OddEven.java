public class OddEven{
    private int odds = 0;
    private int evens = 0;

    private Integer[] evensArr;
    private Integer[] oddsArr;


    public OddEven(int odds, int evens) {
        this.odds = odds;
        this.evens = evens;
    }


    public OddEven() {
    }

    public Integer[] getEvensArr() {
        return evensArr;
    }

    public void setEvensArr(Integer[] evensArr) {
        this.evensArr = evensArr;
    }

    public Integer[] getOddsArr() {
        return oddsArr;
    }

    public void setOddsArr(Integer[] oddsArr) {
        this.oddsArr = oddsArr;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public int getEvens() {
        return evens;
    }

    public void setEvens(int evens) {
        this.evens = evens;
    }

    public void incrementOdd() {
        setOdds(getOdds() + 1);
    }

    public void incrementEven() {
        setEvens(getEvens() + 1);
    }
}