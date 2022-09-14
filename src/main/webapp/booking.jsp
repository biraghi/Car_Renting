<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
  <title>Booking</title>
</head>
<body>


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

<h1>Booking</h1></br>
<div class="col-4">
  <form action="BookingServlet" method="get">
    <input type="hidden" name="typeGet" value="addBooking">
    <button class="btn btn-primary" type="submit">New Booking</button>
  </form>
  <table class="table table-striped table-bordered table-sm">
    <tr>
      <th scope="col">User Username</th>
      <th scope="col">Car License Plate</th>
      <th scope="col">Start Date</th>
      <th scope="col">Finish Date</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
    <c:forEach  var="booking" items="${bookingList}">
      <tr>
        <td>${booking.user.username}</td>
        <td>${booking.car.licensePlate}</td>
        <td>${booking.startDate}</td>
        <td>${booking.finishDate}</td>
        <td>
          <form action="BookingServlet" method="get">
            <input type="hidden" name="typeGet" value="updateBooking">
            <input type="hidden" name="id" value="${booking.id}">
            <button class="btn btn-primary" type="submit">Update</button>
          </form>
        </td>
        <td>
          <form action="BookingServlet" method="get">
            <input type="hidden" name="typeGet" value="deleteBooking">
            <input type="hidden" name="id" value="${booking.id}">
            <button class="btn btn-primary" type="submit">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
