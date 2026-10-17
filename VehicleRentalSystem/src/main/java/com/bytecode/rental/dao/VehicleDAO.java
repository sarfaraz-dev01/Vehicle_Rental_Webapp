package com.bytecode.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bytecode.rental.model.Vehicle;
import com.bytecode.rental.util.DBConnection;

public class VehicleDAO {

   
    public List<Vehicle> getAvailableVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicles " +
                     "WHERE status = 'Available'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Vehicle vehicle = new Vehicle();

                vehicle.setVehicleId(
                        rs.getInt("vehicle_id"));

                vehicle.setVehicleName(
                        rs.getString("vehicle_name"));

                vehicle.setVehicleType(
                        rs.getString("vehicle_type"));

                vehicle.setRentPerDay(
                        rs.getDouble("rent_per_day"));

                vehicle.setStatus(
                        rs.getString("status"));

                vehicles.add(vehicle);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return vehicles;
    }


    // =========================================
    // GET VEHICLE BY ID
    // =========================================

    public Vehicle getVehicleById(int vehicleId) {

        String sql = "SELECT * FROM vehicles " +
                     "WHERE vehicle_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vehicleId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Vehicle vehicle = new Vehicle();

                vehicle.setVehicleId(
                        rs.getInt("vehicle_id"));

                vehicle.setVehicleName(
                        rs.getString("vehicle_name"));

                vehicle.setVehicleType(
                        rs.getString("vehicle_type"));

                vehicle.setRentPerDay(
                        rs.getDouble("rent_per_day"));

                vehicle.setStatus(
                        rs.getString("status"));

                return vehicle;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}