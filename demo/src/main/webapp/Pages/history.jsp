<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lịch sử</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/history.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/left-menu.css">
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="leftmenu" style="height: 1200px; padding-top: 4%">
    <a href="user-infor.jsp" class="op-infor">Thông tin</a>
    <a href="user-updateinfor.jsp" class="op-update">Chỉnh sửa</a>
    <a href="history.jsp" class="op-history open">Lịch sử</a>
    <a href="${pageContext.request.contextPath}/userChangePass">Đổi mật khẩu</a>
    <a href="${pageContext.request.contextPath}/LogoutController" id="out">Đăng xuất</a>
</div>
<div class="history">
    <div class="title">
        <h1>LỊCH SỬ ĐẶT VÉ</h1>
    </div>

    <!-- Lịch sử vé phim -->
    <div class="t1">
        <h2>VÉ PHIM</h2>
    </div>
<%--    <div class="ticket">--%>
<%--        <c:forEach var="ticket" items="${tickets}">--%>
<%--            <div class="tic">--%>
<%--                <div class="detail">--%>
<%--                    <div class="card">--%>
<%--                        <h6>HÀNG ${seat.row}</h6>--%>
<%--                        <h6>${showtime.date} ${showtime.time}</h6>--%>
<%--                    </div>--%>
<%--                    <div class="card">--%>
<%--                        <h6>Ghế ${seat.seatNumber}</h6>--%>
<%--                        <h6>Phòng ${seat.roomId}</h6>--%>
<%--                    </div>--%>
<%--                    <svg id="barcode${ticket.id}"></svg>--%>
<%--                </div>--%>
<%--                <div class="ticket-detail">--%>
<%--                    <div class="type">2D</div>--%>
<%--                    <h5 class="pvr">LTW <span>CINEMA</span></h5>--%>
<%--                    <h1>${movie.title}</h1>--%>
<%--                    <div class="seat-detail">--%>
<%--                        <div class="seat-cr">--%>
<%--                            <h6>PHÒNG</h6>--%>
<%--                            <h6>${seat.roomId}</h6>--%>
<%--                        </div>--%>
<%--                        <div class="seat-cr">--%>
<%--                            <h6>HÀNG</h6>--%>
<%--                            <h6>${seat.row}</h6>--%>
<%--                        </div>--%>
<%--                        <div class="seat-cr">--%>
<%--                            <h6>GHẾ</h6>--%>
<%--                            <h6>${seat.seatNumber}</h6>--%>
<%--                        </div>--%>
<%--                        <div class="seat-cr">--%>
<%--                            <h6>NGÀY</h6>--%>
<%--                            <h6>${showtime.date}</h6>--%>
<%--                        </div>--%>
<%--                        <div class="seat-cr">--%>
<%--                            <h6>THỜI GIAN</h6>--%>
<%--                            <h6>${showtime.time}</h6>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>

<%--    <!-- Lịch sử vé đồ ăn -->--%>
<%--    <div class="t1">--%>
<%--        <h2>VÉ ĐỒ ĂN</h2>--%>
<%--    </div>--%>
<%--    <div class="ticket-food">--%>
<%--        <div class="tic">--%>
<%--            <div class="detail">--%>
<%--                <div class="card">--%>
<%--                    <c:forEach var="foodItem" items="${foodTicketItem}">--%>
<%--                        <h6>${foodItem.comboName}: ${foodItem.quantity}</h6>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="ticket-img">--%>
<%--                <img src="${pageContext.request.contextPath}/img/img/food.jpg" height="294" width="736"/>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
    <div class="table">
    <table>
        <thead>
        <tr>
            <th>Tên phim</th>
            <th>Vị trí ghế</th>
            <th>Thời gian chiếu</th>
            <th>Giá vé</th>
        </tr>
        </thead>
        <tbody>
<%--        <tr>--%>
<%--            <td>{ticket.movieTitle}</td>--%>
<%--            <td>{ticket.seatPosition}</td>--%>
<%--            <td>{ticket.showtime}</td>--%>
<%--            <td>{ticket.price}</td>--%>
<%--        </tr>--%>
        <c:if test="${empty listTicket}">
            <p>không có</p>
        </c:if>
        <c:forEach var="ticket" items="${listTicket}">
            <tr>
                <td>${ticket.titleMovie}</td>
                <td>${ticket.roomId}-${ticket.seatRow}-${ticket.seatNum}</td>
                <td>${ticket.getFormattedShowtime()}</td>
                <td>${ticket.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>


<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jsbarcode/3.11.6/JsBarcode.all.min.js"--%>
<%--        integrity="sha512-wkHtSbhQMx77jh9oKL0AlLBd15fOMoJUowEpAzmSG5q5Pg9oF+XoMLCitFmi7AOhIVhR6T6BsaHJr6ChuXaM/Q=="--%>
<%--        crossorigin="anonymous" referrerpolicy="no-referrer"></script>--%>
<%--<script>--%>
<%--    // Render barcode for each ticket--%>
<%--    <c:forEach var="ticket" items="${tickets}">--%>
<%--    JsBarcode("#barcode${ticket.id}", "${ticket.barcodeValue}");--%>
<%--    </c:forEach>--%>
<%--</script>--%>
</body>
</html>
