<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Test" %></h1>
<br/>
<form action="user-servlet" method="get">
    <input type="hidden" name="typeGet" value="getUsers">
    <button class="btn btn-primary" type="submit">Visualizza Utenti</button>
</form>

<br><br>
<a class="btn btn-primary" href="CarServlet">Visualizza Macchine</a>
<br><br>
<a class="btn btn-primary" href="BookingServlet">Visualizza Prenotazioni</a>
</body>
</html>