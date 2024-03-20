package cs413swingdemo;

import javax.swing.*;
import java.awt.*;

public class CustomerPanel extends JPanel {
    private JTextField nameField, emailField, customerIdField;
    private JLabel nameLabel, emailLabel, customerIdLabel;

    public CustomerPanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        customerIdLabel = new JLabel("Customer ID:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        customerIdField = new JTextField(20);

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(customerIdLabel);
        add(customerIdField);
    }
}
