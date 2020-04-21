<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Donut Reviews - Edit Donut</title>
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/donut-form-style.css">
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/select-style.css">
</head>
<body>

<jsp:include page="../../emojistore/header.jsp" />

<div id="container">

    <div id="content">
        <form:form action="${cp}/donut/save" modelAttribute="aEmoji" enctype="multipart/form-data"
                   method="post">
            <form:hidden path="id" value="${aEmoji.id}"/>
            <form:hidden path="imageId" value="${aEmoji.imageId}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="emote"/>
                        <form:errors path="emote" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Calories</label></td>
                    <td><form:input path="rating"/>
                        <form:errors path="rating" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Shop</label></td>
                    <td>
                        <form:select path="characterName" items="${emojis}" itemLabel="name" itemValue="id"
                                     cssClass="select-css">
                        </form:select>
                        <form:errors path="characterName" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td>
                        <input type="file" name="imageFile">
                        <c:if test="${aEmoji.imageId != null}">
                            <br/><br/>
                            <img src="${cp}/image/display?id=${aEmoji.imageId}" alt="${aEmoji.characterName}">
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>
        </form:form>

        <jsp:include page="../../emojistore/footer.jsp" />

    </div>
</div>
</body>
</html>