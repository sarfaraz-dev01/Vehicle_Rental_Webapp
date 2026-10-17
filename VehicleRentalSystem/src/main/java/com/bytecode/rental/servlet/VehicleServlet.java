package com.bytecode.rental.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bytecode.rental.dao.VehicleDAO;
import com.bytecode.rental.model.Vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        VehicleDAO dao = new VehicleDAO();

        List<Vehicle> vehicles =
                dao.getAvailableVehicles();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Available Vehicles</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Available Vehicles</h1>");

        for (Vehicle v : vehicles) {

            out.println("<div>");

            out.println("<h2>"
                    + v.getVehicleName()
                    + "</h2>");

            out.println("<p>Type: "
                    + v.getVehicleType()
                    + "</p>");

            out.println("<p>Rent: ₹"
                    + v.getRentPerDay()
                    + " / Day</p>");

            out.println(
                "<a href='book.html?vehicleId="
                + v.getVehicleId()
                + "'>Book Now</a>"
            );

            out.println("</div>");

            out.println("<hr>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}