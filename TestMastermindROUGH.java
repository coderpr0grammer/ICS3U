import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestMastermindROUGH {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_GUESSES = 10;
    private static final char[] COLORS = { 'R', 'G', 'B', 'Y', 'O', 'P' };

    private char[] secretCode;
    private List<char[]> guesses;
    private List<String> feedbacks;

    public TestMastermindROUGH() {
        secretCode = generateSecretCode();
        guesses = new ArrayList<>();
        feedbacks = new ArrayList<>();
    }

    private char[] generateSecretCode() {
        char[] code = new char[CODE_LENGTH];
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(COLORS.length);
            code[i] = COLORS[index];
        }
        return code;
    }

    private boolean isValidGuess(String guess) {
        if (guess.length() != CODE_LENGTH) {
            return false;
        }
        for (char c : guess.toCharArray()) {
            if (!Arrays.toString(COLORS).contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    private String getFeedback(char[] guess) {
        int blackPegs = 0;
        int whitePegs = 0;
        boolean[] visited = new boolean[CODE_LENGTH];
        boolean[] correctGuess = new boolean[CODE_LENGTH];

        for (int i = 0; i < CODE_LENGTH; i++) {
            if (guess[i] == secretCode[i]) {
                blackPegs++;
                visited[i] = true;
                correctGuess[i] = true;
            }
        }

        for (int i = 0; i < CODE_LENGTH; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = 0; j < CODE_LENGTH; j++) {
                if (!visited[j] && !correctGuess[j] && guess[i] == secretCode[j]) {
                    whitePegs++;
                    visited[j] = true;
                    break;
                }
            }
        }

        return "Black pegs: " + blackPegs + ", White pegs: " + whitePegs;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Mastermind!");

        for (int i = 1; i <= MAX_GUESSES; i++) {
            System.out.print("Enter your guess (4 colors: R, G, B, Y, O, P): ");
            String guess = scanner.nextLine().toUpperCase();

            while (!isValidGuess(guess)) {
                System.out.print("Invalid guess! Enter your guess again: ");
                guess = scanner.nextLine().toUpperCase();
            }

            char[] guessArray = guess.toCharArray();
            guesses.add(guessArray);
            String feedback = getFeedback(guessArray);
            feedbacks.add(feedback);

            System.out.println("Feedback: " + feedback);

            if (Arrays.equals(guessArray, secretCode)) {
                System.out.println("Congratulations! You guessed the secret code in " + i + " guesses.");
                return;
            }
        }

        System.out.println("Sorry, you ran out of guesses. The secret code was: " + Arrays.toString(secretCode));
    }

    public static void main(String[] args) {
        TestMastermindROUGH game = new TestMastermindROUGH();
        game.play();
    }
}
