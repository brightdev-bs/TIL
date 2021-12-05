package GUI.ch14;

import javax.swing.*;

public class DialogExample extends JFrame {

    DialogExample() {
        JDialog dialog = new JDialog();
        dialog.setTitle("나의 다이얼로그");
        dialog.add(new JButton("Click!"));
        dialog.setSize(300,300);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new DialogExample();
    }
}
