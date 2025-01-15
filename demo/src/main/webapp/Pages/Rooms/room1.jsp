<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/room1.css">
    <script src="${pageContext.request.contextPath}/Script/booked-chair.js"></script>
    <script> const basePath = "<%=request.getContextPath()%>";</script>

</head>
<body>
<div class="chair">
    <c:forEach var="row" items="${rowsInRoom}">
        <div class="row">
            <span>${row}</span>
            <c:forEach var="seat" items="${seatsInRoom}">
                <c:if test="${seat.row == row}">
                    <c:set var="statusClass" value=""/>
                    <c:forEach var="statusSeat" items="${statusSeats}">
                        <c:if test="${statusSeat.seatId == seat.id}">
                            <c:choose>
                                <c:when test="${statusSeat.status == 'seat'}">
                                    <c:set var="statusClass" value="seat"/>
                                </c:when>
                                <c:when test="${statusSeat.status == 'reserved'}">
                                    <c:set var="statusClass" value="reserved"/>
                                </c:when>
                                <c:when test="${statusSeat.status == 'booked'}">
                                    <c:set var="statusClass" value="booked"/>
                                </c:when>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <li class="${statusClass}"
                        data-row="${seat.row}"
                        data-seat="${seat.seatNumber}">
                            ${seat.seatNumber}
                    </li>
                </c:if>
            </c:forEach>
            <span>${row}</span>
        </div>
    </c:forEach>
</div>
<div class="details" id="det">
    <div class="details_chair">
        <li>Available</li>
        <li>Booked</li>
        <li>Selected</li>
    </div>
</div>
<div class="book_movie">
    <div class="lef_book">
        <p class="text_total_pay">Các ghế đã chọn: </p>
        <div id="seats-select"></div>
    </div>
    <div class="lef_book">
        <p class="text_total_pay">Tổng thanh toán: </p>
        <div id="total_need_pay">0 VNĐ</div>
    </div>
    <div class="btn-book">Đặt vé</div>
</div>
</body>
</html>
