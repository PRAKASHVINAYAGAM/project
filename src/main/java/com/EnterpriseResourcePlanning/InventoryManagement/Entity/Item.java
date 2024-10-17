package com.EnterpriseResourcePlanning.InventoryManagement.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "sku", unique = true, nullable = false)
    private String sku;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public Item() {
        this.createdDate = LocalDateTime.now();  // Set the creation date automatically
    }

    public Item(String name, int quantity, double price, String sku) {
        this();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.sku = sku;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        this.updatedDate = LocalDateTime.now();  // Update the date whenever the id is set
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedDate = LocalDateTime.now();  // Update the date whenever the name is modified
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updatedDate = LocalDateTime.now();  // Update the date whenever the quantity is modified
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.updatedDate = LocalDateTime.now();  // Update the date whenever the price is modified
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
        this.updatedDate = LocalDateTime.now();  // Update the date whenever the SKU is modified
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime now) {
    }

    public void setCreatedDate(LocalDateTime now) {
    }
}

