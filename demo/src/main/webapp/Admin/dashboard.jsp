<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Trang Chủ</title>
    <link rel="stylesheet" href="dashboard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/dashboard.css">

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- Thêm Chart.js -->
    <style>
        .overview {
            display: flex;
            flex-direction: column; /* Chuyển các phần tử con xếp theo cột */
            gap: 20px; /* Khoảng cách giữa các thẻ con */
            width: 90%; /* Chiều rộng bao quanh */
            max-width: 600px; /* Giới hạn chiều rộng tối đa */
        }

        .overview .card {
            padding: 15px;
            width: 900px;
        }
    </style>

</head>
<body>
    <div class="container">
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

        <main class="main-content">
            <div id="dashboard" class="section active">
                <h1>Dashboard</h1>
                <div class="statistics" style="margin-bottom: 15px;display: flex; gap: 15px;">
                    <p>Thống kê theo: </p>
                <form id="statisticsForm" method="get" action="${pageContext.request.contextPath}/dashboard">
                    <select class="combobox" name="date" id="date" onchange="document.getElementById('statisticsForm').submit();">
                        <option value="week" ${'week' == date ? 'selected' : ''}>1 tuần</option>
                        <option value="month" ${'month' == date ? 'selected' : ''}>1 tháng</option>
                        <option value="year" ${'year' == date ? 'selected' : ''}>1 năm</option>
                    </select>
                </form>
                </div>
                <div class="overview">
                    <div class="card">
                        <h3>Số lượng vé phim đã bán</h3>
                        <p id="ticketsSold">${ticket_movies} vé</p>
                    </div>
                    <div class="card">
                        <h3>Tổng doanh thu</h3>
                        <p id="revenue">${total_revenue} VNĐ</p>
                    </div>
                    <div class="card">
                        <h3>Doanh thu bán vé</h3>
                        <p id="movie-tick">${totalMovie} VNĐ</p>
                    </div>
                    <div class="card">
                        <h3>Doanh thu bán đồ ăn</h3>
                        <p id="seatStatus">${totalFood} VNĐ</p>
                    </div>
                </div>

<%--                <!-- Biểu đồ doanh thu -->--%>
<%--                <div class="chart-container">--%>
<%--                    <h2>Thống kê Doanh thu</h2>--%>
<%--                    <canvas id="revenueChart"></canvas>--%>
<%--                </div>--%>

                <!-- Thông báo -->
<%--                <div class="notifications">--%>
<%--                    <h2>Thông báo</h2>--%>
<%--                    <ul id="notificationList">--%>
<%--                        <li>Số lượng vé còn ít cho suất chiếu 19:00 hôm nay</li>--%>
<%--                        <li>Cập nhật: Phim mới được thêm vào lịch chiếu</li>--%>
<%--                        <li>Cảnh báo: Lỗi kết nối hệ thống lúc 10:30 sáng</li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
            </div>
        </main>
    </div>

    <script src="${pageContext.request.contextPath}/Admin/dashboard.js"></script>
</body>
</html>
