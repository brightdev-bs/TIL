package GUI.ch14;

import javax.swing.*;
import java.awt.*;

public class ToolbarExample extends JFrame {

    ToolbarExample() {
        JToolBar toolbar = new JToolBar();
        JLabel label = new JLabel("NEW");
        label.setToolTipText("그냥new");
        toolbar.add(label);
        toolbar.add(new JLabel("second"));

        toolbar.add(new JTextField("text Field"));
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("java");
        comboBox.addItem("c");

        toolbar.add(comboBox);

        add(toolbar, BorderLayout.NORTH);
        setSize(400,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToolbarExample();
    }
}
