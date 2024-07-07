package org.example.UserInterface;

import org.example.BackendLogic.DrugManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the frame for adding a new drug in the pharmacy management system.
 * Provides a user interface to enter drug details and save them to the database.
 */
public class AddDrugFrame extends JFrame {

    /**
     * Constructs a new AddDrugFrame.
     * Sets up the frame's title, size, layout, and components for entering drug details.
     */
    public AddDrugFrame() {
        setTitle("Add Drug");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        final JTextField nameField = new JTextField();

        JLabel supplierLabel = new JLabel("Supplier ID:");
        final JTextField supplierField = new JTextField();

        JLabel stockLabel = new JLabel("Stock:");
        final JTextField stockField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        final JTextField priceField = new JTextField();

        JButton addButton = new JButton("Add Drug");

        container.add(nameLabel);
        container.add(nameField);
        container.add(supplierLabel);
        container.add(supplierField);
        container.add(stockLabel);
        container.add(stockField);
        container.add(priceLabel);
        container.add(priceField);
        container.add(new JLabel());  // Placeholder to keep the grid layout consistent
        container.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int supplierID = Integer.parseInt(supplierField.getText());
                int stock = Integer.parseInt(stockField.getText());
                double price = Double.parseDouble(priceField.getText());

                DrugManager.addDrug(name, supplierID, stock, price);
                JOptionPane.showMessageDialog(null, "Drug added successfully!");
                dispose();
            }
        });

        setVisible(true);
    }
}
