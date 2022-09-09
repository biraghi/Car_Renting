<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Booking</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<h1>Booking</h1></br>
<div class="col-4">
  <table class="table table-striped table-bordered table-sm">
    <tr>
      <th scope="col">User Firstname</th>
      <th scope="col">Car License Plate</th>
      <th scope="col">Start Date</th>
      <th scope="col">Finish Date</th>
    </tr>
    <c:forEach  var="booking" items="${bookingList}">
      <tr>
        <td>${booking.user.firstname}</td>
        <td>${booking.car.licensePlate}</td>
        <td>${booking.startDate}</td>
        <td>${booking.finishDate}</td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
