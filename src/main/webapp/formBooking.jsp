<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>


  <c:if test="${typeGet == 'addBooking'}">
    <title>New Booking</title>
  </c:if>

  <c:if test="${typeGet == 'updateBooking'}">
    <title>Update Booking</title>
  </c:if>
</head>
<body>
<c:if test="${sessionScope.login.admin}">
  <c:set var="ad" scope="page" value="Admin"></c:set>
</c:if>
<c:if test="${!sessionScope.login.admin}">
  <c:set var="ad" scope="page" value="Customer"></c:set>
</c:if>
<div>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/Car_Renting_war_exploded/index.jsp">Car Renting</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li><a class="nav-link" href="LoginServlet?typeGet=logout">Logout</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Database</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="user-servlet?typeGet=getUsers">Users</a></li>
              <li><a class="dropdown-item" href="CarServlet?typeGet=getCars">Cars</a></li>
              <li><a class="dropdown-item" href="BookingServlet?typeGet=getBookings">Bookings</a></li>
            </ul>
          </li>
          <li><a class='nav-link text-light'><c:out value="Bentornato ${sessionScope.login.firstname} ${sessionScope.login.lastname}(${ad})"></c:out></a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<br>

<div class="col-4">
  <form action="BookingServlet" method="get">
    <input type="hidden" name="typeGet" value="getBookings">
    <button class="btn btn-primary" type="submit">Back to Bookings' List</button>
  </form>

  <c:if test="${typeGet == 'addBooking'}">
    <h4>New Booking</h4>
  </c:if>

  <c:if test="${typeGet == 'updateBooking'}">
    <h4>Update Booking</h4>
  </c:if>

  <div class="input-group mb-3 ">
    <form action="BookingServlet" method="post">
      <input type="hidden" class="form-control" value="${sessionScope.login.username}" name="username" placeholder="User Username" aria-label="User Username" aria-describedby="basic-addon2"><br>
        <p><strong>Car License Plate</strong></p>
        <input type="text" class="form-control" <c:if test="${typeGet.equals('addBookingWithLicense')}">readonly value="${licensePlate}"</c:if> name="licensePlate" placeholder="Car License Plate" aria-label="Car License Plate" aria-describedby="basic-addon2"><br>
        <p><strong>Start Date</strong></p>
        <input type="date" class="form-control" <c:if test="${typeGet.equals('addBookingWithLicense')}">readonly value="${startDate}"</c:if> name="startDate"  aria-describedby="basic-addon2"><br>
        <p><strong>Finish Date</strong></p>
        <input type="date" class="form-control" <c:if test="${typeGet.equals('addBookingWithLicense')}">readonly value="${finishDate}"</c:if> name="finishDate"  aria-describedby="basic-addon2"><br>
      <input type="hidden" name="typePost" value="${typeGet}">
      <button class="btn btn-primary" type="submit">Submit</button>
    </form>

  </div>
</div>
</body>
</html>
