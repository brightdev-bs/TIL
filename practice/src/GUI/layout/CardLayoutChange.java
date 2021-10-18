package GUI.layout;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class CardLayoutChange extends JFrame {
    static JPanel panels;
    static CardLayout layout;

    CardLayoutChange() {
        setSize(300,300);

        setVisible(true);

        JPanel panel = new JPanel();
        panel.add(new JButton("Button A"));
        panel.add(new JButton("Button B"));
        panel.add(new JButton("Button C"));

        JPanel panel2 = new JPanel();
        panel2.add(new JButton("button 1"));
        panel2.add(new JButton("button 2"));

        panels = new JPanel(new CardLayout());
        layout = new CardLayout();
        panels.setLayout(layout);
        panels.add(panel);
        panels.add(panel2);

        add(panels, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new CardLayoutChange();
        while(true) {
            layout.next(panels);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
