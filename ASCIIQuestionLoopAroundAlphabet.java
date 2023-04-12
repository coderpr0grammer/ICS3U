import java.util.Scanner;

public class ASCIIQuestionLoopAroundAlphabet {
    public static void main(String[] args) {
        final int lowercaseLettersOffset = 97;

        Scanner input = new Scanner(System.in);

        int inputNumber = input.nextInt();

        int i = lowercaseLettersOffset + inputNumber - 1;
        while (i < lowercaseLettersOffset + inputNumber + 10) {
            System.out.print((char)i + " ");
            if (i < lowercaseLettersOffset + 26) {
                i++;
            } else {
                i = 0;
            }
        }

    }
}
