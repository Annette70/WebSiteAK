<%--
  Created by IntelliJ IDEA.
  User: Annette
  Date: 1/27/2020
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Login to Emoji Store</h1>
<form>
    <label for="myUsername">Username</label>
    <input type="text" name="username" id="myUsername" required><br>
    <label for="myPassword">Password</label>
    <input type="text" name="password" id="myPassword" required><br>
</form>
<button type="button">Login</button>
<jsp:include page="footer.jsp" />
</body>
</html>
