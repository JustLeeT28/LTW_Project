<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/ticket-price.css">
    <link rel="stylesheet" href="../Styles/footer.css">
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
        <a href="ticket-price.html" class="menu">Giá vé</a>
        <a href="login.jsp" class="menu">Đăng nhập</a>
        <a href="user-infor.jsp">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="container">
    <div class="header">
        <h1>GIÁ VÉ</h1>
    </div>
    <div class="imgticket-content">
        <div class="left-img">
            <img src="../img/img/ticket_price2.jpg"/>
        </div>
        <div class="right-content">
            <div class="sub">Đồng giá 55k/vé!</div>
            <div class="text-content"><p class="">Đồng giá 55k cho mọi lứa tuổi </p></div>
            <div class="text-content"><p>Trương trình diễn ra từ 25/11/2024 đến hết ngày 5/5/2025</p></div>
            <div class="text-content"><p>Hãy nhanh chân đến cinema KATA để có được những phút giây thư giãn bên gia đình và bạn bè</p></div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="column-1">
        <div class="logo-footer">
            <img id="logo-cinema-footer" src="../img/img/Logo_tachnen.jpg"/>
            <a href="">Cinema</a>
        </div>

    </div>
    <div class="column-2">
        <div class="social-icons">
            <h2>follow us</h2>
            <li><a href=""><i class="fa-brands fa-facebook-f"></i> Facebook</a></li>
            <li><a href=""><i class="fa-brands fa-instagram"></i> Instagram</a></li>
            <li><a href=""><i class="fa-brands fa-tiktok"></i> TikTok</a></li>
        </div>
    </div>
    <div class="column-3">
        <div class="contact-address">
            <h2>Địa chỉ</h2>
            <li class="address1"><i class="fa-solid fa-location-dot"></i>Thủ Đức, TpHCM</li>
            <li><a href=""><i class="fa-solid fa-phone"></i>+84 12345678</a></li>
            <li><a href=""><i class="fa-solid fa-envelope"></i> 123@gmail.com</a></li>
        </div>
    </div>
</div>
</body>
</html>