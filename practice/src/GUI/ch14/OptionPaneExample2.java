package GUI.ch14;

import javax.swing.*;

public class OptionPaneExample2 extends JFrame {

    OptionPaneExample2() {

        String rs = JOptionPane.showInputDialog("반지름을 입력하세요");
        Double r = Double.parseDouble(rs);
        Double area = Math.PI * r * r;
        String output = "Radius : " + r + " \n" + "Area : " + area;
        JOptionPane.showMessageDialog(null, output, "Circle", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new OptionPaneExample2();
    }
}
