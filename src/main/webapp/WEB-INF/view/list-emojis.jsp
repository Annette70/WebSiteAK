<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Donut Reviews</title>
    <link type="text/css" rel="stylesheet" href="${cp}/resources/css/style.css">
</head>
<body>

<jsp:include page="../../emojistore/header.jsp" />

<div id="container">

    <div id="content">

        <!-- add donut button -->
        <button class="add-button"
                onclick="window.location.href='${cp}/donut/user/showAddDonutForm'; return false;">Add Donut
        </button>

        <!-- search form -->
        <form:form action="search" method="GET">
            Search donuts <input type="search" name="searchTerm"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>

        <!-- donut list table -->

        <table>
            <tr>
                <th></th>
                <th>Emote</th>
                <th>Character Name</th>
                <th>Rating</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempEmoji" items="${emojis}">

                <c:url var="updateLink" value="/emoji/showUpdateEmojiForm">
                    <c:param name="emojiID" value="${tempEmoji.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/emoji/delete">
                    <c:param name="emojiID" value="${tempEmoji.id}"/>
                </c:url>

                <c:url var="imageLink" value="/image/display">
                    <c:param name="id" value="${tempEmoji.imageId}"/>
                </c:url>

                <tr>
                    <td>
                        <img src="${imageLink}" alt="${tempEmoji.name}">
                    </td>
                    <td>${tempEmoji.emote.name}</td>
                    <td>${tempEmoji.characterName}</td>
                    <td>${tempEmoji.rating}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        <a href="${deleteLink}"
                           onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../../emojistore/footer.jsp" />
</body>
</html>
