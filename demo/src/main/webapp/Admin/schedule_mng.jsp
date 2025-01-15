<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Lịch Chiếu</title>
    <link rel="stylesheet" href="schedule_mng.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/schedule_mng.css">
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
            </nav>
        </aside>

        <main class="main-content">
            <div id="schedule" class="section active">
                <h1>Quản lý Lịch Chiếu</h1>
                <c:if test="${not empty message}">
                    <p>${message}</p>
                </c:if>
                <!-- Lên lịch chiếu -->
                <div class="add-schedule">
                    <h2>Lên lịch chiếu</h2>
                    <form id="scheduleForm" action="${pageContext.request.contextPath}/schedule_mng" method="POST">
                        <label for="movieSelect">Nhập mã phim:</label>
                        <input type="number" id="movieSelect" name="movieId" required>

                        <label for="roomSelect">Phòng chiếu:</label>
                        <select id="roomSelect" name="roomId">
                            <option value="1">Room 1</option>
                            <option value="2">Room 2</option>
                            <option value="3">Room 3</option>
                            <option value="4">Room 4</option>
                            <option value="5">Room 5</option>
                        </select>

                        <label for="showDate">Ngày chiếu:</label>
                        <input type="date" id="showDate" name="showDate" required>

                        <label for="showTime">Giờ chiếu:</label>
                        <input type="time" id="showTime" name="showTime" required>

                        <button type="submit">Thêm lịch chiếu</button>
                    </form>

                </div>

                <!-- Danh sách lịch chiếu -->
                <div class="schedule-list">
                    <h2>Danh sách Lịch Chiếu</h2>
                    <table id="scheduleTable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Mã phim</th>
                                <th>Mã phòng</th>
                                <th>Ngày</th>
                                <th>Giờ</th>
<%--                                <th>Hành động</th>--%>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="showtime" items="${showtimes}">
                            <tr>
                                <td>${showtime.id}</td>
                                <td>${showtime.movieId}</td>
                                <td>${showtime.roomId}</td>
                                <td>${showtime.showDate}</td>
                                <td>${showtime.showTime}</td>
<%--                                <td>--%>
<%--                                    <button id="change-button" onclick="window.location.href='${pageContext.request.contextPath}/UpdateFilm?mId=${movie.id}'">--%>
<%--                                        Chỉnh sửa--%>
<%--                                    </button>--%>
<%--                                    <form action="${pageContext.request.contextPath}/film_management" method="POST" onsubmit="return confirm('Bạn có chắc chắn muốn xóa phim này?');">--%>
<%--                                        <input type="hidden" name="del_movie_id" value="${movie.id}" />--%>
<%--                                        <button type="submit">Xóa</button>--%>
<%--                                    </form>--%>
<%--                                </td>--%>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>

<%--    <script src="schedule_mng.js"></script>--%>
</body>
</html>
