import java.util.Scanner;

public class IntegerParser {
    public static void main(String[] arguments) {
        Scanner input = new Scanner(System.in);

        boolean run = true;

        while (run) {

            String numberString = input.next();

            int number = parseInt(numberString);

            System.out.println(number);
        }

    }

    public static int parseInt(String numberString) {
        int number = 0;
        for (int i = numberString.length(); i > 0; i--) {
            int thisDigit = numberString.charAt(i - 1) - '0';
            int thisDigitPlace = Math.abs(i - numberString.length() - 1);
            number += thisDigit * Math.pow(10, thisDigitPlace - 1);
        }
        return number;
    }
}
