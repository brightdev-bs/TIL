package GUI.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class hw1 extends JFrame {

    hw1() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JLabel label = new JLabel("섭씨 온도");
        JTextField field = new JTextField(10);

        JLabel label2 = new JLabel("화씨 온도");
        JTextField field2= new JTextField(10);

        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("실행됨");
                if(KeyEvent.getKeyText(e.getKeyCode()) == "Enter") {
                    field2.setText("섭씨 to 화씨");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        field2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(label);
        add(field);
        add(label2);
        add(field2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new hw1();
    }
}
