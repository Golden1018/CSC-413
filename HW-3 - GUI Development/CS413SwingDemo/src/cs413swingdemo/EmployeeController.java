package cs413swingdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EmployeeController {

    private EmployeeFrame employeeFrame;
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeFrame employeeFrame, EmployeeDAO employeeDAO) {
        this.employeeFrame = employeeFrame;
        this.employeeDAO = employeeDAO;

        // Initializing event listeners for UI components
        initActionListeners();
    }

    private void initActionListeners() {
        employeeFrame.addSaveButtonActionListener(e -> saveEmployee());
        // Add more action listeners as needed
        // For example:
        // employeeFrame.addDeleteButtonActionListener(e -> deleteEmployee());
        // employeeFrame.addUpdateButtonActionListener(e -> updateEmployee());
        // Other listeners for text fields, checkboxes, radio buttons, etc.
    }

    private void saveEmployee() {
        String name = employeeFrame.getNameFieldText();
        String email = employeeFrame.getEmailFieldText();
        String phone = employeeFrame.getPhoneFieldText();
        String department = employeeFrame.getDepartmentFieldText();

        Employee emp = new Employee();
        emp.setUsername(name);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDepartment(department);

        try {
            employeeDAO.insert(emp);
            JOptionPane.showMessageDialog(employeeFrame, "Employee saved successfully!");
            employeeFrame.clearFormFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(employeeFrame, "Error saving employee: " + ex.getMessage());
        }
    }

    // Implement other event listener classes here, similar to SaveButtonListener
    // For example, a listener for text field changes might look like this:
    /*
     * class TextFieldListener implements ActionListener {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * // Handle text field changes here
     * }
     * }
     */
}
