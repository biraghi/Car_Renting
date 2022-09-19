<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
    <title>Car Renting</title>
</head>
<body>
<div class="d-flex align-items-center justify-content-center">


    <form action="LoginServlet" method="get">
        <div>
            <h2>Login</h2>
        </div>
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="text" name="username" placeholder="Username" class="form-control" />
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password" name="password" placeholder="Password" class="form-control" />
        </div>

        <input type="hidden" name="typeGet" value="login">
        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

    </form>
</div>

</body>
</html>