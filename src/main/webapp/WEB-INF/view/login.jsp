<!--
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="resources/style.css">
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
</body>
</html>-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/donut-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Emoji Reviews</h2>
    </div>
</div>
<jsp:include page="../../emojistore/header.jsp" />

<div id="container">
    <div id="content">
        <h3>Login</h3>
        <form:form action="${cp}/authenticate" method="POST">
            <table>
                <c:if test="${param.logout != null}">
                    <tr>
                        <td></td>
                        <td>You have been logged out</td>
                    </tr>
                </c:if>
                <tr>
                    <td><label>Username</label></td>
                    <td><input type="text" name="username" value="user" required></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input type="text" name="password" value="p" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
                <c:if test="${param.error != null}">
                    <tr>
                        <td></td>
                        <td class="error">Invalid login</td>
                    </tr>
                </c:if>
            </table>
        </form:form>
    </div>

    <jsp:include page="../../emojistore/footer.jsp" />
</div>
</body>
</html>
