/*
 * Daniel Martinez
 * April 5th, 2023
 * ICS3U
 * 
 * Make a game that asks the user to enter a 4 digit number and award 3 points if the number is divisible by 3.
 * Use for and while loops, basically to determine that the number is 4 digits or more.
 * This game works for any number within the confines of the Java int variable type
 * 
 */

import java.util.Scanner;

public class ThirdUnitTest {
    public static void main(String[] args) {

        // create boolean for running game
        boolean runGame = true;

        // initialize scanner
        Scanner input = new Scanner(System.in);

        // Welcome the user
        System.out.println("--------------------------------------------");
        System.out.println("------- welcome to the game of weird -------");
        System.out.println("--------------------------------------------");

        // create score variable
        int score = 0;

        while (runGame) {

            System.out.println("Please enter at least a 4 digit number that you think is divisible by 3");
            System.out.println("-----------------------------------------------------------------------");

            int number = input.nextInt();

            if (number == 0) {
                // say points
                System.out.println("You guessed " + score + " numbers and earned " + score * 3 + " points");
                System.out.println("Thank you for playing the game of weird. Goodbye!");
                runGame = false;
            } else {

                // find out how many digits and while we're in this loop get the sum of digits
                // as well
                int numberOfDigits = 0;
                int sumOfDigits = 0;

                for (int i = number; i > 0; i /= 10) {
                    sumOfDigits += (i % 10);
                    numberOfDigits++;
                }

                // check if number is less than 4 to prompt user to enter another number
                if (numberOfDigits >= 4) {

                    if (sumOfDigits == 3 || sumOfDigits == 6 || sumOfDigits == 9) {
                        System.out.println("--------------------------------------------");
                        System.out.println("-- CONGRATS THAT NUMBER IS DIVISIBLE BY 3 --");
                        System.out.println("--------------------------------------------");
                        score++;
                        System.out.println("Your score is now " + score + "\n");

                    } else {

                        // divide original number then get sum of digits again
                        // System.out.println(sumOfDigits);

                        // reset sum of digits
                        int secondSumOfDigits = 0;

                        // count the sum of digits again
                        for (int i = sumOfDigits; i > 0; i /= 10) {
                            secondSumOfDigits += (i % 10);
                        }

                        if (secondSumOfDigits == 3 || secondSumOfDigits == 6 || secondSumOfDigits == 9) {
                            System.out.println("--------------------------------------------");
                            System.out.println("-- CONGRATS THAT NUMBER IS DIVISIBLE BY 3 --");
                            System.out.println("--------------------------------------------");
                            score++;
                            System.out.println("Your score is now " + score + "\n");
                        } else {
                            System.out.println("That number is not divisible by 3");
                        }

                    }

                } else {
                    System.out.println("That's less than 4 digits.\n");
                }

            }

        }

        input.close();

    }
}