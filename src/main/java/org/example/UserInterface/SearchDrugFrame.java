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

    public class SearchDrugFrame extends JFrame {
        /*
        private static final String jdbc_url = "jdbc:mysql://localhost:3306/students";
        private static final String user = "root";
        private static final String password = "epiSode1";
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

        private void searchDrug(String name, JTextArea resultArea) {
            String drugData[] = DrugManager.searchDrug(name);
            for(String data : drugData) {
                resultArea.append(data);
            }
        }
    }


