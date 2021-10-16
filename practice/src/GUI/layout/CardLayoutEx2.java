package GUI.layout;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class CardLayoutEx2 extends JFrame {
    static JPanel panels;

    CardLayoutEx2() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new CardLayoutEx2();
    }
}
