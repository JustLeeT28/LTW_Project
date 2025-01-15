<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Phim</title>
    <link rel="stylesheet" href="film_management.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/film_management.css">

</head>
<body>
<div class="container">
    <aside class="sidebar">
        <h2>Admin Panel</h2>
        <nav>
            <ul>
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
        <div id="movies" class="section active">
            <h1>Quản lý Phim</h1>

            <!-- Thêm phim -->
            <div class="add-movie">
                <h2>Thêm phim mới</h2>
                <c:if test="${not empty Message}">
                    <p>${Message}</p>
                </c:if>
                <form action="${pageContext.request.contextPath}/film_management" method="post">
                    <label for="title">Tên phim:</label>
                    <input type="text" id="title" name="title" required>

                    <label for="poster">URL Poster:</label>
                    <input type="text" id="poster" name="posterUrl" required>

                    <label for="trailer">URL Banner:</label>
                    <input type="text" id="trailer" name="bannerUrl" required>

                    <label for="description">Mô tả:</label>
                    <textarea id="description" name="description" rows="3" required></textarea>

                    <label for="duration">Thời lượng (phút):</label>
                    <input type="number" id="duration" name="duration" required>

                    <label for="duration">Quốc gia: </label>
                    <input type="text" id="country" name="country" required>

                    <label for="duration">Ngôn ngữ: </label>
                    <input type="text" id="language" name="language" required>

                    <label for="duration">Phụ đề: </label>
                    <input type="text" id="subtitle" name="subtitle" required>

                    <label for="genre">Thể loại:</label>
                    <input type="text" id="genre" name="genre" required>

                    <label for="director">Đạo diễn:</label>
                    <input type="text" id="director" name="director" required>

                    <label for="actors">Diễn viên:</label>
                    <input type="text" id="actors" name="actors" required>

                    <label for="ageLimit">Độ tuổi giới hạn:</label>
                    <input type="text" id="ageLimit" name="ageRating" required>

                    <label for="releaseDate">Ngày bắt đầu chiếu:</label>
                    <input type="date" id="releaseDate" name="releaseDate" required>

                    <label for="releaseDate">Ngày ngưng chiếu:</label>
                    <input type="date" id="endDate" name="endDate" required>

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
                        <th>Thời lượng</th>
                        <th>Ngày bắt đầu chiếu</th>
                        <th>Ngày ngưng chiếu</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="movie" items="${movies}">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.duration}</td>
                            <td>${movie.releaseDate}</td>
                            <td>${movie.endDate}</td>
                            <td>
                                <button id="change-button" onclick="window.location.href='${pageContext.request.contextPath}/UpdateFilm?mId=${movie.id}'">
                                    Chỉnh sửa
                                </button>
                                <form action="${pageContext.request.contextPath}/film_management" method="POST" onsubmit="return confirm('Bạn có chắc chắn muốn xóa phim này?');">
                                    <input type="hidden" name="del_movie_id" value="${movie.id}" />
                                    <button type="submit">Xóa</button>
                                </form>
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
