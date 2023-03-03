import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.text.NumberFormat;

public class CompoundInterest {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;

        double[] array = { 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0 };

        while (run) {
            try {
                System.out.print(ANSI_GREEN + "Enter amount to invest: $ " + ANSI_PURPLE);

                int amountToInvest = Integer.parseInt(input.next());

                try {
                    System.out.print(ANSI_GREEN + "Enter number of years to invest for:" + ANSI_PURPLE);
                    int years = Integer.parseInt(input.next());

                    int interestRateIndex = randInt(0, array.length - 1);
                    double interestRate = array[interestRateIndex];
                    System.out.println(ANSI_GREEN + "Interest rate: " + ANSI_PURPLE + interestRate);

                    NumberFormat money = NumberFormat.getCurrencyInstance();

                    double totalWithInterest = amountToInvest * Math.pow((1 + interestRate/100), years);
                    double onlyInterestAccumulated = totalWithInterest - amountToInvest;

                    System.out.println(ANSI_YELLOW + "Investing " + money.format(amountToInvest) + " at " + interestRate + "% for " + years + " years will earn " + money.format(onlyInterestAccumulated) + " interest.");
                    System.out.println(ANSI_YELLOW + "The total value of your investment will be " + money.format(totalWithInterest));

                } catch (Exception err) {
                    System.out.println("Please enter a valid integer");

                }

            } catch (Exception err) {
                System.out.println("Please enter a valid integer");
            }
        }

    }

    public static int randInt(int lowerBound, int upperBound) {
        Random rand = new Random();
        int randomNum = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        return randomNum;
    }
}
