import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomNumberGenerator extends JFrame implements ActionListener {

    private JLabel randomNumberLabel;

    public RandomNumberGenerator() {
        setTitle("Random Number Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        randomNumberLabel = new JLabel();
        updateRandomNumberLabel();
        panel.add(randomNumberLabel);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(this);
        panel.add(generateButton);

        add(panel);
        pack();
        setVisible(true);
    }

    private void updateRandomNumberLabel() {
        int randomNumber = (int) (Math.random() * 10 + 1);
        randomNumberLabel.setText("Random number: " + randomNumber);
    }

    public void actionPerformed(ActionEvent e) {
        updateRandomNumberLabel();
    }

    public static void main(String[] args) {
        new RandomNumberGenerator();
    }
}

import swing.awt.*;
import javax.swing.*;
