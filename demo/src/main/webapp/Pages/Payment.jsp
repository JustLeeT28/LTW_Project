<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/pay_page.css">
    <script src="../Script/Payment.js"></script>
    <script src="../Script/confirm-payment.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="container-payment">
    <div class="pay">
        <p>TRANG THANH TOÁN
            ${user.id}
        </p>
    </div>
    <div class="payment">
        <div class="QR-lefl">
            <h3>Thanh toán bằng QR</h3>
            <img src="${pageContext.request.contextPath}/img/img/QR_thanhtoan.jpg"/>
            <h2 class="cost">${totalPrice} VNĐ</h2>
        </div>
        <div class="infor-movie-right">
            <div class="name-movie">
                <p class="highlight">${movie}</p>

            </div>
            <p class="highlight">Kata cinema Bình Dương </p>
            <p> 138 Lý Thường Kiệt, Dĩ An,Bình Dương</p>
            <p class="highlight">Thời gian</p>
            <p> ${showtime.showDate} ${showtime.showTime}</p>
            <div class="seat">
                <div>
                    <span class="highlight">Phòng: </span> <span id="room">${roomId}</span>
                </div>
                <div>
                    <span class="highlight">Ghế: </span> <span id="chairs">
                    <c:forEach var="seat" items="${seats}">
                        ${seat.seatNumber}${seat.row}
                    </c:forEach></span>
                </div>
            </div>
            <div class="food">
                <span class="highlight">Bắp nước: </span>
                <span id="combo-food">
                    <c:forEach var="foodTicketItem" items="${foodTicketItems}">
                        Combo ${foodTicketItem.comboId} - Số lượng: ${foodTicketItem.quantity}
                    </c:forEach>
                </span>
            </div>
            <div class="total-cost">
                <span class="highlight payment-text">Số tiền thanh toán</span>
                <span class="cost">${totalPrice} VNĐ</span>
            </div>
        </div>
    </div>
    <div class="actions">
        <a href="order-food.jsp">
            <button class="btn-back">Quay lại</button>
        </a>
        <form action="${pageContext.request.contextPath}/payment" method="get">
            <button type="submit" class="btn-pay">Thanh toán</button>
        </form>
    </div>

</div>
</body>
</html>