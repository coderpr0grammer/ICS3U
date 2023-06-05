package MastermindFinalProject;

import MastermindFinalProject.Stopwatch;
import MastermindFinalProject.ScrollableTextarea;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.util.TimerTask;
import javax.swing.JTextField;

public class GUI {

  public static Stopwatch stopwatch = new Stopwatch();
  public static JLabel label = new JLabel();

  public static ScrollableTextarea textArea = new ScrollableTextarea();

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


  public static void main(String[] args) {

    label.setPreferredSize(new Dimension(200, 50));

    JFrame f = new JFrame("MasterTime");

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a new font with the desired size
    Font font = new Font(label.getFont().getName(), Font.PLAIN, 20);

    // Set the new font to the label
    label.setFont(font);

    f.setSize(500, 500);
    f.setLocation(300, 200);

    // Add the label to the frame
    f.getContentPane().add(BorderLayout.NORTH, label);


    JTextField textField = new JTextField(20); // Specify the desired width
    f.getContentPane().add(BorderLayout.CENTER, textArea.scrollPane);

    Insets padding = new Insets(5, 5, 5, 5);
    textField.setMargin(padding);
    f.getContentPane().add(BorderLayout.SOUTH, textField);

    f.pack();

    textField.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // pressed enter
        String text = textField.getText();
        System.out.println(text);

        textArea.appendText(text, true);

      }

    });

    stopwatch.start(10);

    displayTimer();

    f.setVisible(true);

  }

}