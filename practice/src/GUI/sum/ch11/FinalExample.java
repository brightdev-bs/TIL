package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FinalExample extends JFrame {

    JLabel imgLabel;

    ImageIcon appleIcon = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/sum/ch11/apple.jpeg");
    ImageIcon pearIcon = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/sum/ch11/pear.jpeg");
    ImageIcon cherryIcon = new ImageIcon("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/sum/ch11/cherry.jpg");

    FinalExample() {
        ButtonGroup group = new ButtonGroup();

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배");
        JRadioButton cherry = new JRadioButton("체리");

        group.add(apple); group.add(pear); group.add(cherry);

        MyListener listener = new MyListener();
        apple.addItemListener(listener);
        pear.addItemListener(listener);
        cherry.addItemListener(listener);


        imgLabel = new JLabel();
        add(apple); add(pear); add(cherry);
        add(imgLabel);

        setLayout(new FlowLayout());
        setSize(500,500);
        setVisible(true);
    }

    class MyListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton btn = (JRadioButton) e.getSource();
            String s = btn.getText();
            if(s.equals("사과")) {
                imgLabel.setIcon(appleIcon);
            } else if(s.equals("배")) {
                imgLabel.setIcon(pearIcon);
            } else {
                imgLabel.setIcon(cherryIcon);
            }
        }
    }


    public static void main(String[] args) {
        new FinalExample();
    }
}
