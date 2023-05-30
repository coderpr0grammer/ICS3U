package MastermindFinalProject;

import java.util.Scanner;
import java.util.Random;
import MastermindFinalProject.Timer;

public class FinalProjectMastermind {
    public static void main(String[] args) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        String[] colors = { ANSI_BLACK, ANSI_GREEN, ANSI_YELLOW };

        Scanner input = new Scanner(System.in);

        boolean runGame = true;

        // System.out.print("\033[108m\033[30m");
        
        System.out.println("----------------------------");
        System.out.println("| Welcome to MASTERMIND 🧠 |");
        System.out.println("----------------------------");
        System.out.println("-");

        while (runGame) {


            Timer timer = new Timer();
            Random rand = new Random();

            int code = rand.nextInt(10000);

            System.out.println("code: " + code);

            System.out.println(
                    "| Your mission, if you choose to accept it, will be to guess the 4️⃣ \sdigit code to defuse the bomb 💣");
            System.out.println(
                    "| 🚀 Are you ready?");
            System.out.println(
                    "| ⚡ Type anything and press enter to start");
            System.out.println(
                    "| 🚪 Enter 0 to exit");
            System.out.print("|-> ");

            String option = input.next();

            // Thread timerThread = new Thread(() -> {
            // timer.start(10);
            // timer.displayTimer();
            // });

            // Thread inputThread = new Thread(() -> {
            // System.out.println("");
            // String guess = input.nextLine();
            // System.out.println("Received input: " + guess);

            // });

            if (!option.equalsIgnoreCase("0")) {
                // startGame

                boolean askForNumbers = true;

                while (askForNumbers) {

                    System.out.println("enter your first guess:");
                    int guess = input.nextInt();

                    int guessCopy = guess;

                    int mod;
                    String stringNumber = "";
                    // int digits = (int)(Math.log10(number)+1);

                    while (guessCopy > 0) {
                        mod = guessCopy % 10;
                        guessCopy = guessCopy / 10;
                        stringNumber = mod + stringNumber;
                    }

                    if (stringNumber.length() == 4) {
                        // valid input

                        System.out.print("\r\r");

                        for (int i = 0; i < stringNumber.length(); i++) {
                            System.out.print(colors[rand.nextInt(3)]);
                            System.out.print(stringNumber.charAt(i) + " ");
                        }

                        System.out.println(ANSI_RESET);

                    } else {
                        // too short input

                        System.out.println("You need to enter a 4 digit number");
                    }

                    // for (int i = 0; i < 5; i++) {

                    // timerThread.start();
                    // inputThread.start();

                    // try {
                    // timerThread.join();
                    // inputThread.join();
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                    // }

                    System.out.println("Game over.");
                }

            } else {
                // exit
                runGame = false;
            }

        }

    }

}
