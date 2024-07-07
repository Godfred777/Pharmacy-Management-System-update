package org.example.Entities;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a supplier entity in the pharmacy management system.
 * It includes details such as supplier ID, name, and location.
 */
@Data
@Builder
public class Supplier {

    /**
     * Unique identifier for the supplier.
     */
    private int supplierID;

    /**
     * Name of the supplier.
     */
    private String name;

    /**
     * Location of the supplier.
     */
    private String location;
}
