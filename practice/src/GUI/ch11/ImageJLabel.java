package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class ImageJLabel extends JFrame {

    // 이미지 라벨을 불러오는 방법
    ImageJLabel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch11/flower.jpeg");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);
        pack();
        setVisible(true);
    }
    // 이미지 배치 정하는
    //        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    //        imageLabel.setBorder(new TitledBorder(new LineBorder(Color.green, 2)));

    // SwingConstants.CENTER / LEFT / RIGHT /

    public static void main(String[] args) {
        new ImageJLabel();
    }
}
