<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>


  <c:if test="${typeGet == 'addCar'}">
    <title>New Car</title>
  </c:if>

  <c:if test="${typeGet == 'updateCar'}">
    <title>Update Car</title>
  </c:if>
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
          <li><a class="nav-link" href="LoginServlet?typeGet=logout">Logout</a></li>
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

<div class="col-4">
  <form action="CarServlet" method="get">
    <input type="hidden" name="typeGet" value="getCars">
    <button class="btn btn-primary" type="submit">Back to Cars' List</button>
  </form>

  <c:if test="${typeGet == 'addCar'}">
    <h4>New Car</h4>
  </c:if>

  <c:if test="${typeGet == 'updateCar'}">
    <h4>Update Car</h4>
  </c:if>

  <div class="input-group mb-3 ">
    <form action="CarServlet" method="post">
      <p><strong>License Plate</strong></p>
      <input type="text" class="form-control" value="${car.licensePlate}" name="licensePlate" placeholder="License Plate" aria-label="License Plate" aria-describedby="basic-addon2"><br>
      <p><strong>Manufacturer</strong></p>
      <input type="text" class="form-control" value="${car.manufacturer}" name="manufacturer" placeholder="Manufacturer" aria-label="Manufacturer" aria-describedby="basic-addon2"><br>
      <p><strong>Model</strong></p>
      <input type="text" class="form-control" value="${car.model}" name="model" placeholder="Model" aria-label="Model" aria-describedby="basic-addon2"><br>
      <p><strong>Type Name</strong></p>
      <input type="text" class="form-control" value="${car.typeName}" name="typeName" placeholder="Type Name" aria-label="Type Name" aria-describedby="basic-addon2"><br>
      <p><strong>Year Registration</strong></p>
      <input type="date" class="form-control" value="${car.yearRegistration}" name="yearRegistration"  aria-describedby="basic-addon2"><br>
      <input type="hidden" name="typePost" value="${typeGet}">
      <input type="hidden" name="id" value="${car.id}">
      <button class="btn btn-primary" type="submit">Submit</button>
    </form>

  </div>
</div>
</body>
</html>
