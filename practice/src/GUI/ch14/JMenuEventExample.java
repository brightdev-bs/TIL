package GUI.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuEventExample extends JFrame {

    String[] name = {"Load", "Hide"};
    JLabel label = new JLabel();
    Icon icon = new ImageIcon(getClass().getResource("tool.png"));

    JMenuEventExample() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Screen");
        JMenuItem[] items = new JMenuItem[name.length];

        MyListener listener = new MyListener();

        for(int i = 0; i < name.length; i++) {
            items[i] = new JMenuItem(name[i]);
            items[i].addActionListener(listener);
            menu.add(items[i]);
        }

        menuBar.add(menu);
        add(label, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);
        pack();
        setVisible(true);

    }

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals(name[0])) {
                label.setIcon(icon);
            } else if(e.getActionCommand().equals(name[1])) {
                label.setIcon(null);
            }
        }
    }

    public static void main(String[] args) {
        new JMenuEventExample();
    }
}
