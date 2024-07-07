package org.example.BackendLogic;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Manages drug-related operations in the pharmacy management system.
 * Provides methods to add drugs, purchase drugs, search for drugs, and view all drugs.
 */
public class DrugManager {
    // Database connection details
    private static final String jdbc_url = "jdbc:mysql://localhost:3306/students";
    private static final String user = "root";
    private static final String password = "boldheart@34";

    /**
     * Adds a new drug to the database.
     *
     * @param name       the name of the drug
     * @param supplierID the ID of the supplier
     * @param stock      the stock quantity
     * @param price      the price of the drug
     */
    public static void addDrug(String name, int supplierID, int stock, double price) {
        String insertSQL = "INSERT INTO Drugs (Name, SupplierID, Stock, Price) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(jdbc_url, user, password);
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setInt(2, supplierID);
            pstmt.setInt(3, stock);
            pstmt.setDouble(4, price);
            pstmt.executeUpdate();

            System.out.println("Drug added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Records a drug purchase in the database.
     *
     * @param purchaseId  the ID of the purchase
     * @param drugId      the ID of the drug
     * @param purchaseDate the date of the purchase
     * @param quantity    the quantity purchased
     * @param totalAmount the total amount for the purchase
     * @param buyerName   the name of the buyer
     */
    public static void purchaseDrug(int purchaseId, int drugId, String purchaseDate, int quantity, double totalAmount, String buyerName) {
        String insertSQL = "INSERT INTO PurchaseHistory (PurchaseId, DrugID, PurchaseDate, Quantity, TotalAmount, BuyerName) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(jdbc_url, user, password);
            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, purchaseId);
            pstmt.setInt(2, drugId);
            pstmt.setString(3, purchaseDate);
            pstmt.setInt(4, quantity);
            pstmt.setDouble(5, totalAmount);
            pstmt.setString(6, buyerName);

            pstmt.executeUpdate();

            System.out.println("Drug purchased successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Searches for a drug in the database by name.
     *
     * @param name the name of the drug to search for
     * @return an array containing the drug details if found, otherwise null
     */
    public static String[] searchDrug(String name) {
        String querySQL = "SELECT * FROM Drugs WHERE Name LIKE ?";

        String[] data = null;
        try (Connection conn = DriverManager.getConnection(jdbc_url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(querySQL)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            int columnCount = rs.getMetaData().getColumnCount();
            data = new String[columnCount];

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    data[i] = rs.getString(i + 1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Retrieves all drugs from the database.
     *
     * @return a 2D array containing details of all drugs
     */
    public static String[][] viewAllDrugs() {
        ArrayList<String[]> dataList = new ArrayList<>();

        String querySQL = "SELECT * FROM Drugs";

        try (Connection conn = DriverManager.getConnection(jdbc_url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(querySQL)) {

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getString(i + 1);
                }
                dataList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[][] dataArray = new String[dataList.size()][];
        dataArray = dataList.toArray(dataArray);

        return dataArray;
    }
}
