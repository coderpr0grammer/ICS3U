/*
 * Daniel Martinez
 * Februrary 27th, 2023
 * ICS3U
 * 
 * Write the program that allows the user to input how many pens and pencils the user wants to purchase. 
 * Each pen weighs 85g, and each pencil is 60g. 
 * For shipping, each box can only hold 0.5kg of content. 
 * Each box shipped costs $25.00 plus 10% tax. User is only charged for the boxes.
 * Display a final receipt with all the detail included
 * 
 */
import java.text.NumberFormat;
import java.util.Scanner;

public class FirstUnitTest {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        boolean run = true;

        final int pencilWeight = 85;
        final int penWeight = 60;

        final double maxWeight = 500.0;

        final double boxCost = 25.00;


        while (run) {

            try {
                System.out.println("Please enter your number of pencils you want to buy:");

                int numberOfPencils = Integer.parseInt(input.next());
                System.out.println("You entered " + numberOfPencils + " pencils");

                try {
                System.out.println("Please enter your number of pens you want to buy:");

                    int numberOfPens = Integer.parseInt(input.next());
                    System.out.println("You entered " + numberOfPens + " pens");

                    System.out.println("-------------------------------");


                    int totalWeight = numberOfPencils * pencilWeight + numberOfPens * penWeight;

                    int numberOfBoxes = (int)Math.ceil(totalWeight / maxWeight);

                    NumberFormat money = NumberFormat.getCurrencyInstance();

                    String subtotal = money.format(numberOfBoxes * 25);

                    double totalPrice = 25 * numberOfBoxes * 1.1;

                    //print receipt

                    System.out.println("---Your receipt---");
                    System.out.println("Pens: " + numberOfPens);
                    System.out.println("Pencils: " + numberOfPencils);
                    System.out.println("Number of boxes: " + numberOfBoxes);
                    System.out.println("Subtotal: " + subtotal);
                    System.out.println("Grand total: " + money.format(totalPrice));

                    System.out.println("----Thank you for shopping at Pens and Pencils!----");
                    input.close();
                    run = false;
    
                } catch (Exception error) {
                    System.out.println("Sorry, please enter a valid integer");
                }

            } catch (Exception error) {
                System.out.println("Sorry, please enter a valid integer");
            }
            
        }


    }
}