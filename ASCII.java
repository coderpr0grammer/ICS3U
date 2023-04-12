import java.util.Scanner;

public class ASCII {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean run = true;

        final int capitalLettersOffset = 65;
        final int lowercaseLettersOffset = 97;

        while (run) {

            System.out.print("Please enter a number from 1 to 4: ");
            int inputNumber = input.nextInt();

            System.out.print("Please enter the number of characters to display: ");
            int inputNumber2 = input.nextInt();

            if (inputNumber2 > 13 || inputNumber2 < 1) {
                System.out.println("Invalid number of characters to display.");
            } else {

                if (inputNumber == 1) {

                    for (int i = capitalLettersOffset; i < capitalLettersOffset + inputNumber2 * 2; i += 2) {
                        System.out.print((char) i + " ");
                    }

                } else if (inputNumber == 2) {

                    for (int i = capitalLettersOffset + 1; i < capitalLettersOffset + inputNumber2 * 2; i += 2) {
                        System.out.print((char) i + " ");
                    }

                } else if (inputNumber == 3) {

                    for (int i = lowercaseLettersOffset; i < lowercaseLettersOffset + inputNumber2 * 2; i += 2) {
                        System.out.print((char) i + " ");
                    }

                } else if (inputNumber == 4) {

                    for (int i = lowercaseLettersOffset + 1; i < lowercaseLettersOffset + inputNumber2 * 2; i += 2) {
                        System.out.print((char) i + " ");
                    }

                } else if (inputNumber == 0) {
                    System.out.println("Goodbye.");
                    run = false;
                } else {
                    System.out.println("Invalid.");
                }

                System.out.println("");

            }

        }

    }
}
