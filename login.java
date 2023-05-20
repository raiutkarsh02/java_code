import java.awt.*;
import javax.swing.*;

public class LoginGridLayout extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGridLayout() {
        super("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(centerPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGridLayout();
    }
}