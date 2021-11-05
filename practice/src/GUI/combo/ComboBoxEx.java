package GUI.combo;

import javax.swing.*;
import java.awt.*;

public class ComboBoxEx extends JFrame {
    private String[] fruits = {"Apple", " Banna"};
    private String[] names = {"KIM","Park"};

    ComboBoxEx() {
        setSize(300,300);

        JComboBox<String> comboBox = new JComboBox<>(fruits);
        JComboBox<String> comboBox2 = new JComboBox<>();
        for(int i = 0; i < names.length; i++) {
            comboBox2.addItem(names[i]);
        }

        add(comboBox);
        add(comboBox2);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxEx();
    }
}
