<%--
  Created by IntelliJ IDEA.
  User: Annette
  Date: 1/27/2020
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <a href="${appRoot}index.jsp">Home</a>
    <title>Item Details</title>
    <link rel="stylesheet" href="../WEB-INF/resources/style.css">
</head>
<body>
<a id="Login" href="../WEB-INF/view/login.jsp"><u>Login</u></a>
<h1>Emoji Store</h1>
<form>
    <label for="Name">Name</label>
    <input type="text" name="name" id="Name"><br>
    <label for="Price">Price</label>
    <input type="text" name="price" id="Price"><br>
    <label for="Color">Color</label>
    <input type="text" name="color" id="Color"><br>
</form>
<button type="button">Save</button>
</body>
</html>