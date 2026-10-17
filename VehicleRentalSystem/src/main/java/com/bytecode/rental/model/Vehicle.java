package com.bytecode.rental.model;

public class Vehicle {

    private int vehicleId;
    private String vehicleName;
    private String vehicleType;
    private double rentPerDay;
    private String status;

    // Default Constructor
    public Vehicle() {
    }

    // Parameterized Constructor
    public Vehicle(String vehicleName,
                   String vehicleType,
                   double rentPerDay,
                   String status) {

        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.rentPerDay = rentPerDay;
        this.status = status;
    }

    // Getters and Setters

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}