import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean run = true;

        while (run) {

            System.out.print("Enter your binary number to convert to decimal: ");

            int number = input.nextInt();

            int digit;

            int decimal = 0;

            int power = 0;

            while (number > 0) {
                digit = number % 10;

                if (digit == 0 || digit == 1) {
                    number = number / 10;

                    decimal += digit * Math.pow(2, power);

                    power++;

                } else {

                    System.out.println("Please enter a valid binary number. Only ones and zeroes allowed.");
                    break;

                }

            }

            System.out.println("Your final decimal number is: " + decimal);
        }

        input.close();
    }
}
