package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class AlphabetButtons extends JFrame {

    AlphabetButtons() {
        getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setLayout(new FlowLayout(FlowLayout.TRAILING));

        for(int i = 0; i < 26; i++) {
            Character letter = (char) (i + 'A');
            JButton button = new JButton(letter.toString());
            add(button);
        }

        setBounds(0,0,300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AlphabetButtons();
    }
}
