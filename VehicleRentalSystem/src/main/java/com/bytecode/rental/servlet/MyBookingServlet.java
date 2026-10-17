package com.bytecode.rental.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bytecode.rental.dao.BookingDAO;
import com.bytecode.rental.model.Booking;
import com.bytecode.rental.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myBookings")
public class MyBookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute("user");

        if (user == null) {

            response.sendRedirect("login.html");

            return;
        }

        BookingDAO dao =
                new BookingDAO();

        List<Booking> bookings =
                dao.getBookingsByUserId(
                    user.getUserId()
                );

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Bookings</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>My Bookings</h1>");

        for (Booking b : bookings) {

            out.println("<div>");

            out.println(
                "<h3>Booking ID: "
                + b.getBookingId()
                + "</h3>"
            );

            out.println(
                "<p>Vehicle ID: "
                + b.getVehicleId()
                + "</p>"
            );

            out.println(
                "<p>Days: "
                + b.getDays()
                + "</p>"
            );

            out.println(
                "<p>Total Amount: ₹"
                + b.getTotalAmount()
                + "</p>"
            );

            out.println(
                "<p>Status: "
                + b.getStatus()
                + "</p>"
            );

            out.println("</div>");

            out.println("<hr>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}