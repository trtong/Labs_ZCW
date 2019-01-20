import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Console {

    private Scanner in;

    public Console(Scanner in) {
        this.in = in;
    }

    public String echo() {
        return (in.nextLine());
    }
}


class testConsole {
    Scanner in = new Scanner("SomeData");


    @Test
    public void printEchoTest() {
        Console testConsole = new Console(this.in);

        Assert.assertEquals(testConsole.echo(), "SomeData");
    }
}