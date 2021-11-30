package GUI.ch11;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ImageJLabelExample extends JFrame {

    ImageJLabelExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("누루궁뎅이버섯");
        label.setBorder(new TitledBorder(new LineBorder(Color.green, 1)));

        ImageIcon image = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower.jpeg");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(new TitledBorder(new LineBorder(Color.green, 2)));

        ImageIcon image2 = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower.jpeg");
        JLabel imageLabel2 = new JLabel(image2);
        imageLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        imageLabel2.setBorder(new TitledBorder(new LineBorder(Color.green, 1)));

        add(label);
        add(imageLabel);
        add(imageLabel2);

        pack();

        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageJLabelExample();
    }
}
