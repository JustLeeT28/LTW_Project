<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="../Styles/left-menu.css">
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/user-infor.css">
    <script src="../Script/user-infor.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<div class="nav-menu">
    <div class="lelf-menu">
        <a href="../index.jsp">
            <img id="logo-cinema" src="../img/img/Logo_tachnen.jpg" alt="Cinema Logo" />
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim" onkeypress="redirectToPage(event)" >
        <a href="Search.jsp" class="menu">Phim</a>
        <a href="ticket-price.jsp" class="menu">Giá vé</a>
        <a href="login.jsp" class="menu">Đăng nhập</a>
        <a href="user-infor.html">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="leftmenu">
    <a href="user-infor.html" class="op-infor open" >Thông tin </a>
    <a href="user-updateInfor.jsp" class="op-update ">Chỉnh sửa</a>
    <a href="history.jsp" class="op-history">Lịch sử</a>
    <a href="" id="out">Đăng suất</a>
</div>
<div class="right_infor">
    <h1><strong>THÔNG TIN CÁ NHÂN</strong></h1>
    <div class="infor-content">
        <div class="row-infor">
            <span class="highlight">Họ tên: </span> <span class="in4" id="name">Nguyễn Văn A</span>
        </div>
        <div class="row-infor">
            <span class="highlight">Sinh nhật: </span> <span class="in4" id="birthday">12/04/2000</span>
        </div>
        <div class="row-infor">
            <span class="highlight">Email: </span> <span class="in4" id="email">nguyenvana@gmail.com</span>
        </div>
        <div class="row-infor">
            <span class="highlight">SĐT: </span> <span class="in4" id="numPhone">0909123456</span>
        </div>
    </div>
</div>
</body>
</html>