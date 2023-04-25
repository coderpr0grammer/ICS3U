package Assessments;

/*
 * Daniel Martinez
 * Match 23rd, 2023
 * ICS3U
 * 
 * A game of wordle but it tells you if the word you guessed is before or after the mystery word alphabetically, using the magical .compareTo() method 🤓
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class FourthUnitTest {
    public static void main(String[] args) {

        // initialize scanner, rungame boolean and array of possible words and number of
        // tries

        Scanner input = new Scanner(System.in);

        boolean runGame = true;
        
        //add more words here as needed if you wanna have a wider selection of random words to choose from. or use the openai api to generate an array of words and use them in the game
        String[] words = { "hello", "farewell", "goodbye", "pneumonoultramicroscopicsilicovolcanoconiosis", "wonderful", "wordle", "computer", "science"  };

        // initialize random object

        Random rand = new Random();

        String mysteryWord = words[rand.nextInt(words.length)].toLowerCase();

        int numberOfTriesLeft = 5;

        // greets user

        System.out.println("-----------------------------------------");
        System.out.println("| Welcome to the walmart quality Wordle |");
        System.out.println("-----------------------------------------");

        // runs the game loop

        while (runGame) {
            
            System.out.print("\nYou have " + numberOfTriesLeft + " ");
            //sadly not ternary operator cuz apparently that's not allowed so if statement just to make it gramatically correct
            if (numberOfTriesLeft > 1) {
                System.out.print("guesses");
            } else {
                System.out.print("guess");
            }
            System.out.println(" left. Enter your guess: ");
            System.out.print("-> ");

            String guess = input.next().toLowerCase();

            if (guess.length() >= 5) {
                // string good if longer or equal to 5 chars

                if (guess.length() > mysteryWord.length()) {
                    // guess is longer than the mystery word
                    System.out.println("That guess is too long.");
                } else if (guess.length() < mysteryWord.length()) {
                    // guess is shorter than mystery word
                    System.out.println("That guess is too short.");
                } else {

                    // guess is exactly as long as the mystery word

                    // lexographically compare the strings using the .compareTo() method 🤓
                    int ASCIIDifference = mysteryWord.compareTo(guess);

                    // checking with ascii and equals method for redundancy in the system.
                    if (ASCIIDifference == 0 || mysteryWord.equals(guess)) {

                        // you guessed it
                        System.out.println("\nYou are correct!");
                        System.out.println("Thank you for playing the ");
                        System.out.println("--------------------------");
                        System.out.println("| walmart quality Wordle |");
                        System.out.println("--------------------------");
                        runGame = false;

                    } else {

                        // guess incorrect

                        // just a little container for the question mark exclamation dash thing
                        System.out.print("[ ");

                        // question mark exclamation dash thing. tells you what letters were right/wrong
                        for (int i = 0; i < guess.length(); i++) {
                            if (guess.charAt(i) == mysteryWord.charAt(i)) {
                                System.out.print("!");
                            } else if (mysteryWord.contains(guess.charAt(i) + "")) {
                                System.out.print("?");
                            } else {
                                System.out.print("-");
                            }
                            System.out.print(' ');
                        }

                        // closes container for the question mark exclamation dash thing
                        System.out.print(" ] ");

                        if (ASCIIDifference > 0) {
                            // mystery word ascii is greater than the guess ascii
                            System.out.println("Hint: the mystery word is alphabetically after your guess");
                        } else if (ASCIIDifference < 0) {
                            // mystery word ascii is less than the guess ascii
                            System.out.println("Hint: the mystery word is alphabetically before your guess");
                        }

                    }

                }

                // subtracts your number of guesses each time
                numberOfTriesLeft--;

                if (numberOfTriesLeft < 1) {
                    System.out.println("\nYou lost!!! The mystery word was:");
                    System.out.println("-> " + mysteryWord);
                    runGame = false;
                }
            } else {
                // string is too short (less than 5 chars)
                System.out.println("That guess is too short. Please enter a word at least 5 characters long.\n");
            }

        }

        // closes input so no resources are leaked
        input.close();

    }
}
