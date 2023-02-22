/*
 * Receiving user input using Scanner in Java
 */

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        boolean run = true;
        while (run == true) {
            int age;
            Scanner input = new Scanner(System.in);
            System.out.println("How old are you?");

            try {
                age = Integer.parseInt(input.next());
                System.out.println("Your age is " + age);

                run = false;
            } catch (Exception e) {
                System.out.println("Sorry, please enter a valid integer");
            }
        }

    }
}
