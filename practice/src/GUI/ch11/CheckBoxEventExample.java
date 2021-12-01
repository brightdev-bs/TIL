package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxEventExample extends JFrame {

    int money = 0;

    CheckBoxEventExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ItemControl ic = new ItemControl();


        JCheckBox apple = new JCheckBox("사과");
        apple.addItemListener(ic);
        JCheckBox pear = new JCheckBox("배");
        pear.addItemListener(ic);
        JCheckBox cherry = new JCheckBox("체리");
        cherry.addItemListener(ic);

        setLayout(new FlowLayout());
        add(apple); add(pear); add(cherry);

        pack();
        setVisible(true);
    }

    class ItemControl implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox item = (JCheckBox) e.getSource();
            String name = item.getText();
            if(name.equals("사과")) {
                if(item.isSelected())
                    money += 100;
                else
                    money -= 100;
            }
            else if(name.equals("배")) {
                if (item.isSelected())
                    money += 500;
                else
                    money -= 500;
            }
            else {
                if (item.isSelected())
                    money += 10000;
                else
                    money -= 10000;
            }
            System.out.println(money);

        }
    }

    public static void main(String[] args) {
        new CheckBoxEventExample();
    }
}
