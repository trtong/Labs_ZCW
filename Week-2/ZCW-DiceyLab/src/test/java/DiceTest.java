import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    public DiceTest() {

    }

    @Test
    public void testTossAndSumOneDie() {

        int[] oneDieResults = new int[] {1, 2, 3, 4, 5, 6};
        Dice testDie = new Dice(1);

        boolean expected = true;

        boolean findToken = false;

        int actualRoll = testDie.tossAndSum();

            for (int side : oneDieResults) {
                if (side == actualRoll) {
                    findToken = true;
                    break;
                 }
            }
        Assert.assertTrue(findToken);
    }
}
