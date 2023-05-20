import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationForm extends JFrame {
    private JTextField nameField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private JCheckBox javaCheckbox;
    private JCheckBox pythonCheckbox;
    private JList<String> stateList;
    private JButton submitButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        // Gender radio buttons
        JLabel genderLabel = new JLabel("Gender:");
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Language checkboxes
        JLabel languageLabel = new JLabel("Languages:");
        javaCheckbox = new JCheckBox("Java");
        pythonCheckbox = new JCheckBox("Python");

        // State list
        JLabel stateLabel = new JLabel("State:");
        String[] states = {"State 1", "State 2", "State 3"};
        stateList = new JList<>(states);
        stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane stateScrollPane = new JScrollPane(stateList);
        stateScrollPane.setPreferredSize(new Dimension(150, 70));

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(genderLabel);
        add(maleRadio);
        add(femaleRadio);
        add(languageLabel);
        add(javaCheckbox);
        add(pythonCheckbox);
        add(stateLabel);
        add(stateScrollPane);
        add(submitButton);

        setVisible(true);
    }

    private void submitForm() {
        String name = nameField.getText();
        String gender = maleRadio.isSelected() ? "Male" : "Female";
        String languages = "";
        if (javaCheckbox.isSelected()) {
            languages += "Java ";
        }
        if (pythonCheckbox.isSelected()) {
            languages += "Python ";
        }
        String state = stateList.getSelectedValue();

        // Connect to the database and insert the data
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");
            String query = "INSERT INTO users (name, gender, languages, state) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setString(3, languages);
            statement.setString(4, state);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration successful!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
