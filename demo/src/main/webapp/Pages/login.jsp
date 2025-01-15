<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Login-Register</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}\Styles\login.css" />
</head>
<body style="display: flex; justify-content:center ; align-items: center;height: 100vh;overflow: hidden;">
<div class="container-login">
  <c:if test="${not empty errorMessage}">
    <div class="error-message" style="color: white;font-size: 20px">
      <strong>${errorMessage}</strong> sdfshudhfushfusdfsdfijasid fjisdf
    </div>
  </c:if>
  <div class="form-wrap">
    <div class="tabs">
      <h3 class="login-tab"><a class="active" href="#login-tab-content" style="border-top-right-radius: 7px;"><strong>Đăng nhập</strong></a></h3>
      <h3 class="signup-tab"><a  href="#signup-tab-content" style="border-top-left-radius: 7px;"><strong>Đăng ký</strong></a></h3>
    </div>
    <div class="tabs-content">
      <div id="signup-tab-content">
        <form class="signup-form" action="${pageContext.request.contextPath}/login" method="post" id="signupForm">
          <input type="email" class="input" id="signup_user_email" name="signup_user_email" autocomplete="off" placeholder="Email" required>
          <input type="text" class="input" id="signup_user_name" name="signup_user_name"  autocomplete="off" placeholder="Họ tên" required>
          <input type="password" class="input" id="signup_user_pass" name="signup_user_pass" autocomplete="off" placeholder="Mật khẩu" required>
          <input type="password" class="input" id="signup_user_pass2" name="signup_user_pass2" autocomplete="off" placeholder="Nhập lại mật khẩu" required>
<%--          <input type="submit" class="button" value="Đăng ký">--%>
          <button class="button" type="button" onclick="validatePasswords()">Đăng ký</button>
        </form>
<%--        <div class="help">--%>
<%--          <p>By signing up, you agree to our</p>--%>
<%--          <p><a href="">Terms of service</a></p>--%>
<%--        </div>--%>
      </div>
      <div id="login-tab-content" class="active">
  <form class="login-form" action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
    <input type="email" class="input" id="user_login" name="user_login" autocomplete="off" placeholder="Email" required>
    <input type="password" class="input" id="user_pass_login" name="user_pass_login" autocomplete="off" placeholder="Mật khẩu" required>
<%--    <input type="checkbox" class="checkbox" id="remember_me">--%>
<%--    <label for="remember_me">Remember me</label>--%>
    <input type="submit" class="button" value="Đăng nhập">
  </form>

  <div class="help">
          <p><a href="${pageContext.request.contextPath}/Pages/forgotpass.jsp">Quên mật khẩu?</a></p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}\Script\login.js"></script>
</div>
</body>
</html>
