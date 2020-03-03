
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div>
    <a href="controller/showHomePage">Home</a>
    <a href="controller/showLoginPage">Login</a>
    <a href="controller/showSearch">Search</a>
</div>
<jsp:include page="header.jsp" />
<p>Browse Items</p>
<jsp:include page="footer.jsp" />
</body>
</html>
