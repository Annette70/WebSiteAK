<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="appRoot" value="${appRoot.request.contextPath}"/>
<html>
<head>
    <title>Pets search</title>
    <link rel="stylesheet" href="../WEB-INF/resources/style.css">
</head>
<body>
<jsp:include page="header.jsp" />
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Favorite Toy</th>
    </tr>
    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.detail.favoriteToy}</td>
        </tr>
    </c:forEach>
</table>
<a href="${appRoot}index.jsp">Home</a>
</body>
<jsp:include page="footer.jsp" />
</html>