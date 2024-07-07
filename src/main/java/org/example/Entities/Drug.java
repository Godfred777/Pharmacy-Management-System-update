package org.example.Entities;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a drug entity in the pharmacy management system.
 * It includes details such as drug ID, name, supplier ID, stock quantity, and price.
 */
@Data
@Builder
public class Drug {

    /**
     * Unique identifier for the drug.
     */
    private int drugID;

    /**
     * Name of the drug.
     */
    private String name;

    /**
     * Identifier for the supplier of the drug.
     */
    private int supplierID;

    /**
     * Quantity of the drug in stock.
     */
    private int stock;

    /**
     * Price of the drug.
     */
    private double price;
}
