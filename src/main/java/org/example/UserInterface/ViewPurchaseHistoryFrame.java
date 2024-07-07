package org.example.UserInterface;

import org.example.BackendLogic.DrugManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents the frame for viewing purchase history in the pharmacy management system.
 * Provides a user interface to display a list of all purchases stored in the database.
 */
public class ViewPurchaseHistoryFrame extends JFrame {

    private static final String jdbc_url = "jdbc:mysql://localhost:3306/students";
    private static final String user = "root";
    private static final String password = "epiSode1";

    /**
     * Constructs a new ViewPurchaseHistoryFrame.
     * Sets up the frame's title, size, layout, and components for viewing purchase history.
     * Initializes a refresh button to update the displayed purchase history.
     */
    public ViewPurchaseHistoryFrame() {
        setTitle("View Purchase History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        final JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JButton refreshButton = new JButton("Refresh");

        container.add(refreshButton, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                viewPurchaseHistory(resultArea);
            }
        });

        setVisible(true);
    }

    /**
     * Fetches and displays the purchase history from the database in the specified text area.
     *
     * @param resultArea the text area to display the purchase history
     */
    private void viewPurchaseHistory(JTextArea resultArea) {
        final String[][] drugArray = DrugManager.viewAllDrugs();
        for (String[] row : drugArray) {
            for (String col : row) {
                resultArea.append(col + "\t"); // Display each column separated by tab for clarity
            }
            resultArea.append("\n"); // Move to the next line after displaying all columns of a row
        }
    }
}
