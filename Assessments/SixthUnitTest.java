package Assessments;

/*
 * Daniel Martinez
 * May 16th, 2023
 * ICS3U
 * 
 * You enter a list of numbers and I determine if there is a linear pattern or not.
 * 
 */

import java.util.Scanner;

public class SixthUnitTest {
    public static void main(String[] args) {

        // initialize scanner and rungame boolean
        boolean runGame = true;
        Scanner input = new Scanner(System.in);

        while (runGame) {
            System.out.print("Enter numbers or enter 0 to exit: ");

            // get numbers in one line
            String numbersString = input.nextLine();

            // press 0 to exit the game
            if (numbersString.equals("0")) {
                // user entered 0
                System.out.println("thanks for playing!");
                runGame = false;
            } else {

                // convert the string entered to an array of numbers
                int[] numbersArray = toArray(numbersString);

                // input validation, checks if the set of numbers is big enough or not
                if (numbersArray.length > 4) {

                    // get the first difference
                    int firstDifference = numbersArray[1] - numbersArray[0];

                    // boolean to know if it's a pattern or not
                    boolean pattern = true;

                    for (int i = 0; i < numbersArray.length - 1; i++) {
                        if (numbersArray[i + 1] - numbersArray[i] != firstDifference) {
                            // if any term does not adhere to the first difference, it is notn a pattern
                            // System.out.println("not a pattern");
                            pattern = false;
                        }
                    }

                    if (pattern) {
                        // there is a pattern
                        System.out.println("There is a pattern!");

                        // ask for the next number
                        System.out.println("Enter the next number: ");
                        int nextInt = input.nextInt();
                        input.nextLine();

                        // compare the expected next term to the inputted term
                        if (numbersArray[numbersArray.length - 1] + firstDifference == nextInt) {
                            System.out.println("That's correct!");
                        } else {
                            System.out.println("That's incorrect!");
                        }

                        // put the appropriate operator if it's positive or negative
                        if (firstDifference > 0) {
                            System.out.println("The pattern was +" + firstDifference + " to the next term");
                        } else {
                            System.out.println("The pattern was " + firstDifference + " to the next term");
                        }
                    } else {

                        // no pattern, gets the average/mean
                        System.out.println("There is no pattern!");

                        double output = 0;

                        for (int i = 0; i < numbersArray.length; i++) {
                            output += numbersArray[i];
                        }

                        output = output / numbersArray.length;

                        System.out.println("The average of the numbers is " + output);
                    }

                } else {
                    System.out.println("please enter at least 5 numbers: ");

                }

            }
        }

        input.close();

    }

    public static int[] toArray(String inputtedString) {
        // split the numbers by a space
        String[] stringArray = inputtedString.split(" ");

        // create a new array with the length of number of numbers
        int[] array = new int[stringArray.length];

        if (inputtedString.length() > 0) {

            for (int i = 0; i < stringArray.length; i++) {
                //parse the integer from the string and set it in the array variable
                array[i] = Integer.parseInt(stringArray[i]);
            }
        }

        //return the array to the main
        return array;
    }

    /*
    //tried to make it without the .split method but it's pretty complicated and it almost worked but with a few bugs
     * public static int[] toArray(String inputtedString) {
     * 
     * int[] array = new int[inputtedString.split(" ").length];
     * 
     * // System.out.println(inputtedString.indexOf(" "));
     * 
     * for (int i = 0; inputtedString.indexOf(" ") != -1; i++) {
     * // System.out.println("loop" + i);
     * System.out.println(inputtedString.substring(i,inputtedString.indexOf(" ")));
     * System.out.println(inputtedString);
     * array[i] =
     * Integer.parseInt(inputtedString.substring(i,inputtedString.indexOf(" ")));
     * inputtedString = inputtedString.replaceFirst(" ", "");
     * 
     * }
     * 
     * for(int i = 0; i<array.length; i++) {
     * // System.out.println(array[i]);
     * }
     * 
     * return array;
     * }
     */
}
