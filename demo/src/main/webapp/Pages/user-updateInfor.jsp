<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin cá nhân</title>
    <link rel="stylesheet" href="../Styles/left-menu.css">
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/user-updateInfor.css">
    <script src="../Script/user-update.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="leftmenu">
    <a href="user-infor.jsp" class="op-infor">Thông tin</a>
    <a href="user-updateInfor.html" class="op-update open">Chỉnh sửa</a>
    <a href="history.jsp" class="op-history">Lịch sử</a>
    <a href="" id="out">Đăng suất</a>
</div>
<div class="right_infor">
    <h1><strong>CHỈNH SỬA THÔNG TIN CÁ NHÂN</strong></h1>
    <div class="infor-content">
        <div>
            <label class="highlight">Họ tên: </label> <input class="in4" id="name" type="text" placeholder="Họ tên">
        </div>
        <div>
            <span class="highlight">Sinh nhật: </span> <input class="in4" id="birthday" type="date"
                                                              placeholder="dd/mm/yyyy">
        </div>
        <div>
            <span class="highlight">Email: </span> <input class="in4" id="email" type="email"
                                                          placeholder="...@gmail.com">
        </div>
        <div>
            <span class="highlight">SĐT: </span> <input class="in4" id="numPhone" placeholder="Số điện thoại">
        </div>
        <div class="buttons">
            <div>
                <button id="clearData" class="btn">Xóa Dữ Liệu</button>
            </div>
            <div>
                <button id="saveData" class="btn">Lưu Dữ Liệu</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>