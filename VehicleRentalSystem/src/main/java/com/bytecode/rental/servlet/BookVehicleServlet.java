package com.bytecode.rental.servlet;

import java.io.IOException;

import com.bytecode.rental.dao.BookingDAO;
import com.bytecode.rental.dao.VehicleDAO;
import com.bytecode.rental.model.Booking;
import com.bytecode.rental.model.User;
import com.bytecode.rental.model.Vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookVehicle")
public class BookVehicleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user =
                (User) session.getAttribute("user");

        if (user == null) {

            response.sendRedirect("login.html");

            return;
        }

        int vehicleId =
                Integer.parseInt(
                    request.getParameter("vehicleId")
                );

        int days =
                Integer.parseInt(
                    request.getParameter("days")
                );

        VehicleDAO vehicleDAO =
                new VehicleDAO();

        Vehicle vehicle =
                vehicleDAO.getVehicleById(vehicleId);

        double totalAmount =
                vehicle.getRentPerDay() * days;

        Booking booking = new Booking(
                user.getUserId(),
                vehicleId,
                days,
                totalAmount,
                "Booked"
        );

        BookingDAO bookingDAO =
                new BookingDAO();

        boolean result =
                bookingDAO.createBooking(booking);

        if (result) {

            response.sendRedirect("myBookings");

        } else {

            response.getWriter().println(
                "<h2>Booking Failed!</h2>"
            );
        }
    }
}