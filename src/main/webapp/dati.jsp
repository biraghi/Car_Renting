<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
  <title>JSP - Hello World</title>
</head>
<body>

<div>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/Car_Renting_war_exploded/index.jsp">Car Renting</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Database</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="user-servlet?typeGet=getUsers">Users</a></li>
              <li><a class="dropdown-item" href="CarServlet?typeGet=getCars">Cars</a></li>
              <li><a class="dropdown-item" href="BookingServlet?typeGet=getBookings">Bookings</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<br>

<h1>Database</h1>
<br/>
<form action="user-servlet" method="get">
  <input type="hidden" name="typeGet" value="getUsers">
  <button class="btn btn-primary" type="submit">See Users</button>
</form>
<br><br>

<form action="CarServlet" method="get">
  <input type="hidden" name="typeGet" value="getCars">
  <button class="btn btn-primary" type="submit">See Cars</button>
</form>
<br><br>

<form action="BookingServlet" method="get">
  <input type="hidden" name="typeGet" value="getBookings">
  <button class="btn btn-primary" type="submit">See Bookings</button>
</form>

</body>
</html>