package GUI.sum.ch11;

import javax.swing.*;
import java.awt.*;

public class BackgroundExperiment extends JFrame {

    BackgroundExperiment() {
        getContentPane().setBackground(Color.black); // setBackground(Color.black) 동작 하지 않음.

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BackgroundExperiment();
    }
}
