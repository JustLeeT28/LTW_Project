<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đồ ăn</title>
    <link rel="stylesheet" href="../Styles/order-food.css">
    <script src="../Script/order-food.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="left">
    <div class="food-item">
        <img src="../img/img/combo/1.jpg" alt=""/>
        <div class="col-2">
            <h3>Combo 1</h3>
            <p>1 bắp, 1 nước, 1 snack</p>
            <div class="price">100,000</div>
        </div>
        <div class="quantity" data-id="1">
            <a href="#" class="icon-minum">-</a>
            <span class="number">0</span>
            <a href="#" class="icon-plus">+</a>
        </div>

    </div>
    <div class="food-item">
        <img src="../img/img/combo/2.jpg" alt=""/>
        <div class="col-2">
            <h3>Combo 2</h3>
            <p>1 bắp 2 nước 1 snake</p>
            <div class="price">150,000</div>
        </div>
        <div class="quantity" data-id="1">
            <a href="#" class="icon-minum">-</a>
            <span class="number">0</span>
            <a href="#" class="icon-plus">+</a>
        </div>

    </div>
    <div class="food-item">
        <img src="../img/img/combo/3.jpg" alt=""/>
        <div class="col-2">
            <h3>Combo 3</h3>
            <p>1 bắp 1 nước</p>
            <div class="price">80,000</div>
        </div>
        <div class="quantity" data-id="1">
            <a href="#" class="icon-minum">-</a>
            <span class="number">0</span>
            <a href="#" class="icon-plus">+</a>
        </div>

    </div>
</div>
<div class="right">
    <div class="ticket-info">
        <div class="details">
            <h3>JAWAN</h3>
            <p>2D Phụ Đề - <span class="age-rating"> PG13</span></p>
        </div>
    </div>
    <div class="cinema-info">
        <p><strong>LTW CINEMA</strong> - RAP 3</p>
        <p>Suất: <span>19:05</span> - Thứ Tư, 20/11/2024</p>
    </div>
    <div class="seat-info">
        <p><strong>1 VÉ <span>55.000 VNĐ</span></strong></p>
        <p>Ghế: <span id="all-chairs-selected">NULL</span></p>
    </div>
    <div class="infor-comboFood">
        <h3>Đồ ăn thức uống</h3>
        <div class="order-summary"><p>Chưa có combo nào được chọn.</p></div>
    </div>
    <div class="total">
        <p>Tổng cộng: <span class="total cost">55.000 đ</span></p>
    </div>
    <div class="actions">
        <a href="book.jsp">
            <button class="btn-back">Quay lại</button>
        </a>
        <button class="btn-continue">Tiếp tục</button>
    </div>
</div>
</body>
</html>
