<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
</head>
<body>
<h2>Đăng Nhập</h2>

<!-- Hiển thị thông báo lỗi nếu có -->
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<div style="color: red; font-weight: bold;">
    <%= errorMessage %>
</div>
<%
    }
%>

<!-- Form đăng nhập -->
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label for="user_login">Email:</label>
        <input type="email" id="user_login" name="user_login" required />
    </div>
    <div>
        <label for="user_pass_login">Mật khẩu:</label>
        <input type="password" id="user_pass_login" name="user_pass_login" required />
    </div>
    <div>
        <button type="submit">Đăng Nhập</button>
    </div>
</form>

<!-- Link để đăng ký -->
<p>Chưa có tài khoản? <a href="signup.jsp">Đăng ký ngay</a></p>

</body>
</html>
