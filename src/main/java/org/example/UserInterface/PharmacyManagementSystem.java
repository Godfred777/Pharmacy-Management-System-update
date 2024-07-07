package org.example.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PharmacyManagementSystem is a GUI application for managing pharmacy operations.
 * It provides options to add drugs, purchase drugs, search for drugs, view all drugs,
 * and view purchase history.
 */
public class PharmacyManagementSystem extends JFrame {

    /**
     * Constructs a new PharmacyManagementSystem GUI.
     * Sets up the main window and initializes all components.
     */
    public PharmacyManagementSystem() {
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addDrugButton = new JButton("Add Drug");
        JButton purchaseDrugButton = new JButton("Purchase Drug");
        JButton searchDrugButton = new JButton("Search Drug");
        JButton viewDrugsButton = new JButton("View All Drugs");
        JButton viewPurchaseHistoryButton = new JButton("View Purchase History");
        JButton exitButton = new JButton("Exit");

        panel.add(addDrugButton);
        panel.add(purchaseDrugButton);
        panel.add(searchDrugButton);
        panel.add(viewDrugsButton);
        panel.add(viewPurchaseHistoryButton);
        panel.add(exitButton);

        container.add(panel, BorderLayout.CENTER);

        addDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDrugFrame();
            }
        });

        purchaseDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaseFrame();
            }
        });

        searchDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchDrugFrame();
            }
        });

        viewDrugsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewDrugsFrame();
            }
        });

        viewPurchaseHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewPurchaseHistoryFrame();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    /**
     * The main method to run the PharmacyManagementSystem application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new PharmacyManagementSystem();
    }
}
