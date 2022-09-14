package com.example.carrenting;

import com.example.carrenting.dao.BookingDao;
import com.example.carrenting.dao.CarDao;
import com.example.carrenting.dao.UserDao;
import com.example.carrenting.entity.Booking;
import com.example.carrenting.entity.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    private final BookingDao bookingDao = new BookingDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("typeGet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        switch(type){


            case "getBookings":
                request.setAttribute("bookingList", getBookings());
                dispatcher = request.getRequestDispatcher("booking.jsp");
                dispatcher.forward(request, response);
                break;


            case "addBooking":
                request.setAttribute("typeGet", "addBooking");
                dispatcher = request.getRequestDispatcher("formBooking.jsp");
                dispatcher.forward(request, response);
                break;



            case "updateBooking":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("typeGet", "updateBooking");
                request.setAttribute("booking", bookingDao.getBookingById(id));
                dispatcher = request.getRequestDispatcher("formBooking.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                out.println("Error");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("typePost");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;

        try{
            bookingDao.saveBooking(setBooking(request, type));
            dispatcher=request.getRequestDispatcher("formBooking.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception ex){
            out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "    <strong>Error!</strong> You should check in on some of those fields below.\n" +
                    "</div>");
            dispatcher=request.getRequestDispatcher("formBooking.jsp");
            dispatcher.include(request, response);
        }
    }


    public List<Booking> getBookings(){
        List<Booking> bookings = bookingDao.getAllBookings();
        return bookings;
    }

    public Booking setBooking(HttpServletRequest request, String type){
        UserDao userDao = new UserDao();
        CarDao carDao = new CarDao();
        Booking booking = new Booking();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
        LocalDate finishDate = LocalDate.parse(request.getParameter("finishDate"), formatter);
        if(type.equals("updateBooking")){
            int id = Integer.parseInt(request.getParameter("id"));
            booking.setId(id);
        }
        booking.setUser(userDao.getUserByUsername(request.getParameter("username")));
        booking.setCar(carDao.getCarByLicensePlate(request.getParameter("licensePlate")));
        booking.setStartDate(startDate);
        booking.setFinishDate(finishDate);

        return booking;
    }
}
