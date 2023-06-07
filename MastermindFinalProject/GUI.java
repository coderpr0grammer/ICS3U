package MastermindFinalProject;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Random;

public class GUI {

  // setup Java Swing objects
  public static JFrame f = new JFrame("You can't leave this game");
  public static Container panel = f.getContentPane();
  public static Stopwatch stopwatch = new Stopwatch();
  public static Stopwatch explosionStopwatch = new Stopwatch();
  public static JLabel label = new JLabel();
  public static ScrollableTextarea textArea = new ScrollableTextarea();
  public static JTextField textField = new JTextField(20);
  public static int guessesRemaining = 10;
  public static boolean gameStarted = false;
  public static int secondsToPlay = 59;

  public static Random rand = new Random();

  public static int code = rand.nextInt(9999 - 1000 + 1) + 1000;
  public static String codeString = "" + code;

  public static void explosionAnimation() {
    TimerTask task = new TimerTask() {
      @Override
      public void run() {

        explosionStopwatch.start(3);

        if (explosionStopwatch.getElapsedTime() / 1000 <= explosionStopwatch.timerLimit) {

          // f.setSize(200, 200);
          f.setLocation(rand.nextInt(500), rand.nextInt(500));
        } else {
          explosionStopwatch.pause();
        }
      }
    };

    // Schedule the task to run every 100 milliseconds
    java.util.Timer timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, 0, 10);
  }

  public static void displayTimer() {
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        if (stopwatch.isRunning) {
          if (stopwatch.getElapsedTime() / 1000 <= stopwatch.timerLimit) {
            updateLabel(); // Update the label with the current time

            // f.setSize(200, 200);
            // f.setLocation(rand.nextInt(500), rand.nextInt(500));
          } else {
            stopwatch.pause();
            textArea.appendText("\nYou lost L + ratio + bozo + you fell off + you use twitter ", true);
            textArea.appendText("The code was " + code, true);

            // gameStarted = true;
            try {

              Thread.sleep(500);
            } catch (Exception e) {
              System.out.println(e);
            }
            explosionAnimation();

          }
        }
      }
    };

    // Schedule the task to run every 100 milliseconds
    java.util.Timer timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, 0, 10);
  }

  private static void updateLabel() {
    label.setText(" ⏰ " + stopwatch.getTimeString());
  }

  public static void initializeFrame() {

    // setup frame
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    f.setSize(500, 500);
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

    // Add the objects to the frame
    panel.add(BorderLayout.NORTH, label);
    panel.add(BorderLayout.CENTER, textArea.scrollPane);
    panel.add(BorderLayout.SOUTH, textField);

    // pack the frame to the size that the items actually take up
    // f.pack();
    f.setVisible(true);

    textArea.appendText("-------------------------", false);
    textArea.appendText("| Welcome to MASTERMIND 🧠 |", true);
    textArea.appendText("-------------------------", true);
    textArea.appendText("", true);

    textArea.appendText(
        "| EPILEPSY WARNING",
        true);
    textArea.appendText(
        "| Yes, another bomb defusing game. \n",
        true);
    textArea.appendText(
        "| Your mission, which you have to accept, will be to guess the 4 digit code to defuse the bomb 💣",
        true);

    textArea.appendText("| ⚡ Type your first guess and press enter to start", true);
    textArea.appendText("| 😈 You can't leave the game until you win", true);

    textField.requestFocus();

    // textArea.appendText("" + code, true);

  }

  public void newGameInstance() {

    initializeFrame();

    stopwatch.start(secondsToPlay);

    stopwatch.pause();

    displayTimer();

    textField.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // pressed enter

        if (!gameStarted) {
          stopwatch.start(secondsToPlay);
          gameStarted = true;
        }

        if (stopwatch.isRunning) {
          // if the timer is not done
          if (textField.getText().length() >= 1) {
            // if they're actually inputting something
            textField.setEnabled(false);

            String guessString = textField.getText();

            System.out.println(guessString);

            int guess;
            textArea.appendText("\n" + guessString, true);

            try {
              guess = Integer.parseInt(guessString);
              if (guess == code) {
                textArea.appendText("You defused the bomb!", true);
                stopwatch.pause();

              } else {
                if (guessString.length() == 4) {

                  guessesRemaining--;

                  int exactMatches = 0;
                  int partialMatches = 0;
                  int wrongNumbers = 0;

                  // feedback system
                  for (int i = 0; i < guessString.length(); i++) {
                    if (guessString.charAt(i) == codeString.charAt(i)) {
                      // exact match
                      exactMatches++;
                    } else if (codeString.indexOf(guessString.charAt(i)) != -1) {
                      // code includes the number
                      partialMatches++;
                    } else {
                      // does not include that number
                      wrongNumbers++;
                    }
                  }

                  textArea.appendText(
                      "✅ " + exactMatches + " " + ((exactMatches == 1) ? "number" : "numbers") + " right",
                      true);
                  textArea.appendText("🆗 " + partialMatches + " "
                      + ((partialMatches == 1) ? "number" : "numbers") + " correct, but in the wrong spot", true);
                  textArea.appendText(
                      "❌ " + wrongNumbers + " " + ((wrongNumbers == 1) ? "number" : "numbers") + " wrong", true);

                } else {
                  textArea.appendText("\nIt's a 4 digit number, you stupid? ", true);
                }
              }

            } catch (NumberFormatException error) {
              // textArea.appendText("\nEnter a valid number!", true);
              System.out.println(error);
              textArea.appendText("\nEnter a valid number, you stupid? ", true);
            }
            textField.setText("");
            textField.setEnabled(true);

            textField.requestFocus();

            if (guessesRemaining > 0) {
              textArea.appendText("You have " + guessesRemaining + " guesses remaining.", true);
            } else {
              textArea.appendText("You ran out of guesses! ", true);
              textArea.appendText("The code was " + code, true);
              stopwatch.pause();
              explosionAnimation();

            }

          }

        }

      }

    });

  }

}
