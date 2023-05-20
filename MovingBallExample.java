import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MovingBallExample extends JFrame {

    private AnimationPanel animationPanel;
    private Timer timer;
    private int ballX, ballY; // Current position of the ball
    private int ballSpeedX, ballSpeedY; // Speed of the ball along the x-axis and y-axis

    public MovingBallExample() {
        setTitle("Random Moving Ball Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the animation panel
        animationPanel = new AnimationPanel();
        getContentPane().add(animationPanel);

        // Create the timer to update the animation
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation();
            }
        });

        // Start the timer
        timer.start();
    }

    private void updateAnimation() {
        // Update the position of the ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Check if the ball has reached the edges
        if (ballX <= 0 || ballX >= animationPanel.getWidth()) {
            ballSpeedX = -ballSpeedX; // Reverse the direction
        }
        if (ballY <= 0 || ballY >= animationPanel.getHeight()) {
            ballSpeedY = -ballSpeedY; // Reverse the direction
        }

        // Repaint the animation panel
        animationPanel.repaint();
    }

    private class AnimationPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBall(g);
        }

        private void drawBall(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(ballX, ballY, 20, 20);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RandomMovingBallExample().setVisible(true);
            }
        });
    }

    // Generate a random number between min and max (inclusive)
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public MovingBallExample() {
        // ...
        // Existing code here

        // Generate random initial directions for the ball
        ballSpeedX = getRandomNumber(1, 5); // Speed between 1 and 5
        ballSpeedY = getRandomNumber(1, 5); // Speed between 1 and 5

        // Generate random initial positions for the ball
        ballX = getRandomNumber(0, animationPanel.getWidth() - 20); // Random x-coordinate within the panel
        ballY = getRandomNumber(0, animationPanel.getHeight() - 20); // Random y-coordinate within the panel
    }
}
