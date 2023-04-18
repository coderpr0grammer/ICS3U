import java.util.Scanner;

public class Strings4and2 {
    public static void main(String[] args) {
        boolean run = true;

        Scanner input = new Scanner(System.in);

        while (run) {
            System.out.println("Please enter a string");

            String inputtedString = input.nextLine();

            inputtedString = inputtedString.toLowerCase();

            int counter = 0;

            while (inputtedString.indexOf("hi") != -1) {
                inputtedString = inputtedString.replaceFirst("hi", " ");
                counter++;
            }

            System.out.println("Number of times the word 'hi' occurs in this string: " + counter);
        }
        

    }
}
