package GUI.jcomponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JButtonEx extends JFrame{

    JButtonEx() throws IOException {
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("star.png"));

        JToggleButton btn = new JToggleButton(icon);
        btn.setSize(400,400);
        btn.setLocation(200,200);
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new JButtonEx();
    }
}
