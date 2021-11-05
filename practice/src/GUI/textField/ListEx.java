package GUI.textField;

import javax.swing.*;
import java.awt.*;

public class ListEx extends JFrame {
    String[] fruits = { "apple", "melon", "kiwi", "mango", "hi", "xx", "zbx", "Sdfw"
    , "Sdfw", "Xcvs"};

   ListEx() {
       setSize(300,300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       setLayout(new FlowLayout());

       JList<String> list = new JList(fruits);
       JScrollPane sp = new JScrollPane(list);
       add(sp);

       setVisible(true);
   }

    public static void main(String[] args) {
        new ListEx();
    }
}
