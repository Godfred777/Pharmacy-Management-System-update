package org.example.UserInterface;

import org.example.BackendLogic.DrugManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the frame for viewing all drugs in the pharmacy management system.
 * Provides a user interface to display all drugs stored in the database.
 */
public class ViewDrugsFrame extends JFrame {

    /**
     * Constructs a new ViewDrugsFrame.
     * Sets up the frame's title, size, layout, and components for viewing all drugs.
     */
    public ViewDrugsFrame() {
        setTitle("View All Drugs");
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
                viewAllDrugs(resultArea);
            }
        });

        setVisible(true);
    }

    /**
     * Fetches and displays all drugs from the database in the specified text area.
     *
     * @param resultArea the text area to display the list of drugs
     */
    private void viewAllDrugs(JTextArea resultArea) {
        final String[][] drugArray = DrugManager.viewAllDrugs();
        for (String[] row : drugArray) {
            for (String col : row) {
                resultArea.append(col + "\t"); // Display each column separated by tab for clarity
            }
            resultArea.append("\n"); // Move to the next line after displaying all columns of a row
        }
    }
}
