package MastermindFinalProject;

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
  public static ScrollableTextarea textArea = new ScrollableTextarea();
  public static JTextField textField = new JTextField(20);
  public static int guessesRemaining = 10;
  public static boolean gameStarted = false;
  public static boolean gameEnded = false;
  public static int secondsToPlay = 59;

  public static Random rand;
  public static int code;
  public static String codeString;

  public static void explosionAnimation() {
    explosionStopwatch.reset();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {

        explosionStopwatch.start(3);

        if (explosionStopwatch.getElapsedTime() / 1000 <= explosionStopwatch.timerLimit) {

          f.setSize(200, 200);
          f.setLocation(rand.nextInt(500), rand.nextInt(500));
        } else {
          explosionStopwatch.pause();
          f.setSize(400, 500);

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
            textArea.appendText("\nYou just got blown up!! ", true);
            textArea.appendText("The code was " + code, true);
            askIfUserWantsToPlayAgain();

            // gameStarted = true;x
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

    textField.setText("Type here to enter your guess");
    textField.setForeground(Color.GRAY);
    textField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (textField.getText().equals("Type here to enter your guess")) {
          textField.setText("");
          textField.setForeground(Color.BLACK);
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
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

    // pack the frame to the size that the items actually take up
    // f.pack();
    f.setVisible(true);

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

    // textField.requestFocus();

    // textArea.appendText("" + code, true);
  }

  public static void resetGame() {
    // explosionStopwatch.reset();

    guessesRemaining = 10;
    rand = new Random();

    // code = rand.nextInt(9999 - 1000 + 1) + 1000;
    code = 5323;
    codeString = "" + code;

    System.out.println(stopwatch.isRunning);
    label.setText(" ⏰ " + (secondsToPlay + 1) + ":00");

    textArea.setText("-------------------------\n" +
        "| Welcome to MASTERMIND 🧠 |\n" +
        "-------------------------\n\n" +
        "| EPILEPSY WARNING\n" +
        "| Yes, another bomb defusing game. \n" +
        "| Your mission, which you have to accept, will be to guess the 4 digit code to defuse the bomb 💣\n" +
        "| ⚡️ Type your first guess and press enter to start\n" +
        "| 😈 You can't leave the game until you win\n");

    stopwatch.reset();
  }

  public static void askIfUserWantsToPlayAgain() {
    textArea.appendText("\nWant to play a game?\nEnter a new guess to start a new game?", true);
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
          resetGame();
          System.out.println("code" + code);
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

                gameStarted = false;
                askIfUserWantsToPlayAgain();

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              } else {
                if (guessString.length() == 4) {

                  guessesRemaining--;

                  int exactMatches = 0;
                  int partialMatches = 0;
                  int wrongNumbers = 0;

                  String codeStringCopy = codeString;

                  for (int i = 0; i < codeString.length(); i++) {
                    if (guessString.charAt(i) == codeStringCopy.charAt(i)) {
                      // exact match
                      exactMatches++;
                      codeStringCopy = codeStringCopy.replaceFirst(guessString.charAt(i) + "", "*");

                    } else if (codeStringCopy.contains(guessString.charAt(i) + "")) {

                      boolean anotherNumberIsExactMatch = false;

                      for (int j = (i < guessString.length()) ? i + 1 : guessString.length(); j < guessString
                          .length(); j++) {
                        if (guessString.charAt(j) == guessString.charAt(i)) {
                          if (guessString.charAt(j) == codeStringCopy.charAt(j)) {
                            // another number is an exact match
                            anotherNumberIsExactMatch = true;
                          }
                          // else another number is not an exact match
                        }
                        // else this is not the same number
                      }

                      if (!anotherNumberIsExactMatch) {
                        partialMatches++;
                        codeStringCopy = codeStringCopy.replaceFirst(guessString.charAt(i) + "", "*");
                      } else {
                        wrongNumbers++;
                      }

                    } else {
                      // not in the array
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
                  textArea.appendText("\nMake sure you enter a 4 digit number! ", true);
                }
              }

            } catch (NumberFormatException error) {
              // textArea.appendText("\nEnter a valid number!", true);
              System.out.println(error);
              textArea.appendText("\nEnter a valid number, only numbers! ", true);
            }
            textField.setText("");
            textField.setEnabled(true);

            textField.requestFocus();

            if (guessesRemaining > 0) {
              textArea.appendText("You have " + guessesRemaining + " guesses remaining.", true);
            } else {
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
