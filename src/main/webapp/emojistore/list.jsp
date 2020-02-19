<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<a id="Login" href="login.jsp"><u>Login</u></a>
<jsp:include page="header.jsp" />
<table>
    <tr>
        <td>Happy</td>
        <td><button type="button">Add</button></td>
        <td><button type="button">Delete</button></td>
    </tr>
    <tr>
        <td>Sad</td>
        <td><button type="button">Add</button></td>
        <td><button type="button">Delete</button></td>
    </tr>
    <tr>
        <td>Confused</td>
        <td><button type="button">Add</button></td>
        <td><button type="button">Delete</button></td>
    </tr>
</table>
<button type="button">Add Item</button>
<jsp:include page="footer.jsp" />
</body>
</html>
