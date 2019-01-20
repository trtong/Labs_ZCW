package io.zipcoder.casino;

import java.util.Scanner;

public class Console {

    private Scanner input;

    public Console() {
        input = new Scanner(System.in);
    }

    public Console(Scanner input) {
        this.input = input;
    }

    public void print(String string){
        System.out.println(string);
    }

    public void printInSameLine(String string){
        System.out.print(string);
    }

    public String printAndTakeString(String s) {
        System.out.println(s);
        return input.next();
    }

    public int printAndTakeInt(String s) {
        System.out.println(s);
        return input.nextInt();
    }

    public String getStringInput(){
        return input.next();
    }

    public Integer getIntegerInput(){
        return input.nextInt();
    }

    public void print(int slot1, int slot2, int slot3)  {
        System.out.printf("| %d | %d | %d |\n", slot1, slot2, slot3);
    }

    public void pause(int t) {

            try {
                Thread.sleep(t); // In your case it would be: Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void pause(int t, String s){

            try {
                System.out.print(s);
                Thread.sleep(t); // In your case it would be: Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public void pause(int t, String s, int loop) {
        for (int i = 0; i < loop; i++) {
            try {
                System.out.print(s);
                Thread.sleep(t); // In your case it would be: Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
