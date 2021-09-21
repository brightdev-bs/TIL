package com.mango;

import javax.swing.*;
import java.awt.*;

public class CardLayout02 extends JFrame {
    JPanel pack;

    public CardLayout02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel card1 = new JPanel();
        card1.add(new JButton("A"));
        card1.add(new JButton("B"));
        card1.add(new JButton("C"));

        JPanel card2 = new JPanel();
        card2.add(new JButton("1"));
        card2.add(new JButton("2"));

        pack = new JPanel(new java.awt.CardLayout());
        pack.add(card1, "alpha button");
        pack.add(card2, "numeric buttons");

        add(pack, BorderLayout.CENTER);

        setSize(300, 100);
        setVisible(true);
    }

    public void cardShow() {
        CardLayout cl = (CardLayout) (pack.getLayout());
        while(true) {
            cl.next(pack);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        CardLayout02 cd = new CardLayout02();
        cd.cardShow();
    }
}
