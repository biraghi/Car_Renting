package com.example.car_renting;

import com.example.car_renting.Dao.UserDao;
import com.example.car_renting.entity.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sDate1="13/03/2002";
        Date date1;
        try {
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        UserDao userDao = new UserDao();
        User user = new User("lor.bir", "pass", "Lorenzo", "Biraghi", date1, true);

        try{
            userDao.saveUser(user);
            message = "Utente Salvato";
        }catch (Exception ex){
            message = "Errore";
        }





        // Hello
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}