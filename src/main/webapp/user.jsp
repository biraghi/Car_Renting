<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
    <h1>Users</h1></br>
    <div class="col-4">
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
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <div class="col-4">
        <h4>New User</h4>
        <div class="input-group mb-3 ">
            <form action="user-servlet" method="post">
                <p><strong>Firstname</strong></p>
                <input type="text" class="form-control" name="firstname" placeholder="Firstname" aria-label="Firstname" aria-describedby="basic-addon2"><br>
                <p><strong>Lastname</strong></p>
                <input type="text" class="form-control" name="lastname" placeholder="Lastname" aria-label="Lastname" aria-describedby="basic-addon2"><br>
                <p><strong>Birthdate</strong></p>
                <input type="date" class="form-control" name="birthdate" aria-describedby="basic-addon2"><br>
                <p><strong>Username</strong></p>
                <input type="text" class="form-control" name="username" placeholder="Username" aria-label="Username" aria-describedby="basic-addon2"><br>
                <p><strong>Password</strong></p>
                <input type="text" class="form-control" name="password" placeholder="Password" aria-label="Password" aria-describedby="basic-addon2"><br>
                <button class="btn btn-primary" type="submit">Submit</button>
            </form>

        </div>
    </div>
</body>
</html>
