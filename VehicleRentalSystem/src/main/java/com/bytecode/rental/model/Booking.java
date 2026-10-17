package com.bytecode.rental.model;

public class Booking {

    private int bookingId;
    private int userId;
    private int vehicleId;
    private int days;
    private double totalAmount;
    private String status;

    // Default Constructor
    public Booking() {
    }

    // Parameterized Constructor
    public Booking(int userId,
                   int vehicleId,
                   int days,
                   double totalAmount,
                   String status) {

        this.userId = userId;
        this.vehicleId = vehicleId;
        this.days = days;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}