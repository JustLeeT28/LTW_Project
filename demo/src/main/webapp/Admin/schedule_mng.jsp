<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Lịch Chiếu</title>
    <link rel="stylesheet" href="schedule_mng.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <h2>Admin Panel</h2>
            <nav>
                <ul>
                    <!-- <li><a href="#" data-section="dashboard">Dashboard</a></li>
                    <li><a href="#" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="#" data-section="schedule" class="active">Quản lý Lịch Chiếu</a></li> -->
                    <li><a href="dashboard.jsp" data-section="dashboard">Dashboard</a></li>
                    <li><a href="film_management.jsp" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="schedule_mng.html" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="room_mng.jsp" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                    <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="schedule" class="section active">
                <h1>Quản lý Lịch Chiếu</h1>

                <!-- Lên lịch chiếu -->
                <div class="add-schedule">
                    <h2>Lên lịch chiếu</h2>
                    <form id="scheduleForm">
                        <label for="movieSelect">Chọn phim:</label>
                        <select id="movieSelect">
                            <!-- Danh sách phim sẽ được thêm động -->
                        </select>

                        <label for="roomSelect">Phòng chiếu:</label>
                        <select id="roomSelect">
                            <option value="Room 1">Room 1</option>
                            <option value="Room 2">Room 2</option>
                            <option value="Room 3">Room 3</option>
                        </select>

                        <label for="showDate">Ngày chiếu:</label>
                        <input type="date" id="showDate" required>

                        <label for="showTime">Giờ chiếu:</label>
                        <input type="time" id="showTime" required>

                        <button type="button" onclick="addSchedule()">Thêm lịch chiếu</button>
                    </form>
                </div>

                <!-- Danh sách lịch chiếu -->
                <div class="schedule-list">
                    <h2>Danh sách Lịch Chiếu</h2>
                    <table id="scheduleTable">
                        <thead>
                            <tr>
                                <th>Phim</th>
                                <th>Phòng</th>
                                <th>Ngày</th>
                                <th>Giờ</th>
                                <th>Số lượng chỗ ngồi</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu lịch chiếu sẽ được hiển thị ở đây -->
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>

    <script src="schedule_mng.js"></script>
</body>
</html>
