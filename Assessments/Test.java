package Assessments;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random rand = new Random();
        String[] words = { "hello", "farewell", "goodbye", "pneumonoultramicroscopicsilicovolcanoconiosis", "wonderful", "wordle", "computer", "science"  };
        int index = rand.nextInt(words.length);
        String mysteryWord = words[index].toLowerCase();

        System.out.println(mysteryWord);

        System.out.println(index);
 
    }
    
}
