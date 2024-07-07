package org.example.UserInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class ViewPurchaseHistoryFrame extends JFrame {
        private static final String jdbc_url = "jdbc:mysql://localhost:3306/students";
        private static final String user = "root";
        private static final String password = "epiSode1";
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

        private void viewPurchaseHistory(JTextArea resultArea) {
            String querySQL = "SELECT * FROM PurchaseHistory ORDER BY PurchaseDate";

            try (Connection conn = DriverManager.getConnection(jdbc_url,user,password);
                 PreparedStatement pstmt = conn.prepareStatement(querySQL);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    resultArea.append("PurchaseID: " + rs.getInt("PurchaseID") + "\n");
                    resultArea.append("DrugID: " + rs.getInt("DrugID") + "\n");
                    resultArea.append("PurchaseDate: " + rs.getTimestamp("PurchaseDate") + "\n");
                    resultArea.append("Quantity: " + rs.getInt("Quantity") + "\n");
                    resultArea.append("TotalAmount: " + rs.getDouble("TotalAmount") + "\n");
                    resultArea.append("BuyerName: " + rs.getString("BuyerName") + "\n");
                    resultArea.append("-----------------------\n");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error viewing purchase history!");
            }
        }
    }


