<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Khách hàng</title>
    <link rel="stylesheet" href="customer_mng.css">
</head>
<body>
    <div class="container">
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
                    <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
                </ul>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="customers" class="section active">
                <h1>Quản lý Khách hàng</h1>
                <!-- Công cụ tìm kiếm -->
                <div class="search-customer">
                    <form action="/customer_mng" method="get">
                        <input type="text" id="query_customers" name="query_customers" placeholder="Nhập tên hoặc email">
                        <button type="submit">Tìm kiếm</button>
                    </form>
                </div>
                <!-- Danh sách khách hàng -->
                <div class="customer-list">
                    <h2>Danh sách Khách hàng</h2>
                    <table id="customerTable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên khách hàng</th>
                                <th>Email</th>
                                <th>Số điện thoại</th>
                                <th>Điểm thành viên</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu khách hàng sẽ được hiển thị ở đây -->
                        </tbody>
                    </table>
                </div>

                <!-- Chính sách ưu đãi -->
                <div class="manage-discounts">
                    <h2>Chính sách Ưu đãi</h2>
                    <form id="discountForm">
                        <label for="discountName">Tên ưu đãi:</label>
                        <input type="text" id="discountName" required>

                        <label for="discountPercent">Phần trăm giảm giá:</label>
                        <input type="number" id="discountPercent" min="0" max="100" required>

                        <button type="button" onclick="addDiscount()">Thêm ưu đãi</button>
                    </form>

                    <h3>Danh sách Ưu đãi</h3>
                    <ul id="discountList">
                        <!-- Danh sách ưu đãi sẽ được hiển thị ở đây -->
                    </ul>
                </div>
            </div>
        </main>
    </div>

    <script src="customer_mng.js"></script>
</body>
</html>
