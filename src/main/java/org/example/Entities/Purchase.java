package org.example.Entities;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a purchase entity in the pharmacy management system.
 * It includes details such as purchase ID, drug ID, purchase date, quantity,
 * total amount, and buyer's name.
 */
@Data
@Builder
public class Purchase {

    /**
     * Unique identifier for the purchase.
     */
    private int purchaseID;

    /**
     * Identifier for the drug being purchased.
     */
    private int drugID;

    /**
     * Date of the purchase.
     */
    private String purchaseDate;

    /**
     * Quantity of the drug purchased.
     */
    private int quantity;

    /**
     * Total amount for the purchase.
     */
    private double totalAmount;

    /**
     * Name of the buyer.
     */
    private String buyerName;
}
