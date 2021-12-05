package GUI.ch14;

import javax.swing.*;
import java.awt.*;

public class JMenuBarExample2 extends JFrame {

    JMenuBarExample2() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("FILE");
        JButton button = new JButton(new ImageIcon(getClass().getResource("tool.png")));
        file.add(button);

        JMenu fonts = new JMenu("fonts");
        fonts.add("Time New Roman");

        JMenu colors = new JMenu("Colors");
        MyColorIcon icon = new MyColorIcon(new Color(255,0,0), 5,5);
        colors.add(new JMenuItem(icon));

        JMenu animals = new JMenu("Animals");
        Icon flower = new ImageIcon(getClass().getResource("flower.jpg"));
        Icon tool = new ImageIcon(getClass().getResource("tool.png"));
        JCheckBoxMenuItem checkItem = new JCheckBoxMenuItem(flower);
        JCheckBoxMenuItem checkItem2 = new JCheckBoxMenuItem(tool);
        animals.add(checkItem); animals.add(checkItem2);

        JMenu operation = new JMenu("Operation");

        menuBar.add(file); menuBar.add(fonts); menuBar.add(colors); menuBar.add(animals);

        add(menuBar);
        setSize(300,300);
        setVisible(true);

    }

    class MyColorIcon implements Icon {
        int weight, height;
        Color color;

        MyColorIcon(Color c, int w, int h) {
            color = c;
            weight = w;
            height = h;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(Color.black);
            g.drawRect(x,y,weight-1,height-1);
            g.setColor(color);
            g.fillRect(x+1, y+1, weight-2, height-2);
        }

        @Override
        public int getIconWidth() {
            return weight;
        }

        @Override
        public int getIconHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        new JMenuBarExample2();
    }
}
