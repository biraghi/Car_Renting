<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<h1><%= "Test" %></h1>
<br/>

<a class="btn btn-primary" href="user-servlet">Visualizza Utenti</a>
<br><br>
<a class="btn btn-primary" href="CarServlet">Visualizza Macchine</a>
<br><br>
<a class="btn btn-primary" href="BookingServlet">Visualizza Prenotazioni</a>
</body>
</html>