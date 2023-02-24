import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        // Fahrenheit to Celsius conversion
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println(fahrenheit + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius.");

        System.out.print("Enter temperature in Celsius: ");
        double celsius2 = input.nextDouble();

        // Celsius to Fahrenheit conversion
        double fahrenheit2 = celsius2 * 9 / 5 + 32;
        System.out.println(celsius2 + " degrees Celsius is equal to " + fahrenheit2 + " degrees Fahrenheit.");

        input.close();
    }
}
