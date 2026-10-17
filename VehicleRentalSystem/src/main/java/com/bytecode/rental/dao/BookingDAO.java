package com.bytecode.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bytecode.rental.model.Booking;
import com.bytecode.rental.util.DBConnection;

public class BookingDAO {

    // =========================================
    // CREATE BOOKING
    // =========================================

    public boolean createBooking(Booking booking) {

        String sql = "INSERT INTO bookings " +
                     "(user_id, vehicle_id, days, total_amount, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getVehicleId());
            ps.setInt(3, booking.getDays());
            ps.setDouble(4, booking.getTotalAmount());
            ps.setString(5, booking.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // =========================================
    // GET USER BOOKINGS
    // =========================================

    public List<Booking> getBookingsByUserId(int userId) {

        List<Booking> bookings = new ArrayList<>();

        String sql = "SELECT * FROM bookings " +
                     "WHERE user_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(
                        rs.getInt("booking_id"));

                booking.setUserId(
                        rs.getInt("user_id"));

                booking.setVehicleId(
                        rs.getInt("vehicle_id"));

                booking.setDays(
                        rs.getInt("days"));

                booking.setTotalAmount(
                        rs.getDouble("total_amount"));

                booking.setStatus(
                        rs.getString("status"));

                bookings.add(booking);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return bookings;
    }
}