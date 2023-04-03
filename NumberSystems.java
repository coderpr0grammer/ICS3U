import java.util.Scanner;

public class NumberSystems {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input your number to convert from decimal to binary");

        int decimal = input.nextInt();
        // String binary = "";
        int binary = 0;
        int powerIndex = 1;

        for (int i = decimal; i != 0; i/=2) {
            // binary = i % 2 + binary;
            // System.out.print(i%2);

            binary += (i%2)*powerIndex;
            System.out.println("power index: " + powerIndex);

            powerIndex*=10;
        }

        System.out.println("this is the binary: " + binary);

        input.close();
    }
}