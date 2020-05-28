<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Emoji</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<jsp:include page="../../emojistore/header.jsp"/>

<div id="container">

    <div id="content">

        <security:authorize access="hasRole('USER')">
            <button class="add-button"
                    onclick="window.location.href='${cp}/emoji/user/showAddEmojiForm'; return false;">Add Emoji
            </button>
        </security:authorize>

        <form:form action="search" method="GET">
            <label>Search emojis <input type="search" name="searchTerm"/></label>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <table>
            <tr>
                <th></th>
                <th>Emote</th>
                <th>Character Name</th>
                <th>Rating</th>
                <security:authorize access="hasAnyRole('USER,ADMIN')">
                    <th>Action</th>
                </security:authorize>
            </tr>
            <c:forEach var="tempEmoji" items="${emojis}">

                <c:url var="updateLink" value="/emoji/showUpdateEmojiForm">
                    <c:param name="emojiID" value="${tempEmoji.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/emoji/delete">
                    <c:param name="emojiID" value="${tempEmoji.imageId}"/>
                </c:url>

                <c:url var="imageLink" value="/image/display">
                    <c:param name="id" value="${tempEmoji.imageId}"/>
                </c:url>

                <tr>
                    <td>
                        <img src="${imageLink}" alt="${tempEmoji.emote}">
                    </td>
                    <td>${tempEmoji.emote}</td>
                    <td>${tempEmoji.characterDetail.name}</td>
                    <td>${tempEmoji.rating.rating}</td>
                    <security:authorize access="hasAnyRole('USER,ADMIN')">
                    <td>
                        <a href="${updateLink}">Update</a>
                        <security:authorize access="hasRole('ADMIN')">
                        <a href="${deleteLink}"
                           onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                        </security:authorize>
                    </td>
                    </security:authorize>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../../emojistore/footer.jsp"/>
</body>
</html>
