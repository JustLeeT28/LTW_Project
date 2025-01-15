<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Quản lý Khách hàng</title>
    <link rel="stylesheet" href="customer_mng.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/customer_mng.css">

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
                <div class="search-customer" style="margin-bottom: 15px">
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
                                <th>Cấp độ</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Dữ liệu khách hàng -->
                            <c:forEach var="user" items="${listUser}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phone == null? "Null" : user.phone}</td>
                                    <td>${user.role == 1 ? 'Admin' : 'Người dùng'}</td>
                                    <td>
                                        <!-- Button chỉnh sửa -->
                                        <c:if test="${user.status == 'active'}">
                                            <form id="block" class="form-block" action="${pageContext.request.contextPath}/UpdateCustomer" method="POST">
                                                <input type="hidden" name="user_status_block" value="${user.id}" />
                                                <button type="submit" style="width: 100%;background-color: green;color: white;border: none;border-radius: 5px;cursor: pointer;transition: all 0.3s ease-in-out;" onmouseover="this.style.backgroundColor='#228b22'; this.style.color='#f0f0f0';"onmouseout="this.style.backgroundColor='green'; this.style.color='white';">
                                                    Vô hiệu</button>
                                            </form>
                                        </c:if>

                                        <c:if test="${user.status == 'inactive'}">
                                            <form id="unblock" class="form-unblock" action="${pageContext.request.contextPath}/UpdateCustomer" method="POST">
                                                <input type="hidden" name="user_status_unblock" value="${user.id}" />
                                                <button type="submit" style="width: 100%;background-color: green;color: white;border: none;border-radius: 5px;cursor: pointer;transition: all 0.3s ease-in-out;" onmouseover="this.style.backgroundColor='#228b22'; this.style.color='#f0f0f0';"onmouseout="this.style.backgroundColor='green'; this.style.color='white';">
                                                    Bỏ chặn</button>
                                            </form>
                                        </c:if>

                                        <!-- Button xóa -->
                                        <form class="form-delete" action="${pageContext.request.contextPath}/UpdateCustomer" method="POST" onsubmit="return confirm('Bạn có chắc chắn muốn xóa người này?');">
                                            <input type="hidden" name="user_del" value="${user.id}" />
                                            <button type="submit" style="width: 100%; margin-top: 5px">
                                                Xóa</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
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

<%--    <script src="customer_mng.js"></script>--%>
</body>
</html>
