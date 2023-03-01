/*
 * Daniel Martinez
 * ICS3U
 * Create a program that generates random integer values
 * between 25 and 50, including.
 */

import java.util.Random;

public class Random1 {
    public static void main(String[] args) {

        final int lowerBound = 25;
        final int upperBound = 50;

        System.out.println(randInt(lowerBound, upperBound));

    }

    public static int randInt(int lowerBound, int upperBound) {
        Random rand = new Random();
        int randomNum = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        return randomNum;
    }
}
