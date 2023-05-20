import javax.swing.*;
import java.awt.*;

public class TextControlsDemo extends JFrame {

    public TextControlsDemo() {
        super("Text Controls Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // create a panel to hold the controls
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        // add a text field
        JTextField textField = new JTextField(20);
        panel.add(new JLabel("Text Field: "));
        panel.add(textField);

        // add a password field
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(new JLabel("Password Field: "));
        panel.add(passwordField);

        // add a text area inside a scroll pane
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(new JLabel("Text Area: "));
        panel.add(scrollPane);

        // add the panel to the frame
        getContentPane().add(panel);

        // display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextControlsDemo();
    }

}
