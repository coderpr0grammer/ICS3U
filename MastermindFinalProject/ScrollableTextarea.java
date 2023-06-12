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

    public ScrollableTextarea() {

        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap words to the next line
        textArea.setEditable(false); // Make it non-editable by the user

        // Set the size of the JTextArea
        textArea.setColumns(30);
        textArea.setRows(2);

        scrollPane = new JScrollPane(textArea); // Wrap JTextArea inside JScrollPane in order to make it scrollable

    }

    //set the text in the textarea
    public void setText(String text) {
        textArea.setText(text);
    }

    //append the text to the textarea allowing for newlines
    public void appendText(String text, boolean newLine) {
        textArea.setText(textArea.getText() + (newLine ? "\n" : "") + text);
    }

    //make a typewriter effect when appending the text to the textArea
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
