<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="../WEB-INF/resources/style.css">
</head>
<body>
<jsp:include page="header.jsp" />
<form action="search" method="get">
    Search by species <input name="speciesnm" type="text">
    <br>
    <input type="submit">
</form>
<jsp:include page="footer.jsp" />
</body>
</html>