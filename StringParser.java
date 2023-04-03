import java.util.Scanner;

public class StringParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("input your number to convert to a string: ");

        int mod, number = input.nextInt(), counter = 0;
        String stringNumber = "";
        // int digits = (int)(Math.log10(number)+1);

        while(number > 0) {
            mod = number % 10;
            System.out.println("Digits at position "+counter+":"+ mod);
            number = number / 10;
            stringNumber = mod + stringNumber;
            counter--;
        }

        
        // System.out.println(stringNumber);
    }
    
}
