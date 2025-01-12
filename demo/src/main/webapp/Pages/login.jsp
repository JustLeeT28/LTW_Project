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
  <div class="form-wrap">
    <div class="tabs">
      <h3 class="signup-tab"><a class="active" href="#signup-tab-content" style="border-top-left-radius: 7px;">Sign Up</a></h3>
      <h3 class="login-tab"><a href="#login-tab-content" style="border-top-right-radius: 7px;">Login</a></h3>
    </div>
    <div class="tabs-content">
      <div id="signup-tab-content" class="active">
        <form class="signup-form" action="${pageContext.request.contextPath}/login" method="post">
          <input type="email" class="input" id="user_email" autocomplete="off" placeholder="Email">
          <input type="text" class="input" id="user_name" autocomplete="off" placeholder="Username">
          <input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
          <input type="submit" class="button" value="Sign Up">
        </form>
        <div class="help">
          <p>By signing up, you agree to our</p>
          <p><a href="">Terms of service</a></p>
        </div>
      </div>
      <div id="login-tab-content">
  <form class="login-form" action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
    <input type="text" class="input" id="user_login" name="user_login" autocomplete="off" placeholder="Email hoặc Username">
    <input type="password" class="input" id="user_pass_login" name="user_pass_login" autocomplete="off" placeholder="Password">
    <input type="checkbox" class="checkbox" id="remember_me">
    <label for="remember_me">Remember me</label>
    <input type="submit" class="button" value="Login">
  </form>

  <div class="help">
          <p><a href="forgotpass.jsp">Forget your password?</a></p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}\Script\login.js"></script>
</body>
<c:if test="${not empty errorMessage}">
  <script>
    alert('${errorMessage}');
  </script>
</c:if>
</html>
