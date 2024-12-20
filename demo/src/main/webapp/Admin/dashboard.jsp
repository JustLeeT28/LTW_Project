<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Trang Chủ</title>
    <link rel="stylesheet" href="dashboard.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- Thêm Chart.js -->
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <h2>Admin Panel</h2>
            <nav>
                <ul>
                    <li><a href="dashboard.html" data-section="dashboard">Dashboard</a></li>
                    <li><a href="film_management.jsp" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="schedule_mng.jsp" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="room_mng.jsp" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                    <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="dashboard" class="section active">
                <h1>Dashboard</h1>
                
                <div class="overview">
                    <div class="card">
                        <h3>Số lượng vé đã bán</h3>
                        <p id="ticketsSold">350 vé</p>
                    </div>
                    <div class="card">
                        <h3>Doanh thu</h3>
                        <p id="revenue">200,000,000 VND</p>
                    </div>
                    <div class="card">
                        <h3>Số lượng người xem</h3>
                        <p id="viewers">500 người</p>
                    </div>
                    <div class="card">
                        <h3>Tình trạng chỗ ngồi</h3>
                        <p id="seatStatus">75% đã được đặt</p>
                    </div>
                </div>

                <!-- Biểu đồ doanh thu -->
                <div class="chart-container">
                    <h2>Thống kê Doanh thu</h2>
                    <canvas id="revenueChart"></canvas>
                </div>

                <!-- Thông báo -->
                <div class="notifications">
                    <h2>Thông báo</h2>
                    <ul id="notificationList">
                        <li>Số lượng vé còn ít cho suất chiếu 19:00 hôm nay</li>
                        <li>Cập nhật: Phim mới được thêm vào lịch chiếu</li>
                        <li>Cảnh báo: Lỗi kết nối hệ thống lúc 10:30 sáng</li>
                    </ul>
                </div>
            </div>
        </main>
    </div>

    <script src="dashboard.js"></script>
</body>
</html>
