<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Forgot Password</title>--%>
<%--    <link rel="stylesheet" href="../Styles/fgpass.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--    <div class="main-container"> --%>
<%--        <div class="form-container">--%>
<%--            <div class="logo-container">--%>
<%--                Forgot Password--%>
<%--            </div>--%>
<%--            <form action="" class="form">--%>
<%--                <div class="form-group">--%>
<%--                    <label for="Email"></label>--%>
<%--                    <input type="text" id="Email" name="email" placeholder="Enter your email" required> --%>
<%--                </div>--%>
<%--                <button class="form-submit-btn">Send Email</button>--%>
<%--            </form>--%>

<%--            <p class="signup-link">--%>
<%--                Don't have an Account?--%>
<%--                <a href="" class="signup-link link">Sign up now</a>--%>
<%--            </p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Quên mật khẩu</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/forgostPass.css" />
</head>
<body style="display: flex; justify-content:center ; align-items: center;height: 100vh;overflow: hidden;">
<div class="container-forgot">
    <c:if test="${not empty errorMessage}">
        <div class="error-message" style="color: white; font-size: 20px;">
            <strong>${errorMessage}</strong>
        </div>
    </c:if>
    <div class="form-wrap">
        <div class="tabs">
            <h3 class="forgotpass-tab"><a class="active" href="#forgotpass-tab-content"><strong>Quên mật khẩu</strong></a></h3>
        </div>
        <div class="tabs-content">
            <div id="forgotpass-tab-content" class="active">
                <form class="forgotpass-form" action="${pageContext.request.contextPath}/forgotpassword" method="post" id="forgotpassForm">
                    <input type="email" class="input" id="forgotpass_user_email" name="forgotpass_user_email" autocomplete="off" placeholder="Nhập Email của bạn" required>
                    <button class="button" type="submit">Gửi liên kết khôi phục mật khẩu</button>
                </form>
                <div class="help">
                    <p><a href="${pageContext.request.contextPath}/Pages/login.jsp">Trở lại trang đăng nhập</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
