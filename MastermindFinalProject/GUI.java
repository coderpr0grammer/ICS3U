
/*
 * Daniel Martinez
 * June 12th, 2023
 * ICS3U
 * 
 * Main GUI file to house all of the graphical user interface functionality, game logic and initialization
*/

//part of the mastermindFinalProject folder
package MastermindFinalProject;

//import all of the necessary event listener methods and Java Swing components
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Random;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUI {

  // setup Java Swing objects
  public static JFrame f = new JFrame("You can't leave this game");
  public static Container panel = f.getContentPane();
  public static Stopwatch stopwatch = new Stopwatch();
  public static Stopwatch explosionStopwatch = new Stopwatch();
  public static JLabel label = new JLabel();
  public static JTextField textField = new JTextField(20);

  // initialize a new instance of my custom java swing element that lets the
  // textarea be scrollable
  public static ScrollableTextarea textArea = new ScrollableTextarea();

  // initialize game life cycle variables
  public static int guessesRemaining = 10;
  public static boolean gameStarted = false;
  public static boolean gameEnded = false;
  public static final int secondsToPlay = 59;
  public static int code;
  public static String codeString;
  public static Random rand;

  /*
   * pre: nothing
   * Does: create a method that resets an instance of a stopwatch
   * then it creates a task to run every 10 milliseconds to move around the screen
   * like an explosion
   * post: returns nothing.
   */
  public static void explosionAnimation() {
    // reset timer
    explosionStopwatch.reset();

    // create timer task
    TimerTask task = new TimerTask() {
      // method to run every period
      public void run() {
        // start a timer to last 3 seconds
        explosionStopwatch.start(3);

        // check if the timer is not over, then move around the screen randomly
        if (explosionStopwatch.getElapsedTime() / 1000 <= explosionStopwatch.timerLimit) {

          f.setSize(200, 200);
          f.setLocation(rand.nextInt(500), rand.nextInt(500));
        } else {
          // otherwise stop time timer and set it back to a reasonable size
          explosionStopwatch.pause();
          f.setSize(400, 500);

        }
      }
    };

    // Schedule the task to run every 10 milliseconds
    java.util.Timer timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, 0, 10);
  }

  // create a timer task to display the timer
  // pre: nothing required as parameters, timer just must be running
  // post: updates the label
  public static void displayTimer() {
    TimerTask task = new TimerTask() {
      // method to run every 10 millis
      public void run() {
        // if the timer is running
        if (stopwatch.isRunning) {
          // if the time hasn't run out
          if (stopwatch.getElapsedTime() / 1000 <= stopwatch.timerLimit) {
            // update the label that shows the timer
            updateLabel();
          } else {
            // otherwise the game has ended, so stop the timer, and show game over message
            stopwatch.pause();
            textArea.appendText("\nYou just got blown up!! ", true);
            textArea.appendText("The code was " + code, true);
            askIfUserWantsToPlayAgain();

            // wait for 500 millis before doing the explosion animation
            try {
              Thread.sleep(500);
            } catch (Exception e) {
              System.out.println(e);
            }
            explosionAnimation();
            gameStarted = false;

          }
        }
      }
    };

    // Schedule the task to run every 10 milliseconds
    java.util.Timer timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, 0, 10);
  }

  // pre: nothing
  // Does: update the label that shows the time
  // post: sets the text of the JLabel
  private static void updateLabel() {
    label.setText(" ⏰ " + stopwatch.getTimeString());
  }

  // pre: nothing
  // Does: initialize the objects that appear in the frame. starts Java Swing
  // objects and and displays intro message
  // post: returns nothing.
  public static void initializeFrame() {

    // setup frame and don't let user exit until they win
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    f.setSize(400, 500);
    f.setLocation(300, 200);

    // setup label
    label.setPreferredSize(new Dimension(200, 50));
    // Create a new font with the desired size
    Font font = new Font(label.getFont().getName(), Font.PLAIN, 20);
    // Set the new font to the label
    label.setFont(font);
    label.setText(" ⏰ " + (secondsToPlay + 1) + ":00");

    // setup textField properties
    Insets padding = new Insets(5, 5, 5, 5);
    textField.setMargin(padding);

    // setup the placeholder for the text
    textField.setText("Type here to enter your guess");
    textField.setForeground(Color.GRAY);

    // listen to the focus state of the textField
    textField.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        // if the text is filled with the placeholder, then set it to nothing when the
        // focus is gained.
        if (textField.getText().equals("Type here to enter your guess")) {
          textField.setText("");
          textField.setForeground(Color.BLACK);
        }
      }

      public void focusLost(FocusEvent e) {
        // if the textfield is empty and focus is lost, set the placeholder again
        if (textField.getText().isEmpty()) {
          textField.setForeground(Color.GRAY);
          textField.setText("Type here to enter your guess");
        }
      }
    });

    // Add the objects to the frame
    panel.add(BorderLayout.NORTH, label);
    panel.add(BorderLayout.CENTER, textArea.scrollPane);
    panel.add(BorderLayout.SOUTH, textField);

    // show the frame
    f.setVisible(true);

    // display the intro with a typewriter effect (custom method in
    // ScrollableTextarea class)
    textArea.typewriter("-------------------------\n" +
        "| Welcome to MASTERMIND 🧠 |\n" +
        "-------------------------\n\n" +
        "| EPILEPSY WARNING\n" +
        "| Yes, another bomb defusing game. \n" +
        "| Your mission, which you have to accept\n" +
        "| will be to guess the 4 digit code to defuse the bomb 💣\n" +
        "| and yes, there can be repeat digits in the code.\n" +
        "| ⚡️ Type your first guess and press enter to start\n" +
        "| 😈 You can't leave the game until you win\n");
  }

  // pre: nothing
  // pre: resets important life cycle variables of the game and prints
  // instructions again
  // post: nothing
  public static void resetGame() {
    // reset game life cycle variables
    guessesRemaining = 10;
    rand = new Random();
    code = rand.nextInt(9999 - 1000 + 1) + 1000;
    codeString = "" + code;

    // set the timer label text back to 60
    label.setText(" ⏰ " + (secondsToPlay + 1) + ":00");

    // show the rules again
    textArea.setText("-------------------------\n" +
        "| Welcome to MASTERMIND 🧠 |\n" +
        "-------------------------\n\n" +
        "| EPILEPSY WARNING\n" +
        "| Yes, another bomb defusing game. \n" +
        "| Your mission, which you have to accept, will be to guess the 4 digit code to defuse the bomb 💣\n" +
        "| ⚡️ Type your first guess and press enter to start\n" +
        "| 😈 You can't leave the game until you win\n");

    // reset the main game timer
    stopwatch.reset();
  }

  // pre: nothing
  // Does: prints the text to ask if the user wants to play again
  // made this a method since I use it more than once
  // makes code more readable
  // post: nothing
  public static void askIfUserWantsToPlayAgain() {
    textArea.appendText("\nWant to play a game?\nEnter a new guess to start a new game?", true);
  }

  // algorithm to check what numbers are right
  public static int[] algorithm(String guessString, String codeString) {

    // make an array to output the multiple outputs in one variable

    int[] output = new int[3];

    // make a copy of the codeString in order to avoid mutating it directly
    String codeStringCopy = codeString;

    // iterate through the numbers in the codeString
    for (int i = 0; i < codeString.length(); i++) {

      if (guessString.charAt(i) == codeStringCopy.charAt(i)) {
        // if it's an exact match, remove the number from the string to not reuse it
        output[0]++;
        codeStringCopy = codeStringCopy.replaceFirst(guessString.charAt(i) + "", "*");

      } else if (codeStringCopy.contains(guessString.charAt(i) + "")) {
        // otherwise if the number in your answer is contained in the codeString, check
        // if other numbers have an exact match

        boolean anotherNumberIsExactMatch = false;

        // loop through the rest of the numbers in your guess and check if they match
        // exactly with a number in the code
        for (int j = (i < guessString.length()) ? i + 1 : guessString.length(); j < guessString
            .length(); j++) { // if i is less than the length, set j to the next position, otherwise set it to
                              // the length (4)
          if (guessString.charAt(j) == guessString.charAt(i)) {
            if (guessString.charAt(j) == codeStringCopy.charAt(j)) {
              // another number is an exact match
              anotherNumberIsExactMatch = true;
            }
            // else another number is not an exact match
          }
          // else this is not the same number
        }

        // if another of the same number is an exact match match, then don't count this
        // one as a partial match
        if (!anotherNumberIsExactMatch) {
          output[1]++;
          codeStringCopy = codeStringCopy.replaceFirst(guessString.charAt(i) + "", "*");
        } else {
          output[2]++;
        }

      } else {
        // not in the array
        output[2]++;
      }
    }

    // returns an array with the exactMatches, partialMatches and wrongNumbers
    return output;
  }

  // pre: nothing
  // Does: creates a new instance of the game with all of the life cycle variables and other methods
  // post: nothing
  public void newGameInstance() {

    // initialize game and frame variables
    initializeFrame();

    // start the stopwatch
    stopwatch.start(secondsToPlay);

    // pause it temporarily while timer is displayed
    stopwatch.pause();

    displayTimer();

    // listen to enter presses in the textfield
    textField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // user pressed enter

        // if the game hasn't started then reset it and start it
        if (!gameStarted) {
          resetGame();
          gameStarted = true;
        }

        if (stopwatch.isRunning) {
          // if the timer is not done

          if (textField.getText().length() >= 1) {
            // if they're actually inputting something

            // temporarily disable the textField
            textField.setEnabled(false);

            // get the text
            String guessString = textField.getText();

            // initialize guess variable
            int guess;
            textArea.appendText("\n" + guessString, true);

            try {
              // try to parse the integer
              guess = Integer.parseInt(guessString);

              if (guess == code) {
                // if they guessed correctly
                textArea.appendText("You defused the bomb!", true);
                stopwatch.pause();

                gameStarted = false;
                askIfUserWantsToPlayAgain();

                // allow them to close the game
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              } else {
                if (guessString.length() == 4) {
                  // if it is a 4 digit number

                  guessesRemaining--;

                  // run the algorithm to check which numbers are correct
                  int[] output = algorithm(guessString, codeString);

                  // show the feedback
                  textArea.appendText(
                      "✅ " + output[0] + " " + ((output[0] == 1) ? "number" : "numbers") + " right",
                      true);
                  textArea.appendText("🆗 " + output[1] + " "
                      + ((output[1] == 1) ? "number" : "numbers") + " correct, but in the wrong spot", true);
                  textArea.appendText(
                      "❌ " + output[2] + " " + ((output[2] == 1) ? "number" : "numbers") + " wrong", true);

                } else {
                  textArea.appendText("\nMake sure you enter a 4 digit number! ", true);
                }
              }

            } catch (NumberFormatException error) {
              // not a valid integer, error message
              System.out.println(error);
              textArea.appendText("\nEnter a valid number, only numbers! ", true);
            }

            // empty the textfield and set it back to enabled
            textField.setText("");
            textField.setEnabled(true);

            // focus again on the textfield
            textField.requestFocus();

            if (guessesRemaining > 0) {
              // if the user hasn't run out of guesses
              textArea.appendText("You have " + guessesRemaining + " guesses remaining.", true);
            } else {
              // if the user has run out of guesses, show the end message, pause timer and run
              // the explosion animation
              textArea.appendText("\nYou ran out of guesses! ", true);
              textArea.appendText("The code was " + code, true);
              stopwatch.pause();
              gameStarted = false;
              explosionAnimation();
              askIfUserWantsToPlayAgain();

            }

          }

        }

      }

    });

  }

}
