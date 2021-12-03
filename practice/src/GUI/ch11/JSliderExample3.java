package GUI.ch11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSliderExample3 extends JFrame {
    JLabel label;

    JSliderExample3() {
        setSize(300,300);
        setLayout(new GridLayout(2,1));

        label = new JLabel("100");

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider) e.getSource();
                int x = s.getValue();
                label.setText(String.valueOf(x));
            }
        });
        add(slider); add(label);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSliderExample3();
    }
}
