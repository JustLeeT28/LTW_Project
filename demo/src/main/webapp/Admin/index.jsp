<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Quản Lý Đặt Vé Xem Phim</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <h2>Admin Panel</h2>
            <nav>
                <ul>
                    <li><a href="#" data-section="dashboard">Dashboard</a></li>
                    <li><a href="#" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="#" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="#" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="#" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="#" data-section="customers">Quản lý Khách hàng</a></li>
                    <li><a href="#" data-section="staff">Quản lý Nhân viên</a></li>
                    <li><a href="#" data-section="settings">Cấu hình hệ thống</a></li>
                </ul>
            </nav>
        </aside>

        <!-- Main Content -->
        <main class="main-content">
            <div id="dashboard" class="section">
                <h1>Dashboard</h1>
                <p>Tổng quan về doanh thu và số lượng vé.</p>
                <!-- Biểu đồ và thông tin doanh thu -->
            </div>
            
            <div id="movies" class="section" style="display: none;">
                <h1>Quản lý Phim</h1>
                <p>Thêm, chỉnh sửa, và quản lý các phim đang chiếu.</p>
                <!-- Form quản lý phim -->
            </div>

            <div id="schedules" class="section" style="display: none;">
                <h1>Quản lý Lịch Chiếu</h1>
                <p>Lên lịch chiếu phim, sắp xếp thời gian chiếu.</p>
                <!-- Form lên lịch chiếu -->
            </div>

            <div id="rooms" class="section" style="display: none;">
                <h1>Quản lý Phòng Chiếu</h1>
                <p>Quản lý các phòng chiếu và sơ đồ chỗ ngồi.</p>
                <!-- Form quản lý phòng chiếu -->
            </div>

            <div id="tickets" class="section" style="display: none;">
                <h1>Quản lý Vé</h1>
                <p>Danh sách vé đã đặt và công cụ tìm kiếm vé.</p>
                <!-- Form quản lý vé -->
            </div>

            <div id="customers" class="section" style="display: none;">
                <h1>Quản lý Khách hàng</h1>
                <p>Danh sách khách hàng và lịch sử đặt vé.</p>
                <!-- Form quản lý khách hàng -->
            </div>

            <div id="promotions" class="section" style="display: none;">
                <h1>Quản lý Khuyến mãi</h1>
                <p>Tạo và quản lý các chương trình khuyến mãi.</p>
                <!-- Form quản lý khuyến mãi -->
            </div>

            <div id="staff" class="section" style="display: none;">
                <h1>Quản lý Nhân viên</h1>
                <p>Danh sách nhân viên và phân quyền.</p>
                <!-- Form quản lý nhân viên -->
            </div>

            <div id="settings" class="section" style="display: none;">
                <h1>Cấu hình hệ thống</h1>
                <p>Cài đặt thông tin hệ thống và các phương thức thanh toán.</p>
                <!-- Form cài đặt hệ thống -->
            </div>
        </main>
    </div>

    <script src="script.js"></script>
</body>
</html>
