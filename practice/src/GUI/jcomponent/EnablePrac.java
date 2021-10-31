package GUI.jcomponent;

import javax.swing.*;
import java.awt.*;

public class EnablePrac extends JFrame {

    EnablePrac() {
        JButton button = new JButton("enable 아님");
        button.setEnabled(false);
        JButton button2 = new JButton("enable");
        button2.setEnabled(true);

        add(button);
        add(button2);

        setLayout(new FlowLayout());
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EnablePrac();
    }
}
