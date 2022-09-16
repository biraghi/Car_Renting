package com.example.carrenting;

import com.example.carrenting.dao.CarDao;
import com.example.carrenting.dao.Dao;
import com.example.carrenting.entity.Car;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    private final Dao dao = new Dao();
    private final CarDao carDao = dao.getCarDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String type = request.getParameter("typeGet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        switch(type){


            case "getCars":
                request.setAttribute("carList", getCars());
                dispatcher = request.getRequestDispatcher("car.jsp");
                dispatcher.forward(request, response);
                break;

            case "getCarsDisp":
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ITALY);
                LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), formatter);
                LocalDate finishDate = LocalDate.parse(request.getParameter("finishDate"), formatter);
                request.setAttribute("carsDisp", getCarsDisp(startDate, finishDate));
                dispatcher = request.getRequestDispatcher("autoDisponibili.jsp");
                dispatcher.forward(request, response);
                break;

            case "deleteCar":
                id = Integer.parseInt(request.getParameter("id"));
                carDao.deleteCarById(id);
                request.setAttribute("carList", getCars());
                dispatcher = request.getRequestDispatcher("car.jsp");
                dispatcher.forward(request, response);
                break;


            case "addCar":
                request.setAttribute("typeGet", "addCar");
                dispatcher = request.getRequestDispatcher("formCar.jsp");
                dispatcher.forward(request, response);
                break;



            case "updateCar":
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("typeGet", "updateCar");
                request.setAttribute("car", carDao.getCarById(id));
                dispatcher = request.getRequestDispatcher("formCar.jsp");
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
            carDao.saveCar(setCar(request, type));
            out.print("<div class=\"alert alert-success\" role=\"alert\">\n" +
                    "    <strong>Success!</strong>\n" +
                    "</div>");
            dispatcher=request.getRequestDispatcher("formCar.jsp");
            dispatcher.include(request, response);
        }
        catch (Exception ex){
            out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "    <strong>Error!</strong> You should check in on some of those fields below.\n" +
                    "</div>");
            dispatcher=request.getRequestDispatcher("formCar.jsp");
            dispatcher.include(request, response);
        }
    }


    public List<Car> getCars(){
        List<Car> cars = carDao.getAllCars();
        return cars;
    }

    public List<Car> getCarsDisp(LocalDate start, LocalDate finish){
        List<Car> cars = carDao.getCarDisponibili(start, finish);
        return cars;
    }

    public Car setCar(HttpServletRequest request, String type){
        Car car = new Car();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ITALY);
        LocalDate yearRegistration = LocalDate.parse(request.getParameter("yearRegistration"), formatter);
        if(type.equals("updateCar")){
            int id = Integer.parseInt(request.getParameter("id"));
            car.setId(id);
        }
        car.setLicensePlate(request.getParameter("licensePlate"));
        car.setManufacturer(request.getParameter("manufacturer"));
        car.setYearRegistration(yearRegistration);
        car.setModel(request.getParameter("model"));
        car.setTypeName(request.getParameter("typeName"));
        return car;
    }
}
