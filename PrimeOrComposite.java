import java.util.Scanner;

public class PrimeOrComposite {
    public static void main(String[] args) {

        boolean run = true;

        while (run) {

            Scanner input = new Scanner(System.in);

            int index = 2;

            System.out.println("Input your next integer to check");

            int number = input.nextInt();

            if (number < 0) {
                run = false;
            } else {

                boolean isPrime = true;

                while (index < number) {
                    if (number % index == 0) {
                        isPrime = false;
                    }
                    index++;
                }

                if (isPrime) {
                    System.out.println("This number is prime");
                } else {
                    System.out.println("This number is composite");
                }
            }

        }
    }
}
