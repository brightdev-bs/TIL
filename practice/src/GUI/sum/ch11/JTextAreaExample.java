package GUI.sum.ch11;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class JTextAreaExample extends JFrame{

    JTextAreaExample() {
        JTextArea res = new JTextArea(10,10);
        JTextArea area = new JTextArea(10,10);
        area.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Document d = e.getDocument();
                try {
                    String s = d.getText(0, d.getLength());
                    StringBuilder sb = new StringBuilder();
                    for(Character c : s.toCharArray()) {
                        sb.append(Character.toUpperCase(c));
                    }
                    res.setText(sb.toString());
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        setLayout(new FlowLayout());
        add(area);
        add(res);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextAreaExample();
    }
}
