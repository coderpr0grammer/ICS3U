import java.util.Scanner;

public class ProveMsKatsmanWrong {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        String stringNumber = parseStringFromInt(number);

        System.out.println("This is the string version of that number: "  + stringNumber);
        System.out.print("is this really a string? ");
        System.out.println(stringNumber instanceof String);

        input.close();

    }

    public static String parseStringFromInt(int number) {

        int mod;
        String stringNumber = "";
        // int digits = (int)(Math.log10(number)+1);

        while (number > 0) {
            mod = number % 10;
            number = number / 10;
            stringNumber = mod + stringNumber;
        }

        return stringNumber;
        // System.out.println(stringNumber);
    }

}
