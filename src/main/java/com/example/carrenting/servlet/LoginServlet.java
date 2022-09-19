package com.example.carrenting.servlet;

import com.example.carrenting.dao.Dao;
import com.example.carrenting.dao.UserDao;
import com.example.carrenting.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final Dao dao = new Dao();

    private final UserDao userDao = dao.getUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;

        User user = new User();

        if(request.getParameter("typeGet").equals("logout")){
            request.getSession().removeAttribute("login");
            dispatcher=request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            try{
                user = userDao.getUserByUsername(request.getParameter("username"));
                if(request.getParameter("password").equals(user.getPassword())){
                    request.removeAttribute("password");
                    request.removeAttribute("username");
                    request.getSession().setAttribute("login", user);
                    dispatcher=request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                            "    <strong>Error!</strong> You should check in on some of those fields below.\n" +
                            "</div>");
                    dispatcher=request.getRequestDispatcher("login.jsp");
                    dispatcher.include(request, response);
                }
            }
            catch (Exception ex){
                out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                        "    <strong>Error!</strong> You should check in on some of those fields below.\n" +
                        "</div>");
                dispatcher=request.getRequestDispatcher("login.jsp");
                dispatcher.include(request, response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
