package MastermindFinalProject;

import javax.swing.*;

public class ScrollableTextarea {
    public JScrollPane scrollPane;
    public static JTextArea textArea = new JTextArea();

    public ScrollableTextarea() {

        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap words to the next line
        textArea.setEditable(false); // Make it non-editable

        // Set the size of the JTextArea
        textArea.setColumns(30);
        textArea.setRows(2);

        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap words to the next line
        textArea.setEditable(false); // Make it non-editable

        // Set thetextArea size of the JTextArea
        textArea.setColumns(30);
        textArea.setRows(5);

        scrollPane = new JScrollPane(textArea); // Wrap JTextArea inside JScrollPane

    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void appendText(String text, boolean newLine) {
        // System.out.println(textArea.getText() + text);
        textArea.setText(textArea.getText() + (newLine ? "\n" : "") + text);
    }

}
