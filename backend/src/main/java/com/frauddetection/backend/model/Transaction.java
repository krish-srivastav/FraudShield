package com.frauddetection.backend.model;

public class Transaction {

    private Long id;
    private double amount;
    private String type;
    private String location;

    public Transaction() {
    }

    public Transaction(Long id, double amount, String type, String location) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
