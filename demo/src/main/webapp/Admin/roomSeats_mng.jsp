<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Vé và Đặt Vé</title>
    <link rel="stylesheet" href="tikket_mng.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/tikket_mng.css">
</head>
<body>
<div class="container">
    <!-- Sidebar -->
    <aside class="sidebar">
        <h2>Admin Panel</h2>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/dashboard" data-section="dashboard">Dashboard</a></li>
                <li><a href="${pageContext.request.contextPath}/film_management" data-section="movies">Quản lý phim</a></li>
                <li><a href="${pageContext.request.contextPath}/schedule_mng" data-section="schedules">Quản lý lịch chiếu</a></li>
                <li><a href="${pageContext.request.contextPath}/room_mng" data-section="rooms">Quản lý phòng chiếu</a></li>
                <li><a href="${pageContext.request.contextPath}/tikket_mng" data-section="tickets">Quản lý vé</a></li>
                <li><a href="${pageContext.request.contextPath}/customer_mng" data-section="customers">Quản lý khách hàng</a></li>
                <li><a href="${pageContext.request.contextPath}/seats_mng" data-section="seats">Quản lý ghế</a></li>
                <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                <%--                <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>--%>
            </ul>
        </nav>
    </aside>

    <!-- Main content -->
    <main class="main-content">
        <div id="tickets" class="section active">
            <h1>Quản lý ghế</h1>
                        <!-- Công cụ tìm kiếm vé -->
            <div class="search-ticket" style="margin-bottom: 15px">
                <form action="${pageContext.request.contextPath}/seats_mng" method="GET">
                    <input type="text" id="query_tikkets" name="query_seats_room" placeholder="Tìm ghế theo định dạng <mã phòng>-<hàng>-<số ghế>">
                    <button type="submit">Tìm kiếm</button>
                </form>
            </div>
            <!-- Danh sách vé đã đặt -->
            <div class="ticket-list">
                <h2>Danh sách Vé Đã Đặt</h2>
                <table id="ticketTable">
                    <thead>
                    <tr>
                        <th>ID ghế</th>
                        <th>Mã phòng</th>
                        <th>Tên Hàng</th>
                        <th>Số ghế</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="seat" items="${listSeats}">
                        <tr>
                            <td>${seat.id}</td>
                            <td>${seat.roomId}</td>
                            <td>${seat.row}</td>
                            <td>${seat.seatNumber}</td>
                            <td>
                                <c:if test="${seat.isActive == 'active'}">
                                    <form id="block" class="form-block" action="${pageContext.request.contextPath}/seats_mng" method="POST">
                                        <input type="hidden" name="SeatId_status_block" value="${seat.id}" />
                                        <button type="submit" style="width: 100%;background-color: green;color: white;border: none;border-radius: 5px;cursor: pointer;transition: all 0.3s ease-in-out;" onmouseover="this.style.backgroundColor='#228b22'; this.style.color='#f0f0f0';"onmouseout="this.style.backgroundColor='green'; this.style.color='white';">
                                            Vô hiệu</button>
                                    </form>
                                </c:if>

                                <c:if test="${seat.isActive == 'inactive'}">
                                    <form id="unblock" class="form-unblock" action="${pageContext.request.contextPath}/seats_mng" method="POST">
                                        <input type="hidden" name="seatId_status_unblock" value="${seat.id}" />
                                        <button type="submit" style="width: 100%;background-color: green;color: white;border: none;border-radius: 5px;cursor: pointer;transition: all 0.3s ease-in-out;" onmouseover="this.style.backgroundColor='#228b22'; this.style.color='#f0f0f0';"onmouseout="this.style.backgroundColor='green'; this.style.color='white';">
                                            Bỏ chặn</button>
                                    </form>
                                </c:if>
<%--                                <form class="form-delete" action="${pageContext.request.contextPath}/tikket_mng" method="GET" onsubmit="return confirm('Bạn có chắc chắn muốn xóa người này?');">--%>
<%--                                    <input type="hidden" name="seatId_status" value="${seat.id}" />--%>
<%--                                    <button type="submit" style="width: 100%">--%>
<%--                                        Hủy</button>--%>
<%--                                </form>--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </main>
</div>

<%--<script src="tikket_mng.js"></script>--%>
</body>
</html>
