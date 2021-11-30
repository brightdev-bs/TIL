package GUI.ch11;

import javax.swing.*;
import java.awt.*;

// 내부 판넬을 두고 내부 판넬 내부에 "Hello" 라는 버튼을 둔다.
public class Ex1 extends JFrame {

    Ex1() {
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.gray);
        getContentPane().setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(300,120)); // 내부 판넬 크기 조절 하는 법 기억하기!

        JButton button = new JButton("Hello");
        button.setPreferredSize(new Dimension(200,80));
        panel.add(button);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex1();
    }
}
