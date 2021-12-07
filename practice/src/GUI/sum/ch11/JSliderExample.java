package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class JSliderExample extends JFrame {

    JSliderExample() {
        JSlider slider = new JSlider(0,100,50);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);

        add(slider, BorderLayout.NORTH);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSliderExample();
    }
}
