package GUI.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Practice05 extends JFrame {
    JPanel panel;

    class MouthListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 3) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);
                panel.setBackground(new Color(r,g,b));
            }
        }
    }

    Practice05() {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.addMouseListener(new MouthListener());
        setContentPane(panel);

        setVisible(true);


    }

    public static void main(String[] args) {
        new Practice05();
    }
}
