<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1>Users</h1></br>
    <table border="1">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Birthdate</th>
        </tr>
        <c:forEach  var="user" items="${userList}">
            <tr>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.username}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
