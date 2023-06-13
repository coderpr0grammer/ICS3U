/*
 * Daniel Martinez
 * June 12th, 2023
 * ICS3U
 * 
 * A custom class to make a Java Swing component that is scrollable and can print text
*/

package MastermindFinalProject;

import javax.swing.*;

public class ScrollableTextarea {
    public JScrollPane scrollPane;
    public static JTextArea textArea = new JTextArea();

    // pre: nothing
    // Does: constructor for the textarea. sets important properties
    // post: nothing
    public ScrollableTextarea() {

        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap words to the next line
        textArea.setEditable(false); // Make it non-editable by the user

        // Set the size of the JTextArea
        textArea.setColumns(30);
        textArea.setRows(2);

        scrollPane = new JScrollPane(textArea); // Wrap JTextArea inside JScrollPane in order to make it scrollable

    }

    // pre: takes in arguments for the text to print
    // Does: set the text in the textarea
    // post: nothing
    public void setText(String text) {
        textArea.setText(text);
    }

    // pre: takes in arguments for the text to print, and a boolean of whether or
    // not to add a newline between the old text and the one you are appending
    // Does: append the text to the textarea allowing for newlines.
    // post: nothing
    public void appendText(String text, boolean newLine) {
        textArea.setText(textArea.getText() + (newLine ? "\n" : "") + text);
    }

    // pre: takes in text String to print
    // prints text a typewriter effect when appending the text to the textArea
    // post: nothing
    public void typewriter(String text) {
        for (int i = 0; i < text.length(); i++) {
            appendText("" + text.charAt(i), false);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}
