<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <title>Title</title>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/room1.css">
    <script src="${pageContext.request.contextPath}/Script/booked-chair.js"></script>
    <script> const basePath = "<%=request.getContextPath()%>";</script>

</head>
<body>
<div class="chair">
<%--    <p>tesst ne</p>--%>
<%--    <c:forEach var="test" items="${showSeats}">--%>
<%--        <c:if test="${empty test.id}">--%>
<%--            <p>k</p>--%>
<%--        </c:if>--%>
<%--        <p>${test.id}</p>--%>
<%--    </c:forEach>--%>
    <c:forEach var="row" items="${rowsInRoom}">
        <div class="row">
            <span>${row}</span>
            <c:forEach var="seat" items="${seatsInRoom}">
                <c:if test="${seat.row == row}">
<%--                      <p>1${seat.row}-${row}</p>--%>
                    <c:forEach var="statusSeat" items="${showSeats}">
<%--                        <p>${show_seat.id}-ne</p>--%>
                        <c:if test="${statusSeat.seatId == seat.id}">
<%--                            <p>3${seat.row}-${row}</p>--%>
                            <li class="${statusSeat.status}"
                                data-status="seat"
                                data-row="${seat.row}"
                                data-seat="${seat.seatNumber}"
                                data-seatId="${seat.id}"
                                id="seatPrice" data-seatPrice="${seat.price}">
                                    ${seat.seatNumber}
                            </li>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${seat.row != null && row != null && seat.row.trim().toUpperCase().equals(row.trim().toUpperCase())}">
                    <c:set var="statusClass" value=""/>
                    <c:forEach var="statusSeat" items="${statusSeats}">
                        <c:if test="${statusSeat.seatId == seat.id}">
                            <li class="${statusSeat.status}"
                                data-status="seat"
                                data-row="${seat.row}"
                                data-seat="${seat.seatNumber}"
                                data-seatId="${seat.id}"
                                id="seatPrice" data-seatPrice="${seat.price}">
                                    ${seat.seatNumber}
                            </li>
                        </c:if>
                    </c:forEach>
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
    <form id="booking-form" method="post" action="${pageContext.request.contextPath}/orderFood">
        <!-- Các trường ẩn -->
        <input type="hidden" name="movieId" id="movieId" value="${param.mId}">
        <input type="hidden" name="showtimeId" id="showtimeId" value="${param.showtimeId}">
        <input type="hidden" name="roomID" id="roomId" value="${param.roomId}">
        <input type="hidden" name="day" id="day" value="${param.day}">
        <input type="hidden" name="selectedSeats" id="selectedSeats">
        <input type="hidden" name="seatsId" id="seatsId">
        <div class="btn-book" type="submit">Đặt vé</div>
    </form>
</div>
</body>
</html>
