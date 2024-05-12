package Assignment6View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Assignment6Controller.AccountDAO;
import Assignment6Model.BankAccount;

public class AccountList extends JFrame {

    private JList<BankAccount> accountList;
    private JButton showDetailButton;

    public AccountList() {
        initComponents();
    }

    public void displayAccounts(int customerId) {
        try {
            AccountDAO accountDAO = AccountDAO.getInstance();
            List<BankAccount> accounts = accountDAO.getBankRequestsByCustomerId(customerId);
            DefaultListModel<BankAccount> model = new DefaultListModel<>();
            for (BankAccount account : accounts) {
                model.addElement(account);
            }
            accountList.setModel(model);
        } catch (SQLException ex) {
            System.out.println("Error retrieving accounts: " + ex.getMessage());
            // Properly handle exception
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(accountList);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
        showDetailButton = new JButton("Show Detail");

        showDetailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BankAccount selectedAccount = accountList.getSelectedValue();
                if (selectedAccount != null) {
                    AccountDetail detailFrame = new AccountDetail();
                    detailFrame.setAccountDetails(selectedAccount);
                    detailFrame.setVisible(true);
                }
            }
        });
        

        this.setLayout(new java.awt.BorderLayout());
        this.add(scrollPane, java.awt.BorderLayout.CENTER);
        this.add(showDetailButton, java.awt.BorderLayout.SOUTH);
        pack(); // Adjusts window to the appropriate size based on its content
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountList().setVisible(true);
            }
        });
    }
}
