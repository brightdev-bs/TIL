package GUI.ch11;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class DocumentListenerExample extends JFrame {
    JTextField textField = new JTextField(20), textField2 = new JTextField(20);
    int cnt  = 0;

    DocumentListenerExample() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        DocumentListener dl = new MyDocumentListenr();
        Document dc = textField.getDocument();
        dc.putProperty("source1",textField);
        dc.addDocumentListener(dl);

        Document dc2 = textField2.getDocument();
        dc2.putProperty("source2", textField2);
        dc2.addDocumentListener(dl);

        add(textField);
        add(textField2);
        setVisible(true);
    }

    class MyDocumentListenr implements  DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            Document d = e.getDocument();
            try {
                System.out.println("insertUpdate called : " + cnt++ + " " + e.getDocument().getText(0, d.getLength()));
            } catch(BadLocationException badLocationException) {

            }
            if(((JTextField) e.getDocument().getProperty("source1")) == textField)
                textField.setBackground(Color.green);
            if(((JTextField)e.getDocument().getProperty("source2")) == textField2)
                textField2.setBackground(Color.cyan);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            Document d = e.getDocument();
            try {
                System.out.println("removeUpdate Called : " + cnt++ + " " + e.getDocument().getText(0,d.getLength()));
            } catch (BadLocationException badLocationException) {
                badLocationException.printStackTrace();
            }
            if(((JTextField)e.getDocument().getProperty("source1")) == textField)
                textField.setBackground(Color.gray);
            if(((JTextField)e.getDocument().getProperty("source2")) == textField2)
                textField2.setBackground(Color.YELLOW);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            Document d = e.getDocument();
            try {
                System.out.println("changeUpdate called : " + cnt++ + " " + d.getText(0,d.getLength()));
            } catch (BadLocationException badLocationException) {
                badLocationException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DocumentListenerExample();
    }
}
