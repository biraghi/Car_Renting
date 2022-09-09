<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cars</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<h1>Cars</h1></br>
<div class="col-4">
  <table class="table table-striped table-bordered table-sm">
    <tr>
      <th scope="col">License Plate</th>
      <th scope="col">Manufacturer</th>
      <th scope="col">Model</th>
      <th scope="col">Type Name</th>
      <th scope="col">Year Registration</th>
    </tr>
    <c:forEach  var="car" items="${carList}">
      <tr>
        <td>${car.licensePlate}</td>
        <td>${car.manufacturer}</td>
        <td>${car.model}</td>
        <td>${car.yearRegistration}</td>
        <td>${car.typeName}</td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
