package GUI.ch11;

import javax.swing.*;
import java.awt.*;

public class MyCheckBox extends JFrame {

    MyCheckBox() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JCheckBox ckBox = new JCheckBox("사과");
        JCheckBox checkBox2 = new JCheckBox("꽃", true); //선택 상태의 체크 박스 생성
        add(ckBox);
        add(checkBox2);

        setSize(300,300);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyCheckBox();
    }
}
