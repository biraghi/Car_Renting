package com.example.car_renting;

import com.example.car_renting.Dao.UserDao;
import com.example.car_renting.entity.User;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        request.setAttribute("userList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = new User();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"), formatter);

        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setBirthDate(birthdate);
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRoleName(false);

        userDao.saveUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}