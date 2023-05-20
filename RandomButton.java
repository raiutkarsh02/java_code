import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
public class RandomButton extends JFrame {
    private JButton button;
    private Random random;

    public RandomButton() {
        random = new Random();


        setTitle("Random Button Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(null); // We'll position the button manually
        setLocationRelativeTo(null); // Center the window


        button = new JButton("Click me");
        button.setBounds(100, 50, 100, 30);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                moveButtonToRandomLocation();
            }
        });
        add(button);
        setVisible(true);
    }

    private void moveButtonToRandomLocation() {
        int width = getContentPane().getWidth() - button.getWidth();
        int height = getContentPane().getHeight() - button.getHeight();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        button.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomButton::new);
    }
}