package org.example.UserInterface;
    import org.example.BackendLogic.DrugManager;

    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class ViewDrugsFrame extends JFrame {
       // private static final String jdbc_url = "jdbc:mysql://localhost:3306/students";
        //private static final String user = "root";
        //private static final String password = "epiSode1";
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

        private void viewAllDrugs(JTextArea resultArea) {
            final String[][] drugArray = DrugManager.viewAllDrugs();
            for (String[] row : drugArray) {
                for (String col : row) {
                    resultArea.append(col);
                }
            }
        }
    }


