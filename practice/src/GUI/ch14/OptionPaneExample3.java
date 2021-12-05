package GUI.ch14;

import javax.swing.*;

public class OptionPaneExample3 extends JFrame {

    OptionPaneExample3() {
        String input = JOptionPane.showInputDialog("정수 하나를 입력하세요");
        int inputNum = Integer.parseInt(input);
        if(inputNum > 100) {
            JOptionPane.showMessageDialog(null, "값이 너무 큽니다.", "결과", JOptionPane.INFORMATION_MESSAGE);
        } else  {
            JOptionPane.showMessageDialog(null, "값이 너무 작습니다", "결과", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new OptionPaneExample3();
    }
}
