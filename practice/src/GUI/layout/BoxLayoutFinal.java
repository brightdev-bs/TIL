package GUI.layout;

import javax.swing.*;

public class BoxLayoutFinal extends JFrame {

    BoxLayoutFinal() {
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton button = new JButton("Button Top AlignmentX 0.5");
        button.setAlignmentX(0.5f);
        add(button);

        Box box1 = Box.createVerticalBox();
        box1.setBorder(BorderFactory.createTitledBorder("VerticalBox"));

        JButton btn = new JButton("bUTTON A");
        btn.setAlignmentX(LEFT_ALIGNMENT);
        JButton btn2 = new JButton("bUTTON B");
        btn2.setAlignmentX(LEFT_ALIGNMENT);
        JButton btn3 = new JButton("bUTTON C");
        btn3.setAlignmentX(LEFT_ALIGNMENT);

        box1.add(btn);
        box1.add(Box.createVerticalStrut(10));
        box1.add(btn2);
        box1.add(Box.createVerticalStrut(10));
        box1.add(btn3);
        box1.add(Box.createVerticalStrut(10));

        box1.setAlignmentX(CENTER_ALIGNMENT);
        add(box1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutFinal();
    }
}
