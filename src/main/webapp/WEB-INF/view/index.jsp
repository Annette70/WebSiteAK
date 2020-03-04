<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<div>
    <a href="<c:url value="/"/>">Home</a>
    <a href="<c:url value="/showLogin"/>">Login</a>
    <a href="<c:url value="/showSearch"/>">Search</a>
</div>
<jsp:include page="../../emojistore/header.jsp" />
<p>Browse Items</p>
<jsp:include page="../../emojistore/footer.jsp" />
</body>
</html>
