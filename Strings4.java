import java.util.Scanner;

public class Strings4 {
    public static void main(String[] args) {
        boolean run = true;
        Scanner input = new Scanner(System.in);

        while (run) {
            System.out.println("Input your string");

            String inputtedString = input.nextLine();

            System.out.println(inputtedString);

            int counter = 0;

            String toOutputString = "";

            while (counter < inputtedString.length()) {
                toOutputString = toOutputString + inputtedString.charAt(counter)  + "" + inputtedString.charAt(counter) + "";
                counter++;
            }

            System.out.println("Your final string: " + toOutputString);

            

        }
    }
}