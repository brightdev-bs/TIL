package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;

public class superpaintComponentEx03 extends JFrame {
    public superpaintComponentEx03() {
        super("paintComponent() Demo");

        OuterPanel outer = new OuterPanel();
        Son1Panel son1 = new Son1Panel();
        outer.add(son1);
        Son2Panel son2 = new Son2Panel();
        outer.add(son2);
        Son3Panel son3 = new Son3Panel();
        outer.add(son3);
        add(outer);
        setSize(1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new superpaintComponentEx03();
    }
    class OuterPanel extends JPanel {
        ImageIcon image = new ImageIcon(getClass().getResource("flower.jpg"));
        private int appleW = image.getIconWidth();
        private int appleL = image.getIconHeight();
        OuterPanel(){
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.RED), "Outer super call"));
            setLayout(null);
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension size = getSize();
            for (int row = 0; row < size.height; row += appleL)
                for (int col = 0; col < size.width; col += appleW)
                    image.paintIcon(this, g, col, row);
        }
    }
    class FatherPanel extends JPanel {
        FatherPanel(){
            setBackground(Color.CYAN);
            add(new JButton("FatherPanel Button"));
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(10, 140, 50, 50);
            g.drawRect(40, 160, 70, 30);
        }
    }
    class Son1Panel extends FatherPanel {
        Son1Panel(){
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.RED), "Son1 super call"));
            setBounds(10, 100, 300, 200);
            setBackground(Color.ORANGE);

            JButton button = new JButton("Son1 Button");
            add(button);
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
    class Son2Panel extends FatherPanel {
        Son2Panel(){
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.BLACK), "Son2 No super call"));
            setBounds(310, 100, 300, 200);
            setBackground(Color.ORANGE);
            JButton button = new JButton("Son2 Button");
            add(button);
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
    class Son3Panel extends FatherPanel {
        Son3Panel(){
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.BLACK), "Son3 No paintComponent()"));
            setBounds(610, 100, 300, 200);
            //setBackground(Color.ORANGE);
            JButton button = new JButton("Son3 Button");
            add(button);
        }
    }
}
