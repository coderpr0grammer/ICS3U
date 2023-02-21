import java.util.Random;

public class BingoCard {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("B      I      N      G      O");

        for (int i = 0; i < 5; i++) {
            for (int g = 0; g <= 4; g++) {
                if (g == 4) {
                    System.out.println(g);
                } else if (i == 2 && g == 2) {
                    System.out.print("0      ");
                } else {
                    System.out.print(rand.nextInt(50) + "     ");
                }
            }
        }
        
    }
}