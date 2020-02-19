<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pets</title>
    <link rel="stylesheet" href="css/style.css">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<jsp:include page="header.jsp" />
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Species</th>
    </tr>
    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.species}</td>
        </tr>
    </c:forEach>
</table>
<a href="index.jsp">Home</a>
<jsp:include page="footer.jsp" />
</body>
</html>