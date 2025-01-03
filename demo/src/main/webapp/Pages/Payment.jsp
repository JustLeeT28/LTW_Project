<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/pay_page.css">
    <script src="../Script/Payment.js"></script>
    <script src="../Script/confirm-payment.js"></script>
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
<div class="container-payment">
    <div class="pay">
        <p>TRANG THANH TOÁN</p>
    </div>
    <div class="payment">
        <div class="QR-lefl">
            <h3>Thanh toán bằng QR</h3>
            <img src="../img/img/QR_thanhtoan.jpg"/>
            <h2 class="cost">0 VNĐ</h2>
        </div>
        <div class="infor-movie-right">
            <div class="name-movie">
                <p class="highlight">Jawan (T13)</p>

            </div>
            <p class="highlight">Kata cinema Bình Dương </p>
            <p> 138 Lý Thường Kiệt, Dĩ An,Bình Dương</p>
            <p class="highlight">Thời gian</p>
            <p>16:30 Thứ Ba 08/072024</p>
            <div class="seat">
                <div>
                    <span class="highlight">Phòng: </span> <span id="room">02</span>
                </div>
                <div>
                    <span class="highlight">Ghế: </span> <span id="chairs">Null</span>
                </div>
            </div>
            <div class="food">
                <span class="highlight">Bắp nước: </span>
                <span id="combo-food">Không</span>
            </div>
            <div class="total-cost">
                <span class="highlight payment-text">Số tiền thanh toán</span>
                <span class="cost">0 VNĐ</span>
            </div>
        </div>
    </div>
    <div class="actions">
        <a href="order-food.jsp">
        <button class="btn-back">Quay lại</button>
        </a>
        <button class="btn-pay">Thanh toán</button>
    </div>

</div>
</body>
</html>