<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Báo cáo và Thống kê</title>
    <link rel="stylesheet" href="reports_mng.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <h2>Admin Panel</h2>
            <nav>
                <ul>
                    <!-- <li><a href="#">Dashboard</a></li>
                    <li><a href="#">Quản lý Phim</a></li>
                    <li><a href="#">Quản lý Lịch Chiếu</a></li>
                    <li><a href="#">Quản lý Phòng Chiếu</a></li>
                    <li><a href="#">Quản lý Vé</a></li>
                    <li><a href="#">Quản lý Khách hàng</a></li>
                    <li><a href="#">Quản lý Khuyến mãi</a></li>
                    <li><a href="#">Quản lý Nhân viên</a></li>
                    <li><a href="#" class="active">Báo cáo và Thống kê</a></li> -->
                    <li><a href="dashboard.jsp" data-section="dashboard">Dashboard</a></li>
                    <li><a href="film_management.jsp" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="schedule_mng.jsp" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="room_mng.jsp" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                    <li><a href="reports_mng.html" data-section="settings">Báo cáo và Thống kê</a></li>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="reports" class="section active">
                <h1>Báo cáo và Thống kê</h1>

                <!-- Thống kê doanh thu -->
                <div class="revenue-statistics">
                    <h2>Thống kê Doanh thu</h2>
                    <select id="revenuePeriod" onchange="generateRevenueReport()">
                        <option value="daily">Theo ngày</option>
                        <option value="weekly">Theo tuần</option>
                        <option value="monthly">Theo tháng</option>
                        <option value="yearly">Theo năm</option>
                    </select>
                    <div id="revenueChart" class="chart">Biểu đồ doanh thu sẽ hiển thị ở đây</div>
                </div>

                <!-- Thống kê khách hàng -->
                <div class="customer-statistics">
                    <h2>Thống kê Khách hàng</h2>
                    <div id="customerData">
                        <p>Số lượng khách hàng mới: <span id="newCustomers">0</span></p>
                        <p>Khách hàng thân thiết: <span id="loyalCustomers">0</span></p>
                        <p>Xu hướng đặt vé: <span id="bookingTrend">Đang cập nhật</span></p>
                    </div>
                </div>

                <!-- Báo cáo tổng hợp -->
                <div class="summary-report">
                    <h2>Báo cáo Tổng hợp</h2>
                    <div id="moviePerformance" class="chart">Hiệu quả phim sẽ hiển thị ở đây</div>
                    <div id="seatOccupancy">Tỷ lệ ghế đã đặt: <span id="seatOccupancyRate">0%</span></div>
                </div>
            </div>
        </main>
    </div>

    <script src="reports_mng.js"></script>
</body>
</html>
