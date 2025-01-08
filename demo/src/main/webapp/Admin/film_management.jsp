<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Phim</title>
    <link rel="stylesheet" href="film_management.css">
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
                <li><a href="customer_mng.html" data-section="customers">Quản lý Khách hàng</a></li>
                <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <div id="movies" class="section active">
            <h1>Quản lý Phim</h1>

            <!-- Thêm phim -->
            <div class="add-movie">
                <h2>Thêm phim mới</h2>
                <form action="movies?action=add" method="post">
                    <label for="title">Tên phim:</label>
                    <input type="text" id="title" name="title" required>

                    <label for="poster">URL Poster:</label>
                    <input type="url" id="poster" name="posterUrl" required>

                    <label for="trailer">URL Banner:</label>
                    <input type="url" id="trailer" name="bannerUrl" required>

                    <label for="description">Mô tả:</label>
                    <textarea id="description" name="description" rows="3" required></textarea>

                    <label for="duration">Thời lượng (phút):</label>
                    <input type="number" id="duration" name="duration" required>

                    <label for="genre">Thể loại:</label>
                    <input type="text" id="genre" name="genre" required>

                    <label for="director">Đạo diễn:</label>
                    <input type="text" id="director" name="director" required>

                    <label for="actors">Diễn viên:</label>
                    <input type="text" id="actors" name="actors" required>

                    <label for="ageLimit">Độ tuổi giới hạn:</label>
                    <input type="text" id="ageLimit" name="ageRating" required>

                    <label for="releaseDate">Ngày phát hành:</label>
                    <input type="date" id="releaseDate" name="releaseDate" required>

                    <button type="submit">Thêm phim</button>
                </form>
            </div>

            <!-- Danh sách phim -->
            <div class="movie-list">
                <h2>Danh sách phim</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Tên phim</th>
                        <th>Thể loại</th>
                        <th>Thời lượng</th>
                        <th>Ngày phát hành</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="movie" items="${movieList}">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.duration} phút</td>
                            <td>${movie.releaseDate}</td>
                            <td>
                                <a href="movies?action=edit&id=${movie.id}">Chỉnh sửa</a> |
                                <a href="movies?action=delete&id=${movie.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa phim này?');">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>
</body>
</html>
