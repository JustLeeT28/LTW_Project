<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
</head>
<body>
<div class="nav-menu">
    <div class="lelf-menu">
        <a href="${pageContext.request.contextPath}">
            <img id="logo-cinema" src="${pageContext.request.contextPath}/img/img/Logo_tachnen.jpg" alt="Cinema Logo"/>
        </a>
    </div>
    <div class="right-menu">
        <form id="seachForm" method="get" action="${pageContext.request.contextPath}/search">
            <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim">
        </form>
        <a href="${pageContext.request.contextPath}/search" class="menu">Phim</a>
        <a href="../ticket-price.jsp" class="menu">Giá vé</a>
        <% if (session.getAttribute("user") != null) { %>
        <a href="${pageContext.request.contextPath}/Pages/user-infor.jsp">
            <img src="${pageContext.request.contextPath}/img/img/user.jpg" height="30" width="30"/>
        </a>
        <% } else { %>
            <a href="${pageContext.request.contextPath}/Pages/login.jsp" class="menu">Đăng nhập</a>
        <% } %>

<%--        <c:if test=="${empty sessionScope.isLogin }">--%>
<%--            <a href="${pageContext.request.contextPath}/Pages/login.jsp" class="menu">Đăng nhập</a>--%>
<%--        </c:if>--%>
<%--        ${sessionScope.user.getName()}--%>
<%--        ${sessionScope.user.name}--%>

<%--        <a href="../user-infor.jsp">--%>
<%--            <img src="${pageContext.request.contextPath}/img/img/user.jpg" height="30" width="30"/>--%>
<%--        </a>--%>
    </div>
</div>
</body>
</html>