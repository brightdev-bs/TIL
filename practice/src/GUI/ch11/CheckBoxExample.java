package GUI.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxExample extends JFrame {

    CheckBoxExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        ImageIcon selectedIcon = new ImageIcon(getClass().getResource("flower.jpeg"));
        JCheckBox checkBox = new JCheckBox("꽃", icon);
        checkBox.setSelectedIcon(selectedIcon);    // 선택되었을 때의 아이콘 설정


        add(checkBox);
        pack();

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxExample();
    }
}
