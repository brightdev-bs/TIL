package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class JSliderExample extends JFrame {

    JSliderExample() {
        setSize(300,300);
        setDefaultCloseOperation(JSliderExample.EXIT_ON_CLOSE);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        add(slider, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSliderExample();
    }
}
