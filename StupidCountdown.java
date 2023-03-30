import java.util.Scanner;

public class StupidCountdown {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("you will die in 10 seconds. just you have to press enter to make time go by each time.");

        for (int i = 10; i > 0; i--) {
            System.out.println("There is " + i + " left");
            System.out.println("Press Enter");
            input.nextLine();
        }
        System.out.println("you died");
        
        input.close();
    }
}
