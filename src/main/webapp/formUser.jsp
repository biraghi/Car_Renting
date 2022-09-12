<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>


  <c:if test="${typeGet == 'addUser'}">
    <title>New User</title>
  </c:if>

  <c:if test="${typeGet == 'updateUser'}">
    <title>Update User</title>
  </c:if>
</head>
<body>
  <div class="col-4">
    <form action="user-servlet" method="get">
      <input type="hidden" name="typeGet" value="getUsers">
      <button class="btn btn-primary" type="submit">Back to User's List</button>
    </form>

    <c:if test="${typeGet == 'addUser'}">
      <h4>New User</h4>
    </c:if>

    <c:if test="${typeGet == 'updateUser'}">
      <h4>Update User</h4>
    </c:if>

    <div class="input-group mb-3 ">
    <form action="user-servlet" method="post">
      <p><strong>Firstname</strong></p>
      <input type="text" class="form-control" value="${user.firstname}" name="firstname" placeholder="Firstname" aria-label="Firstname" aria-describedby="basic-addon2"><br>
      <p><strong>Lastname</strong></p>
      <input type="text" class="form-control" value="${user.lastname}" name="lastname" placeholder="Lastname" aria-label="Lastname" aria-describedby="basic-addon2"><br>
      <p><strong>Birthdate</strong></p>
      <input type="date" class="form-control" value="${user.birthDate}" name="birthdate" aria-describedby="basic-addon2"><br>
      <p><strong>Username</strong></p>
      <input type="text" class="form-control" value="${user.username}" name="username" placeholder="Username" aria-label="Username" aria-describedby="basic-addon2"><br>
      <p><strong>Password</strong></p>
      <input type="text" class="form-control" value="${user.password}" name="password" placeholder="Password" aria-label="Password" aria-describedby="basic-addon2"><br>
      <input type="hidden" name="typePost" value="${typeGet}">
      <input type="hidden" name="id" value="${user.id}">
      <button class="btn btn-primary" type="submit">Submit</button>
    </form>

  </div>
  </div>
</body>
</html>
