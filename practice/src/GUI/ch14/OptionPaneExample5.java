package GUI.ch14;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPaneExample5 extends JFrame {
    JLabel img = new JLabel();

    OptionPaneExample5() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser(getClass().getName());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "JPG");
                file.setFileFilter(filter);
                int ret = file.showOpenDialog(null);
                String name = file.getSelectedFile().getPath();
                if(ret != JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "ㅍㅏ일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                img.setIcon(new ImageIcon(name));
            }
        });


        menu.add(menuItem);

        menuBar.add(menu);
        add(menuBar, BorderLayout.NORTH);
        add(img, BorderLayout.CENTER);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OptionPaneExample5();
    }
}
