package com.example.car_renting;

import com.example.car_renting.Dao.CarDao;
import com.example.car_renting.Dao.UserDao;
import com.example.car_renting.entity.Car;
import com.example.car_renting.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDao carDao = new CarDao();
        List<Car> cars = carDao.getAllCars();
        request.setAttribute("carList", cars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("car.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
