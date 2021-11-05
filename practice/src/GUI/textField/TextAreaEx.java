package GUI.textField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextAreaEx extends JFrame {
    JTextArea textArea, textArea2;

    private class MyDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println(e.getOffset());
            textArea2.append(textArea.getText().substring(e.getOffset()).toLowerCase());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }

    TextAreaEx() {
        setSize(300,300);
        setLayout(new FlowLayout());

        textArea = new JTextArea(7,20);
        textArea.getDocument().addDocumentListener(new MyDocumentListener());

        textArea2 = new JTextArea(7,20);

        add(textArea);
        add(textArea2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextAreaEx();
    }
}
