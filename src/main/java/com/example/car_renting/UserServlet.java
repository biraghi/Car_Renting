package com.example.car_renting;

import com.example.car_renting.Dao.UserDao;
import com.example.car_renting.entity.User;

import java.io.*;
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

    public void destroy() {
    }
}