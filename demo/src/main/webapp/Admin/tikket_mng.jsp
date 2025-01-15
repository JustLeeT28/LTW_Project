<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Vé và Đặt Vé</title>
    <link rel="stylesheet" href="tikket_mng.css">
</head>
<body>
<div class="container">
    <!-- Sidebar -->
    <aside class="sidebar">
        <h2>Admin Panel</h2>
        <nav>
            <ul>
                <li><a href="dashboard.jsp" data-section="dashboard">Dashboard</a></li>
                <li><a href="film_management.jsp" data-section="movies">Quản lý Phim</a></li>
                <li><a href="schedule_mng.jsp" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                <li><a href="room_mng.jsp" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                <li><a href="reports_mng.jsp" data-section="reports">Báo cáo và Thống kê</a></li>
            </ul>
        </nav>
    </aside>

    <!-- Main content -->
    <main class="main-content">
        <div id="tickets" class="section active">
            <h1>Quản lý Vé và Đặt Vé</h1>

            <!-- Công cụ tìm kiếm vé -->
            <div class="search-ticket" style="margin-bottom: 15px">
                <form action="${pageContext.request.contextPath}/customer_mng" method="GET">
                    <input type="text" id="query_tikkets" name="query_tikkets" placeholder="Nhập tên khác hàng hoặc mã vé ">
                    <button type="submit">Tìm kiếm</button>
                </form>
            </div>
            <!-- Danh sách vé đã đặt -->
            <div class="ticket-list">
                <h2>Danh sách Vé Đã Đặt</h2>
                <table id="ticketTable">
                    <thead>
                    <tr>
                        <th>Mã vé</th>
                        <th>Tên khách hàng</th>
                        <th>Suất chiếu</th>
                        <th>Số ghế</th>
                        <th>Giá</th>
                        <th>Ngày đặt</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr>
                            <td>${ticket.id}</td>
                            <td>${ticket.customerName}</td>
                            <td>${ticket.showtime}</td>
                            <td>${ticket.seat}</td>
                            <td>${ticket.price}</td>
                            <td>${ticket.createdAt}</td>
                            <td>
                                <button onclick="deleteTicket(${ticket.id})">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>



            <!-- Quản lý giá vé -->
            <div class="manage-price">
                <h2>Quản lý Giá Vé</h2>
                <form id="priceForm">
                    <label for="regularPrice">Giá vé thường:</label>
                    <input type="number" id="regularPrice" value="50000" min="0" required>

                    <label for="vipPrice">Giá vé VIP:</label>
                    <input type="number" id="vipPrice" value="100000" min="0" required>

                    <label for="specialPrice">Giá vé đặc biệt:</label>
                    <input type="number" id="specialPrice" value="150000" min="0" required>

                    <button type="button" onclick="updatePrices()">Cập nhật giá</button>
                </form>
            </div>
        </div>
    </main>
</div>

<script src="tikket_mng.js"></script>
</body>
</html>
