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
                <li><a href="${pageContext.request.contextPath}/film_management" data-section="movies">Quản lý phim</a></li>
                <li><a href="${pageContext.request.contextPath}/schedule_mng" data-section="schedules">Quản lý lịch chiếu</a></li>
                <li><a href="${pageContext.request.contextPath}/room_mng" data-section="rooms">Quản lý phòng chiếu</a></li>
                <li><a href="${pageContext.request.contextPath}/tikket_mng" data-section="tickets">Quản lý vé</a></li>
                <li><a href="${pageContext.request.contextPath}/customer_mng" data-section="customers">Quản lý khách hàng</a></li>
                <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                <%--                <li><a href="reports_mng.jsp" data-section="settings">Báo cáo và Thống kê</a></li>--%>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <div id="movies" class="section active">
            <h1>Chỉnh sửa thông tin người dùng</h1>
            <div class="add-movie">
                <h2>Tên người dùng: ${user.name}</h2>
                <c:if test="${not empty Message}">
                    <p style="color: #0f0c29" >${Message}</p>
                </c:if>
                <form action="${pageContext.request.contextPath}/AdManageUser" method="post">
                    <label for="title">Tên người dùng: </label>
                    <input type="text" id="title" name="nameUser" placeholder="Tên: ${user.name}">

                    <label for="poster">Email người dùng: </label>
                    <input type="email" id="poster" name="emailUser" placeholder="Email: ${user.email}" >

                    <label for="poster">Số điện thoại: </label>
                    <input type="number" id="email" name="phoneUser" placeholder="SĐT: ${user.phone}">

                    <label for="releaseDate">Sinh nhật: </label>
                    <input type="date" id="releaseDate" name="dobUser" placeholder="Sinh nhật: ${user.dob}">

                    <label for="title">Mật khẩu: </label>
                    <input type="password" id="pass" name="passUser" placeholder="Nhập pass muốn thay đổi">

                    <label for="roleSelect">Cấp độ người dùng:</label>
                    <select id="roleSelect" name="roleUser">
                        <option value="0" ${user.role == 0 ? 'selected' : ''}>Khách hàng</option>
                        <option value="1" ${user.role == 1 ? 'selected' : ''}>Admin</option>
                    </select>

                    <label for="statusSelect">Trạng thái người dùng:</label>
                    <select id="statusSelect" name="statusUser">
                        <option value="active" ${user.status == "active" ? 'selected' : ''}>active</option>
                        <option value="inactive" ${user.status == "inactive" ? 'selected' : ''}>inactive</option>
                    </select>

                    <input type="hidden" id="idmovie" name="idUser" value="${user.id}" >
                    <button type="submit">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </main>
</div>
</body>
</html>
