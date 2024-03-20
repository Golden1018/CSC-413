package cs413swingdemo;

import javax.swing.*;
import java.awt.*;

public class BankAccountPanel extends JPanel {
    private JTextField accountNumberField, accountBalanceField, accountTypeField;
    private JLabel accountNumberLabel, accountBalanceLabel, accountTypeLabel;

    public BankAccountPanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        accountNumberLabel = new JLabel("Account Number:");
        accountBalanceLabel = new JLabel("Balance:");
        accountTypeLabel = new JLabel("Account Type:");

        accountNumberField = new JTextField(20);
        accountBalanceField = new JTextField(20);
        accountTypeField = new JTextField(20);

        add(accountNumberLabel);
        add(accountNumberField);
        add(accountBalanceLabel);
        add(accountBalanceField);
        add(accountTypeLabel);
        add(accountTypeField);
    }
}