package GUI.sum.ch11;

import javax.swing.*;

public class JSliderExample2 extends JFrame {

    JSliderExample2() {
        JSlider slider = new JSlider(0,200,100);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);

        add(slider);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSliderExample2();
    }
}
