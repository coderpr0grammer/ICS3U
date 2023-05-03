package Assessments;

/*
 * Daniel Martinez
 * May 3rd, 2023
 * ICS3U
 * 
 * Hiding word letters using your special character of choice
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class FifthUnitTest {
    public static void main(String[] args) {
        Random r = new Random();
        int n;
        String str1, str2;
        // Allow the user to play multiple times or Exit when they want

        while (play()) {
            // take a string that has more than 1 character
            str1 = phraseString();

            // //take a string that has specified character length
            // //for this program, it will alway be 1
            str2 = phraseString(1);

            // //generates a random marker out of 3: * + -
            char marker = generateMarker();

            // //replaces all the characters that are NOT str2 in str1 with marker
            hideCharacters(str1, str2, marker);
        }
        System.out.println("Goodbye");
    }

    public static boolean play() {
        //initializes scanner
        Scanner input = new Scanner(System.in);

        //options in a string
        String options = "exit play";

        System.out.print("Play or Exit?? ");

        //gets choice no matter case
        String choice = input.next().toLowerCase();

        //checks if its a valid option, if not keeps asking
        while (!options.contains(choice)) {
            System.out.print("Play or Exit?? ");

            choice = input.next().toLowerCase();
        }

        //returns true if play false if exit
        if (choice.equals("play")) {
            return true;
        } else if (choice.equals("exit")) {
            return false;
        }

        return false;

    }

 


    //HERE I OVERLOADED THE METHODS TO HAVE ONE THAT WORKS WITH NO ARGUMENTS PASSED AND ONE THAT ACCEPTS AN INT
    //this one just validates it so that it's longer 2 chars or more
    public static String phraseString() {
        Scanner input = new Scanner(System.in);

        System.out.print("String 1: ");

        String inputtedString = input.next().toLowerCase();

        while (inputtedString.length() < 2) {
            System.out.println("String 1: ");

            inputtedString = input.next().toLowerCase();
        }

        return inputtedString;
        
        
    }

    //this method lets you specify the length of the character you need and will work for any length, not just 1
    public static String phraseString(int length) {
        Scanner input = new Scanner(System.in);

        System.out.print("String 2: ");


        String inputtedString = input.next().toLowerCase();

        while (inputtedString.length() > length) {
            System.out.print("String 2: ");

            inputtedString = input.next().toLowerCase();
        }

        return inputtedString;
        
    }

    //this method takes in the first char that you inputted
    public static char generateMarker() {
        Scanner input = new Scanner(System.in);


        System.out.print("Marker: ");


        char marker = input.next().charAt(0);

        return marker;

    }

    //hides the characters
    public static void hideCharacters(String str1, String str2, char marker) {

        int i = 0;

        String toPrint = "";

        while (i < str1.length()) {
            //loops through the string
            if (str1.charAt(i) == str2.charAt(0)) {
                // if the letter matches just leave it
                toPrint += str1.charAt(i);
            } else {
                //if the letter does not match replace it with the marker
                toPrint += marker;
            }
            i++;
        }
        System.out.println(toPrint);
    }


}
