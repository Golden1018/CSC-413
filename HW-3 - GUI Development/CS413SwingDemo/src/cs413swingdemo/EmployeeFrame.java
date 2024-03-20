package cs413swingdemo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class EmployeeFrame extends javax.swing.JFrame {

        private JButton saveButton;
        private JTextField nameField, emailField, phoneField, departmentField;

        public EmployeeFrame() {
                initComponents();
        }

        private void initComponents() {
                setLayout(null); // Using null layout for demonstration, but consider using a LayoutManager

                JLabel heading = new JLabel("Add Employee");
                heading.setFont(new Font("Tahoma", Font.BOLD, 14));
                heading.setBounds(120, 10, 160, 20); // Example bounds

                nameField = new JTextField();
                nameField.setBounds(20, 40, 360, 25);
                emailField = new JTextField();
                emailField.setBounds(20, 70, 360, 25);
                phoneField = new JTextField();
                phoneField.setBounds(20, 100, 360, 25);
                departmentField = new JTextField();
                departmentField.setBounds(20, 130, 360, 25);

                saveButton = new JButton("Save Employee");
                saveButton.setBounds(120, 160, 160, 25);

                // Adding components to the frame
                add(heading);
                add(nameField);
                add(emailField);
                add(phoneField);
                add(departmentField);
                add(saveButton);

                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setSize(400, 250); // Adjusted to fit all components
                setLocationRelativeTo(null); // Center the window
        }

        public void addSaveButtonActionListener(ActionListener listener) {
                saveButton.addActionListener(listener);
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField3;
        private javax.swing.JTextField jTextField4;
        // End of variables declaration

        public String getNameFieldText() {
                return jTextField1.getText();
        }

        public String getEmailFieldText() {
                return jTextField2.getText();
        }

        public String getPhoneFieldText() {
                // Assuming jTextField3 is your phone input field
                return jTextField3.getText();
        }

        public String getDepartmentFieldText() {
                // Assuming jTextField4 is your department input field
                return jTextField4.getText();
        }

        public void clearFormFields() {
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                // Clear other fields as needed
        }

        // Add similar methods for other components like text fields, checkboxes, and
        // radio buttons.

        // Implement similar getter methods for other fields

}
