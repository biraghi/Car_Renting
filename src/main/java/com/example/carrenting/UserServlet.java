package com.example.carrenting;

import com.example.carrenting.dao.Dao;
import com.example.carrenting.dao.UserDao;
import com.example.carrenting.entity.User;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    private final Dao dao = new Dao();
    private final UserDao userDao = dao.getUserDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id;
        String type = request.getParameter("typeGet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        switch(type){


            case "getUsers":
                request.setAttribute("userList", getUsers());
                dispatcher = request.getRequestDispatcher("user.jsp");
                dispatcher.forward(request, response);
                break;

            case "deleteUser":
                id = Integer.parseInt(request.getParameter("id"));
                userDao.deleteUserById(id);
                request.setAttribute("userList", getUsers());
                dispatcher = request.getRequestDispatcher("user.jsp");
                dispatcher.forward(request, response);
                break;


            case "addUser":
                request.setAttribute("typeGet", "addUser");
                dispatcher = request.getRequestDispatcher("formUser.jsp");
                dispatcher.forward(request, response);
                break;



            case "updateUser":
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("typeGet", "updateUser");
                request.setAttribute("user", userDao.getUserById(id));
                dispatcher = request.getRequestDispatcher("formUser.jsp");
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
            userDao.saveUser(setUser(request, type));
            out.print("<div class=\"alert alert-success\" role=\"alert\">\n" +
                    "    <strong>Success!</strong>\n" +
                    "</div>");
            dispatcher=request.getRequestDispatcher("formUser.jsp");
            dispatcher.include(request, response);
        }
        catch (Exception ex){
            out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "    <strong>Error!</strong> You should check in on some of those fields below.\n" +
                    "</div>");
            dispatcher=request.getRequestDispatcher("formUser.jsp");
            dispatcher.include(request, response);
        }

    }

    public List<User> getUsers(){
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        return users;
    }

    public User setUser(HttpServletRequest request, String type){
        User user = new User();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ITALY);
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"), formatter);
        if(type.equals("updateUser")){
            int id = Integer.parseInt(request.getParameter("id"));
            user.setId(id);
        }
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setBirthDate(birthdate);
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRoleName(false);
        return user;
    }


    public void destroy() {
    }
}