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
        <a href="../../index.jsp">
            <img id="logo-cinema" src="${pageContext.request.contextPath}/img/img/Logo_tachnen.jpg" alt="Cinema Logo"/>
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim">
        <a href="../Search.jsp" class="menu">Phim</a>
        <a href="../ticket-price.jsp" class="menu">Giá vé</a>
        <a href="../login.jsp" class="menu">Đăng nhập</a>
        <a href="../user-infor.jsp">
            <img src="../../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
</body>
</html>