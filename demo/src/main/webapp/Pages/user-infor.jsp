<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="../Styles/left-menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/user-infor.css">
    <script src="../Script/user-infor.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="leftmenu">
    <a href="user-infor.jsp" class="op-infor open">Thông tin </a>
    <a href="user-updateinfor.jsp" class="op-update ">Chỉnh sửa</a>
    <a href="history.jsp" class="op-history">Lịch sử</a>
    <a href="${pageContext.request.contextPath}/userChangePass">Đổi mật khẩu</a>
    <a href="${pageContext.request.contextPath}/LogoutController" id="out">Đăng xuất</a>
</div>
<div class="right_infor">
    <h1><strong>THÔNG TIN CÁ NHÂN</strong></h1>
    <div class="infor-content">
        <div class="row-infor">
            <span class="highlight">Họ tên: </span> <span class="in4" id="name">${sessionScope.user.name} - ${sessionScope.user.id}</span>
        </div>
        <div class="row-infor">
            <span class="highlight">Sinh nhật: </span> <span class="in4" id="birthday">
            <c:if test="${empty sessionScope.user.dob}">
                Chưa có thông tin
            </c:if>
            <c:if test="${not empty sessionScope.user.dob}">
                ${sessionScope.user.dob}
            </c:if>
            </span>
        </div>
        <div class="row-infor">
            <span class="highlight">Email: </span> <span class="in4" id="email">${sessionScope.user.email}</span>
        </div>
        <div class="row-infor">
            <span class="highlight">SĐT: </span> <span class="in4" id="numPhone">
            <c:if test="${empty sessionScope.user.phone}">
                    Chưa có thông tin
                </c:if>
            <c:if test="${not empty sessionScope.user.phone}">
                ${sessionScope.user.phone}
            </c:if>
        </span>
        </div>
    </div>
</div>
</body>
</html>