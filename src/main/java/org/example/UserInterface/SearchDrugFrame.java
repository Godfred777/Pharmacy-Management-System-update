package org.example.UserInterface;

import org.example.BackendLogic.DrugManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the frame for searching a drug in the pharmacy management system.
 * Provides a user interface to enter a drug name and display search results.
 */
public class SearchDrugFrame extends JFrame {

    /**
     * Constructs a new SearchDrugFrame.
     * Sets up the frame's title, size, layout, and components for searching a drug by name.
     */
    public SearchDrugFrame() {
        setTitle("Search Drug");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Drug Name:");
        final JTextField nameField = new JTextField();
        final JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JButton searchButton = new JButton("Search");

        container.add(nameLabel);
        container.add(nameField);
        container.add(searchButton);
        container.add(new JScrollPane(resultArea));

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                resultArea.setText("");
                searchDrug(name, resultArea);
            }
        });

        setVisible(true);
    }

    /**
     * Searches for a drug by its name and displays the results in the specified text area.
     *
     * @param name       the name of the drug to search for
     * @param resultArea the text area to display the search results
     */
    private void searchDrug(String name, JTextArea resultArea) {
        String[] drugData = DrugManager.searchDrug(name);
        if (drugData != null) {
            for (String data : drugData) {
                resultArea.append(data + "\n");
            }
        } else {
            resultArea.append("No drug found with the name: " + name);
        }
    }
}
