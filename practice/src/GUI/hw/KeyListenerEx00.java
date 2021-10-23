package GUI.hw;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerEx00 extends JFrame {
    /*
     * Malik p.901
     * Key Event
     * 하나의 문자를 아주 크게 디스플레이한다
     * 사용자가 문자를 텍스트필드에 넣는다
     */
        JTextField tf = new JTextField(1);
        public KeyListenerEx00() {
            super("문자 그리기");
            Container c = getContentPane();
            tf.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    Color fg, bg;
                    tf.setText(" ");
                    fg = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
                    bg = Color.white;
                    tf.setForeground(fg);
                    tf.setBackground(bg);
                    tf.setCaretColor(bg);// 없으면 상하로 선 그어진다 JTextComponent의 메소드
                     //Caret은 javax.swing.text의 위치를 나타내는 인터페이스
                    tf.setFont(new Font("Courier", Font.BOLD, 300));
                    tf.setBorder(new TitledBorder("TextField"));
                }
            });
            c.setLayout(new GridLayout(1, 1));
            c.setBackground(Color.white);
            c.add(tf);
            JOptionPane.showMessageDialog(null, "Click on the panel, then type a key ", "Information",
                    JOptionPane.PLAIN_MESSAGE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
            setVisible(true);
        }
        public static void main(String[] args) {
            new KeyListenerEx00();
        }
    }
