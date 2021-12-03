package GUI.ch11;

import javax.swing.*;

public class JSliderExample2 extends JFrame {

    JSliderExample2() {
        setSize(300,300);
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        add(slider);
        setVisible(true);
    }

    public static void main(String[] args) {
       new JSliderExample2();
    }
}
