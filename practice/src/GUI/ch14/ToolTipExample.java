package GUI.ch14;

import javax.swing.*;
import java.awt.*;

public class ToolTipExample extends JFrame {

    ToolTipExample() {
        JLabel tool = new JLabel(new ImageIcon(getClass().getResource("tool.png")));
        JLabel flower = new JLabel(new ImageIcon(getClass().getResource("flower.jpg")));

        ToolTipManager m = ToolTipManager.sharedInstance();
        m.setInitialDelay(1000);
        m.setDismissDelay(10000);
        tool.setToolTipText("10초지속");
        flower.setToolTipText("이것도?");

        setLayout(new GridLayout(2, 1));
        add(tool); add(flower);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToolTipExample();
    }
}
