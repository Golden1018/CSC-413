package cs413swingdemo;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
    private JTextField transactionIdField, amountField, typeField;
    private JLabel transactionIdLabel, amountLabel, typeLabel;

    public TransactionPanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        transactionIdLabel = new JLabel("Transaction ID:");
        amountLabel = new JLabel("Amount:");
        typeLabel = new JLabel("Type:");

        transactionIdField = new JTextField(20);
        amountField = new JTextField(20);
        typeField = new JTextField(20);

        add(transactionIdLabel);
        add(transactionIdField);
        add(amountLabel);
        add(amountField);
        add(typeLabel);
        add(typeField);
    }
}
