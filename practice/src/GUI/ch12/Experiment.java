package GUI.ch12;

import javax.swing.*;
import java.awt.*;

public class Experiment extends JFrame {

    Experiment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    class OutPanel extends JPanel {
        ImageIcon icon = new ImageIcon(getClass().getResource("flower.jpeg"));
        OutPanel() {
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Outer super call"));
            setLayout(null);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension size = getSize();
            icon.paintIcon(this, g, icon.getIconWidth() + 5, icon.getIconHeight());
        }
    }

    class FatherPanel extends JPanel {
        FatherPanel() {

        }
    }
}
