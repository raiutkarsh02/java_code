import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.Timer;

public class MovingBall extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int xSpeed = 10;
    private int ySpeed = 20;

    public MovingBall() {
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > getWidth() - 50) {
            xSpeed = -xSpeed;
        }
        if (y < 0 || y > getHeight() - 50) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        MovingBall panel = new MovingBall();
        frame.add(panel);
        frame.setVisible(true);
    }
}