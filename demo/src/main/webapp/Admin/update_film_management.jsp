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
                <li><a href="dashboard.jsp" data-section="dashboard">Dashboard</a></li>
                <li><a href="${pageContext.request.contextPath}film_management" data-section="movies">Quản lý Phim</a></li>
                <li><a href="schedule_mng.jsp" data-section="schedules">Quản lý Lịch Chiếu</a></li>
                <li><a href="room_mng.jsp" data-section="rooms">Quản lý Phòng Chiếu</a></li>
                <li><a href="tikket_mng.jsp" data-section="tickets">Quản lý Vé</a></li>
                <li><a href="customer_mng.jsp" data-section="customers">Quản lý Khách hàng</a></li>
                <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <div id="movies" class="section active">
            <h1>Chỉnh sửa phim</h1>
            <div class="add-movie">
                <h2>Tên phim: ${movie_title}</h2>
                <c:if test="${not empty Message}">
                    <p style="color: #0f0c29" >${Message}</p>
                </c:if>
                <form action="${pageContext.request.contextPath}/UpdateFilm" method="post">
                    <label for="title">Tên phim: </label>
                    <input type="text" id="title" name="title" >

                    <label for="poster">URL Poster:</label>
                    <input type="text" id="poster" name="posterUrl" >

                    <label for="trailer">URL Banner:</label>
                    <input type="text" id="trailer" name="bannerUrl" >

                    <label for="description">Mô tả:</label>
                    <textarea id="description" name="description" rows="3" ></textarea>

                    <label for="duration">Thời lượng (phút):</label>
                    <input type="number" id="duration" name="duration" >

                    <label for="duration">Quốc gia: </label>
                    <input type="text" id="country" name="country" >

                    <label for="duration">Ngôn ngữ: </label>
                    <input type="text" id="language" name="language" >

                    <label for="duration">Phụ đề: </label>
                    <input type="text" id="subtitle" name="subtitle" >

                    <label for="genre">Thể loại:</label>
                    <input type="text" id="genre" name="genre" >

                    <label for="director">Đạo diễn:</label>
                    <input type="text" id="director" name="director" >

                    <label for="actors">Diễn viên:</label>
                    <input type="text" id="actors" name="actors">

                    <label for="ageLimit">Độ tuổi giới hạn:</label>
                    <input type="text" id="ageLimit" name="ageRating" >

                    <label for="releaseDate">Ngày bắt đầu chiếu:</label>
                    <input type="date" id="releaseDate" name="releaseDate" >

                    <label for="releaseDate">Ngày ngưng chiếu:</label>
                    <input type="date" id="endDate" name="endDate" >

                    <input type="hidden" id="idmovie" name="mId" value="${movie_id}" >
                    <button type="submit">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </main>
</div>
</body>
</html>
