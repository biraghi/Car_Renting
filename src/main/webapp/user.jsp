<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
    <title>Users</title>
</head>
<body>
    <a class="btn btn-primary btn-sm" href="index.jsp">Back to Home</a>
    <h1>Users</h1></br>
    <div class="col-4">
        <form action="user-servlet" method="get">
            <input type="hidden" name="typeGet" value="addUser">
            <button class="btn btn-primary" type="submit">New User</button>
        </form>
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th scope="col">Firstname</th>
                <th scope="col">Lastname</th>
                <th scope="col">Username</th>
                <th scope="col">Birthdate</th>
            </tr>
            <c:forEach  var="user" items="${userList}">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                    <td>${user.birthDate}</td>
                    <td>
                        <form action="user-servlet" method="get">
                            <input type="hidden" name="typeGet" value="updateUser">
                            <input type="hidden" name="id" value="${user.id}">
                            <button class="btn btn-primary" type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
</body>
</html>
