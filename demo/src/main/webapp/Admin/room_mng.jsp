<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Phòng Chiếu</title>
    <link rel="stylesheet" href="room_mng.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <h2>Admin Panel</h2>
            <nav>
                <ul>
                    <!-- <li><a href="#" data-section="dashboard">Dashboard</a></li>
                    <li><a href="#" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="#" data-section="schedule">Quản lý Lịch Chiếu</a></li>
                    <li><a href="#" data-section="rooms" class="active">Quản lý Phòng Chiếu</a></li> -->
                    <li><a href="dashboard.jsp" data-section="dashboard">Dashboard</a></li>
                    <li><a href="film_management.jsp" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="schedule_mng.jsp" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="room_mng.html" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                    <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="rooms" class="section active">
                <h1>Quản lý Phòng Chiếu</h1>

                <!-- Thêm phòng chiếu -->
                <div class="add-room">
                    <h2>Thêm Phòng Chiếu</h2>
                    <form id="roomForm">
                        <label for="roomName">Tên phòng:</label>
                        <input type="text" id="roomName" required>

                        <label for="seatCount">Số ghế:</label>
                        <input type="number" id="seatCount" min="1" required>

                        <button type="button" onclick="addRoom()">Thêm phòng</button>
                    </form>
                </div>

                <!-- Danh sách phòng chiếu -->
                <div class="room-list">
                    <h2>Danh sách Phòng Chiếu</h2>
                    <table id="roomTable">
                        <thead>
                            <tr>
                                <th>Tên phòng</th>
                                <th>Số ghế</th>
                                <th>Tình trạng</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu phòng chiếu sẽ được hiển thị ở đây -->
                        </tbody>
                    </table>
                </div>

                <!-- Sơ đồ chỗ ngồi -->
                <div class="seat-map">
                    <h2>Sơ đồ Chỗ Ngồi</h2>
                    <div id="seatMap">
                        <!-- Sơ đồ chỗ ngồi sẽ được cập nhật động -->
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script src="room_mng.js"></script>
</body>
</html>
