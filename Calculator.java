import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton b[] = new JButton[16];
    private String op[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/"};

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField(20);
        display.setEditable(false);

        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        add(display, c);

        for (int i = 0; i < op.length; i++) {
            b[i] = new JButton(op[i]);
            b[i].addActionListener(this);

            c.gridx = i % 4;
            c.gridy = i / 4 + 1;
            c.gridwidth = 1;
            add(b[i], c);
        }

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("C")) {
            display.setText("");
        } else if (s.equals("=")) {
            try {
                String result = evaluate(display.getText());
                display.setText(result);
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else {
            display.setText(display.getText() + s);
        }
    }

    public String evaluate(String expression) {
        return new java.util.Scanner(expression).next();
    }

    public static void main(String[] args) {
        new Calculator();
    }
}