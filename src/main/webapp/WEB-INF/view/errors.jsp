<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Emoji Reviews</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<jsp:include page="../../emojistore/header.jsp" />

<div id="container">
    <div id="content">
        <h3>An error occurred</h3>
        <p>${errorMessage}</p>
    </div>
</div>

<div>
    <p>
        <a href="${cp}/emoji/list4">Back to List</a>
    </p>
</div>

<jsp:include page="../../emojistore/footer.jsp" />
</body>
</html>
