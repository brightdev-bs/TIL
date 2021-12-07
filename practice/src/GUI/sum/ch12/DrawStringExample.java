package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class DrawStringExample extends JFrame {
    String input ="";

    DrawStringExample() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(input, 30, 80);
            }
        };

        add(panel);
        setSize(300,300);
        setVisible(true);

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("입력: ");
            input = sc.nextLine();
            repaint();
        }
    }

    public static void main(String[] args) {
        new DrawStringExample();
    }
}
