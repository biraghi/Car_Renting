package com.example.car_renting;

import com.example.car_renting.Dao.BookingDao;
import com.example.car_renting.entity.Booking;
import com.example.car_renting.entity.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingDao bookingDao = new BookingDao();
        List<Booking> bookings = bookingDao.getAllBookings();
        request.setAttribute("bookingList", bookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("booking.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
