import java.util.Scanner;

public class ConditionalControlStructures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your mark: ");

        int mark = input.nextInt();


        System.out.println(mark < 50 ? "Fail ICS3U" : "pass ics3u");
    }
}
