<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Emoji List - Edit Emoji</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<jsp:include page="../../emojistore/header.jsp" />

<div id="container">

    <div id="content">
        <form:form action="${cp}/emoji/user/save" modelAttribute="emoji" enctype="multipart/form-data"
                   method="post"
                   nctype="multipart/form-data">
            <form:hidden path="id" value="${emoji.id}"/>
            <form:hidden path="imageId" value="${emoji.imageId}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="emote" itemValue="id" value=""/>
                        <form:errors path="emote" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Rating</label></td>
                    <td><form:input path="rating" value=""/>
                        <form:errors path="rating" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Character Details</label></td>
                    <td>
                        <form:input path="characterDetail.detail" value=""/>
                        <form:errors path="characterDetail" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Image</label></td>
                    <td>
                        <input type="file" name="imageFile">
                        <c:if test="${emoji.imageId != null}">
                            <br/><br/>
                            <img src="${cp}/image/display?id=${emoji.imageId}" alt="${emoji.imageId}">
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