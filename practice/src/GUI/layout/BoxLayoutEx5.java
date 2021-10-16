package GUI.layout;

import javax.swing.*;

public class BoxLayoutEx5 extends JFrame {

    BoxLayoutEx5() {
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton button = new JButton("Button Top AlignmentX 0.5");
        button.setAlignmentX(0.5f);
        add(button);

        Box box1 = Box.createVerticalBox();
        box1.setBorder(BorderFactory.createTitledBorder("Vertical Box"));
        JButton button2 = new JButton("Button A");
        box1.add(Box.createVerticalStrut(10));
        box1.add(button2);
        JButton button3 = new JButton("Button B");
        box1.add(Box.createVerticalStrut(10));
        box1.add(button3);
        JButton button4 = new JButton("Button C");
        box1.add(Box.createVerticalStrut(10));
        box1.add(button4);

        box1.setAlignmentX(0.5f);

        add(box1);

        Box box2 = Box.createHorizontalBox();
        box2.setBorder(BorderFactory.createTitledBorder("HorizontalBox"));
        box2.add(new JButton("Button 1"));
        box2.add(new JButton("Button 2"));
        box2.add(new JButton("Button 3"));

        add(box2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutEx5();
    }
}
