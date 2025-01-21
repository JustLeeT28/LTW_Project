<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin cá nhân</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/left-menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/user-updateInfor.css">
    <script src="${pageContext.request.contextPath}/Script/user-update.js"></script>
<%--    <script src="${pageContext.request.contextPath}/Script/search.js"></script>--%>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="leftmenu">
    <a href="${pageContext.request.contextPath}/Pages/user-infor.jsp" class="op-infor">Thông tin</a>
    <a href="${pageContext.request.contextPath}/Pages/user-updateinfor.jsp">Chỉnh sửa</a>
    <a href="${pageContext.request.contextPath}/Pages/history.jsp" class="op-history">Lịch sử</a>
    <a href="${pageContext.request.contextPath}/userChangePass" class="op-update open">Đổi mật khẩu</a>
    <a href="${pageContext.request.contextPath}/LogoutController" id="out">Đăng xuất</a>
</div>
<div class="right_infor">
    <h1><strong> ĐỔI MẬT KHẨU </strong></h1>
    <c:if test="${not empty message}">
        <p>message</p>
    </c:if>
    <div class="infor-content">
    <form action="${pageContext.request.contextPath}/userChangePass" method="POST">
        <div class="row-input">
            <label class="highlight">MK cũ:</label>
            <input class="in4" id="name" name="old_pass" type="password" placeholder="nhập mật khẩu cũ" required>
        </div>
        <div class="row-input">
            <label class="highlight">MK mới 1:</label>
            <input class="in4" name="new_pass1" type="password" placeholder="nhập mật khẩu mới" required>
        </div>
        <div class="row-input">
            <label class="highlight">MK mới 2:</label>
            <input class="in4" name="new_pass1" type="password" placeholder="nhập lại mật khẩu mới" required>
        </div>
        <div class="buttons">
        <div>
            <button type="submit" class="btn" style="margin-left: 200px ">Đổi mật khẩu</button>
        </div>
        </div>
    </form>

<%--    <div class="buttons">--%>
<%--            <div>--%>
<%--                <button id="clearData" class="btn">Xóa Dữ Liệu</button>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <button id="saveData" class="btn">Lưu Dữ Liệu</button>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>
</div>
</body>
</html>