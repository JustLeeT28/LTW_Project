<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin cá nhân</title>
    <link rel="stylesheet" href="../Styles/left-menu.css">
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/user-updateInfor.css">
    <script src="../Script/user-update.js"></script>
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
        <a href="user-infor.jsp">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="leftmenu">
    <a href="user-infor.jsp" class="op-infor">Thông tin</a>
    <a href="user-updateInfor.html" class="op-update open">Chỉnh sửa</a>
    <a href="history.jsp" class="op-history">Lịch sử</a>
    <a href="" id="out">Đăng suất</a>
</div>
<div class="right_infor">
    <h1><strong>CHỈNH SỬA THÔNG TIN CÁ NHÂN</strong></h1>
    <div class="infor-content">
        <div>
            <label class="highlight">Họ tên: </label> <input class="in4" id="name" type="text" placeholder="Họ tên">
        </div>
        <div>
            <span class="highlight">Sinh nhật: </span> <input class="in4" id="birthday" type="date"
                                                              placeholder="dd/mm/yyyy">
        </div>
        <div>
            <span class="highlight">Email: </span> <input class="in4" id="email" type="email"
                                                          placeholder="...@gmail.com">
        </div>
        <div>
            <span class="highlight">SĐT: </span> <input class="in4" id="numPhone" placeholder="Số điện thoại">
        </div>
        <div class="buttons">
            <div>
                <button id="clearData" class="btn">Xóa Dữ Liệu</button>
            </div>
            <div>
                <button id="saveData" class="btn">Lưu Dữ Liệu</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>