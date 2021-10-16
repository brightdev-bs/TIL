package GUI.layout;

import javax.swing.*;
import java.awt.*;

public class CardLayoutEx extends JFrame {
    JPanel[] panels = new JPanel[5];
    Color[] color = {Color.RED, Color.MAGENTA, Color.LIGHT_GRAY, Color.blue, Color.YELLOW};

    CardLayoutEx() {
        setSize(300,300);
        setLayout(new CardLayout());

    }

    public static void main(String[] args) {
        new CardLayoutEx();
    }
}
