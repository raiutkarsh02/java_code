import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class movingbox extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private int x = 200;
    private int y = 200;

    public movingbox() {
        super("Moving Box");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        button = new JButton("Move");
        button.addActionListener(this);

        panel.setLayout(null);
        panel.add(button);
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            x += 10;
            y += 10;
            panel.repaint();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(x, y, 50, 50);
    }

    public static void main(String[] args) {
        new movingbox();
    }
}