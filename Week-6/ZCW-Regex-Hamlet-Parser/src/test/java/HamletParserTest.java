import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Pattern ham = Pattern.compile("(H|h)(A|a)(M|m)(L|l)(E|e)(T|t)");
        String output = hamletParser.searchAndReplace(ham, "Leon");

        Assert.assertFalse(output.contains("Hamlet"));
        Assert.assertFalse(output.contains("HAMLET"));

    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern tariq = Pattern.compile("(H|h)(O|o)(R|r)(A|a)(T|t)(I|i)(O|o)");
        String output = hamletParser.searchAndReplace(tariq, "Tariq");

        Assert.assertFalse(output.contains("Horatio"));
        Assert.assertFalse(output.contains("HORATIO"));
    }

    @Test
    public void testFindHoratio() {
        Pattern horatio = Pattern.compile("(H|h)(O|o)(R|r)(A|a)(T|t)(I|i)(O|o)");
        String output = hamletParser.searchAndReplace(horatio, "Tariq");

        Assert.assertFalse(hamletParser.findMe(horatio, output));
    }

    @Test
    public void testFindHamlet() {
        Pattern hamlet = Pattern.compile("(H|h)(A|a)(M|m)(L|l)(E|e)(T|t)");
        String output = hamletParser.searchAndReplace(hamlet, "Leon");

        Assert.assertFalse(hamletParser.findMe(hamlet, output));

    }
}