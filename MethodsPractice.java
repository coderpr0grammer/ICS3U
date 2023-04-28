import java.util.Scanner;
import java.util.Random;

public class MethodsPractice {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String answerKey = "";
        String answerUser = "";
        int size;
        // Ask how many questions there are

        size = getSize();
        // String with options: a b c d e.

        // display("If answer key has the answer a b b d. Then the string will be:
        // “abbd”");
        answerKey = createKey(size);
        // Valid answers are: a, b, c, d, e, ?(no answer)
        answerUser = getStudentAnswer(size);

        display("\nAnswer key is: " + answerKey);
        display("Your answers are: " + answerUser);
        // Points allocate as follows: correct:4pts, wrong:-1pts, no answer:0pts.
        // Should not get score less than 0

        int score = getScore(answerKey, answerUser);
        System.out.println("Your score is: " + score + "/" + size * 4);

    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static int getSize() {
        System.out.print("How many questions are there? ");
        int size = sc.nextInt();

        while (size < 1) {
            System.out.print("How many questions are there? ");
            size = sc.nextInt();

        }

        return size;
    }

    public static String createKey(int size) {
        Random rand = new Random();
        String options = "abcde";
        String key = "";
        int counter = 0;
        while (counter < size) {
            key += options.charAt(rand.nextInt(5));
            counter++;
        }
        return key;
    }

    public static String getStudentAnswer(int size) {

        int counter = 1;
        String studentAnswer = "";

        while (counter < size + 1) {
            display("Enter answer to " + counter + ": ");
            char answerChar = sc.next().charAt(0);

            int counter2 = 0;
            String options = "abcde?";

            if (!options.contains(answerChar + "")) {
                display("Invalid.");
            } else {
                studentAnswer+=answerChar;
                counter++;
            }
                
        }

        return studentAnswer;
    }

    public static int getScore(String answerKey, String studentAnswers) {
        int score = 0;
        int counter = 0;

        while (counter < answerKey.length()) {
            if (answerKey.charAt(counter) == studentAnswers.charAt(counter)) {
                score += 4;
            } else if (studentAnswers.charAt(counter) == '?') {
                ;
            } else {
                score--;
            }

            counter++;
        }

        return score;
    }
}
