package GUI.ch14;

import javax.swing.*;

public class OptionPaneExample extends JFrame {

    OptionPaneExample() {
        JOptionPane.showMessageDialog(null, "alert", "다시", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new OptionPaneExample();
    }
}
