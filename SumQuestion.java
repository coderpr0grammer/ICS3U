import java.util.Scanner;

public class SumQuestion {
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("please enter a number to find the sum of its digits");
            Scanner input = new Scanner(System.in);

            int number = input.nextInt();


            if (number > 10000) {
                System.out.println("Please enter a number smaller than 10,000");
            } else {
                int thousands = number /1000;
                int hundreds = number % 1000 / 100;
                int tens = number % 100 / 10;
                int ones = number % 10;
        
                int total = thousands + hundreds + tens + ones;
        
                System.out.println("The total of the digits is " + total);
            }
        }
    }

}
