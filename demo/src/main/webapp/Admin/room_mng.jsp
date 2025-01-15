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
                    <li><a href="${pageContext.request.contextPath}/dashboard" data-section="dashboard">Dashboard</a></li>
                    <li><a href="${pageContext.request.contextPath}/film_management" data-section="movies">Quản lý Phim</a></li>
                    <li><a href="${pageContext.request.contextPath}/schedule_mng" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                    <li><a href="${pageContext.request.contextPath}/room_mng" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                    <li><a href="${pageContext.request.contextPath}/tikket_mng" data-section="tickets">Quản lý Vé</a></li>
                    <li><a href="${pageContext.request.contextPath}/customer_mng" data-section="customers">Quản lý Khách hàng</a></li>
                    <%--                <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>--%>
                </ul>
            </nav>
        </aside>

        <main class="main-content">
            <div id="rooms" class="section active">
                <h1>Quản lý Phòng Chiếu</h1>
                <div class="add-room">
                    <h2>Thay đổi phòng chiếu</h2>
                    <form id="MovieForm" action="${pageContext.request.contextPath}/room_mng" method="POST">
                        <label for="roomSelect">Chọn phòng chiếu:</label>
                        <select id="roomSelect" name="roomId">
                            <option value="1">Room 1</option>
                            <option value="2">Room 2</option>
                            <option value="3">Room 3</option>
                            <option value="4">Room 4</option>
                            <option value="5">Room 5</option>
                        </select>

                        <label for="Styleroom">Chọn dạng phòng:</label>
                        <select id="Styleroom" name="style_room">
                            <option value="2D">2D</option>
                            <option value="3D">3D</option>
                            <option value="4Dx">4D</option>
                            <option value="Imax">Imax</option>
                        </select>

                        <label for="occupancy">Số lượng ghế:</label>
                        <input type="number" id="occupancy" name="occupancy" min="0">

                        <button type="submit">Cập nhập phòng</button>
                    </form>
                </div>

                <!-- Danh sách phòng chiếu -->
                <div class="room-list">
                    <h2>Danh sách Phòng Chiếu</h2>
                    <table id="roomTable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên phòng</th>
                                <th>Số ghế</th>
                                <th>Loại phòng</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu phòng chiếu sẽ được hiển thị ở đây -->
                        </tbody>
                    </table>
                </div>

<%--                <!-- Sơ đồ chỗ ngồi -->--%>
<%--                <div class="seat-map">--%>
<%--                    <h2>Sơ đồ Chỗ Ngồi</h2>--%>
<%--                    <div id="seatMap">--%>
<%--                        <!-- Sơ đồ chỗ ngồi sẽ được cập nhật động -->--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </main>
    </div>

<%--    <script src="room_mng.js"></script>--%>
</body>
</html>
