package GUI.sum.ch11;

import javax.swing.*;

public class JComboBoxExample extends JFrame {

    JComboBoxExample() {
        String[] frutis = { "pear" , "apple", "mango"};
        JComboBox<String> comboBox = new JComboBox<>(frutis);

        String[] names = { "kim", "dek"};
        JComboBox<String> comboBox2 = new JComboBox<>();
        for(int i = 0; i < names.length; i++) {
            comboBox2.addItem(names[i]);  // addItem임 add가아니고
        }

        add(comboBox); add(comboBox2);
    }

    public static void main(String[] args) {

    }
}
