import java.util.Scanner;

public class Console {

    private static Scanner input = new Scanner(System.in);

    public static void print(String string){
        System.out.println(string);
    }

    public static void printInSameLine(String string){
        System.out.print(string);
    }

    public static String getStringInput(){
        return input.next();
    }

    public static Integer getIntegerInput(){
        return input.nextInt();
    }


    public static void pause(int t) {

        try {
            Thread.sleep(t); // In your case it would be: Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pause(int t, String s){

        try {
            Console.printInSameLine(s);
            Thread.sleep(t); // In your case it would be: Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pause(int t, String s, int loop) {
        for (int i = 0; i < loop; i++) {
            try {
                Console.printInSameLine(s);
                Thread.sleep(t); // In your case it would be: Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
