package GUI.sum.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class DrawingLine extends JFrame {
    JButton drawButton = new JButton("Draw Line Demo");
    JPanel drawPanel = new JPanel();
    boolean lineThere = false;

    public DrawingLine() {
        super("Drawing Line");
        setResizable(false);
        drawPanel.setPreferredSize(new Dimension(300, 200));
        drawPanel.setBackground(Color.WHITE);
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawButtonAction(e);
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * screenSize.width - getWidth()), (int) (0.5 * screenSize.height - getHeight()),
                getWidth(), getHeight());
        setSize(300,300);
        setVisible(true);
    }

    private void drawButtonAction(ActionEvent e) {
        if (drawButton.getText().equals("Draw Line")) {
            drawButton.setText("Clear Line");
            lineThere = true;
        } else {
            drawButton.setText("Draw Line");
            lineThere = false;
        }
        Graphics2D g2D = (Graphics2D) drawPanel.getGraphics();
        Line2D.Double line = new Line2D.Double(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
        if (lineThere)
            g2D.setPaint(Color.BLUE);
        else
            g2D.setPaint(drawPanel.getBackground());
        g2D.draw(line);
        g2D.dispose();
    }

    public static void main(String[] args) {
        new DrawingLine();
    }
}
