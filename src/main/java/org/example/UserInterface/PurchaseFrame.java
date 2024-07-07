package org.example.UserInterface;

import org.example.BackendLogic.DrugManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the frame for purchasing a drug in the pharmacy management system.
 * Provides a user interface to enter purchase details and save them to the database.
 */
public class PurchaseFrame extends JFrame {

    /**
     * Constructs a new PurchaseFrame.
     * Sets up the frame's title, size, layout, and components for entering purchase details.
     */
    public PurchaseFrame() {
        setTitle("Purchase Drug");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridLayout(7, 2));

        JLabel purchaseLabel = new JLabel("PurchaseId:");
        final JTextField purchaseIdField = new JTextField();

        JLabel drugIdLabel = new JLabel("DrugID:");
        final JTextField drugIdField = new JTextField();

        JLabel stockLabel = new JLabel("PurchaseDate:");
        final JTextField purchaseDateField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        final JTextField quantityField = new JTextField();

        JLabel amountLabel = new JLabel("TotalAmount:");
        final JTextField totalAmountField = new JTextField();

        JLabel buyerNameLabel = new JLabel("BuyerName:");
        final JTextField buyerNameField = new JTextField();

        JButton addButton = new JButton("Purchase Drug");

        container.add(purchaseLabel);
        container.add(purchaseIdField);
        container.add(drugIdLabel);
        container.add(drugIdField);
        container.add(stockLabel);
        container.add(purchaseDateField);
        container.add(quantityLabel);
        container.add(quantityField);
        container.add(amountLabel);
        container.add(totalAmountField);
        container.add(buyerNameLabel);
        container.add(buyerNameField);
        container.add(new JLabel());
        container.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int purchaseId = Integer.parseInt(purchaseIdField.getText());
                int drugId = Integer.parseInt(drugIdField.getText());
                String purchaseDate = purchaseDateField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double totalAmount = Double.parseDouble(totalAmountField.getText());
                String buyerName = buyerNameField.getText();

                DrugManager.purchaseDrug(purchaseId, drugId, purchaseDate, quantity, totalAmount, buyerName);
                JOptionPane.showMessageDialog(null, "Drug purchased successfully!");
                dispose();
            }
        });

        setVisible(true);
    }
}
