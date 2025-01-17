<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đồ ăn</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/order-food.css">
    <script src="../Script/order-food.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="${pageContext.request.contextPath}/Script/food.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="left">
    <c:forEach var="ticket" items="${tickets}">
        ${ticket.getSeatId()}
    </c:forEach>
    <c:forEach var="foodCombo" items="${foodCombos}">
        <div class="food-item">
            <div class="col-2">
                <h3>${foodCombo.getName()}</h3>
                <p>${foodCombo.getDescription()}</p>
                <div class="price">${foodCombo.getPrice()}</div>
            </div>
            <div class="quantity" data-id="${foodCombo.getId()}" data-name="${foodCombo.getName()}">
                <a href="#" class="icon-minus">-</a>
                <span class="number">0</span>
                <a href="#" class="icon-plus">+</a>
                <input type="hidden" name="foodCombo_${foodCombo.getId()}" value="0">
                <input type="hidden" name="movieId" id="movieId" value="${param.mId}">
                <input type="hidden" name="roomId" id="roomId" value="${param.roomId}">

            </div>
        </div>
    </c:forEach>
</div>
<div class="right">
    <div class="ticket-info">
        <div class="details">
            <h3>${movie.title}</h3>
            <p>2D - <span class="age-rating"> ${movie.ageRating}</span></p>
        </div>
    </div>
    <div class="cinema-info">
        <p><strong>LTW CINEMA</strong> - RAP ${roomId}</p>
        <p>Suất: <span>${showtime.showTime}</span> - ${showtime.getDayOfWeek()}, ${showtime.showDate}</p>
    </div>
    <div class="seat-info">
        <p id="totalSeatsPrice" data-totalPrice = "${totalPrice}"><strong>${count} VÉ <span>${totalPrice}</span></strong></p>
        <p>Ghế: <span id="all-chairs-selected"><c:forEach var="seat" items="${seats}"> ${seat.seatNumber}${seat.row} </c:forEach></span></p>
    </div>
    <div class="infor-comboFood">
        <h3>Đồ ăn thức uống</h3>
        <div class="order-summary"><p>Chưa có combo nào được chọn.</p></div>
    </div>
    <div class="total">
        <p>Tổng cộng: <span class="total cost">${totalPrice} đ</span></p>
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
