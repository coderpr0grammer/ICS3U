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
  public static JFrame f = new JFrame("MasterTime");
  public static Container panel = f.getContentPane();
  public static Stopwatch stopwatch = new Stopwatch();
  public static JLabel label = new JLabel();
  public static ScrollableTextarea textArea = new ScrollableTextarea();
  public static JTextField textField = new JTextField(20);
  public static int guessesRemaining = 10;
  public static boolean gameRunning = true;

  public static Random rand = new Random();

  public static int code = rand.nextInt(9999 - 1000 + 1) + 1000;

  public static void displayTimer() {
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        if (stopwatch.getElapsedTime() / 1000 <= stopwatch.timerLimit) {
          updateLabel(); // Update the label with the current time
        } else {
          stopwatch.pause();
        }
      }
    };

    // Schedule the task to run every 100 milliseconds
    java.util.Timer timer = new java.util.Timer();
    timer.scheduleAtFixedRate(task, 0, 10);
  }

  private static void updateLabel() {
    label.setText("⏰ " + stopwatch.getTimeString());
  }

  public static void initializeFrame() {

    // setup frame
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500, 500);
    f.setLocation(300, 200);

    // setup label
    label.setPreferredSize(new Dimension(200, 50));
    // Create a new font with the desired size
    Font font = new Font(label.getFont().getName(), Font.PLAIN, 20);
    // Set the new font to the label
    label.setFont(font);

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
        "| Your mission, if you choose to accept it, will be to guess the 4 digit code to defuse the bomb 💣", true);
    textArea.appendText("| 🚀 Are you ready?", true);
    textArea.appendText("| ⚡ Type anything and press enter to start", true);
    textArea.appendText("| 🚪 Enter 0 to exit", true);

  }

  public static void main(String[] args) {

    initializeFrame();

    textArea.appendText("" + code, true);

    stopwatch.start(10);

    displayTimer();

    while (gameRunning) {

      textField.addActionListener(new ActionListener() {

        // @Override
        public void actionPerformed(ActionEvent e) {
          // pressed enter

          String guessString = textField.getText();
          textField.setText("");

          System.out.println(guessString);

          int guess;
          textArea.appendText("\n" + guessString, true);

          try {
            guess = Integer.parseInt(guessString);
            if (guess == code) {
              textArea.appendText("You defused the bomb!.", true);

            } else {
              if (guessString.length() == 4) {
                guessesRemaining--;

                textArea.appendText("You have " + guessesRemaining + " guesses remaining.", true);
              } else {
                textArea.appendText("\nIt's a 4 digit number, you stupid? ", true);
              }
            }

          } catch (Exception error) {
            textArea.appendText("\nEnter a valid number!", true);
          }

        }

      });
    }

  }

}