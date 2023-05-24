package Assessments;
/*
 * Daniel Martinez
 * Match 23rd, 2023
 * ICS3U
 * 
 * Game of chance.
 * User rolls their die to get a number then the computer generates a second number for them
 * The computer gets 2 randomly generated die rolls, and whoever gets a sum closer to 10 wins
 * HOWEVER if the user gets a sum higher than 10 he loses automatically, and same for the computer
 * if they both get a sum over 10 then they both lose
 * if they get the same number then the user spins a wheel of fortune and wins if they get an even number, 
 * otherwise they lose.
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class SecondUnitTest {
    public static void main(String[] args) {

        //create random object to generate the random numbers
        Random rand = new Random();

        //create scanner object to take in the number
        Scanner input = new Scanner(System.in);

        boolean userWon = false;

        System.out.println("WELCOME TO THE GAME OF CHANCE!!!!!!!!!!!!!\n");
        System.out.print("Please roll your die and enter your result: ");

        int userFirstNumber = input.nextInt();

        
        //generate the computer's first number
        int computerFirstNumber = rand.nextInt(6) + 1;

        System.out.println("Rolling the computer's die. I got " + computerFirstNumber);
        



        //generating the second numbers for the user and the computer
        int userSecondNumber = rand.nextInt(6) + 1;
        int computerSecondNumber = rand.nextInt(6) + 1;

        System.out.println("Generating your second die number: " + userSecondNumber);
        System.out.println("Generating my second die number: " + computerSecondNumber);


        //getting the sums of the numbers

        int userSum = userFirstNumber + userSecondNumber;
        int computerSum = computerFirstNumber + computerSecondNumber;


        System.out.println("The sum of your dice is " + userSum);
        System.out.println("The sum of my dice is " + computerSum);

        if (userSum > 10) {
            userWon = false;
            if (computerSum > 10) {
                //both lost
                userWon = false;
                System.out.println("Sorry bud, both of us lost since we got a sum of over 10");
            }
            //only user lost
            userWon = false;
            System.out.println("Sorry bud, you LOST since you got a sum of over 10");

        } else if (computerSum > 10) {
            if (userSum > 10) {
                //both lost
                userWon = false;
                System.out.println("Sorry bud, both of us lost since we got a sum of over 10");
            }

            //only user won
            userWon = true;
            System.out.println("CONGRATS! YOU WON since I got a number over 10 so i got automatically disqualified... :(");
        } else if (userSum == computerSum) {
            //both user and computer got same number so spin the wheel
            System.out.println("Spin the WEHEEL OF FORTUENEE");
            int wheelOfFortune = rand.nextInt(6) + 5;
            System.out.println("You spun a " + wheelOfFortune);

            if (wheelOfFortune % 2 == 0) {
                //user won
                userWon = true;
                System.out.println("That means that YOU WONN by getting an even number!!!");
            } else {
                //computer won
                userWon = false;
                System.out.println("Sorry bud, that means that you lost by getting an odd number!!!");
            }

        } else if (10 - userSum < 10 - computerSum) {
            //user won since they got a smaller difference
            userWon = true;
            System.out.println("That means that YOU WONN by getting a sum closer to 10!");

        } else {
            //computer won since they got a smaller difference than the user
            userWon = false;
            System.out.println("Sorry bud, the computer got a closer number to 10 so you LOST!!!!!");

        }


        input.close();




    }
}
