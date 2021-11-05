package GUI.slider;

import javax.swing.*;

public class SliderEx extends JFrame {

    SliderEx() {
        JSlider slider = new JSlider();
        slider.setPaintLabels(true);
        //slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(50);
        add(slider);

        setSize(300,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SliderEx();
    }
}
