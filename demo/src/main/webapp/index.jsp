<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="Styles/index.css">
    <script src="Script/index-slideshow.js"></script>
    <link rel="stylesheet" href="Styles/nav_menu.css">
    <link rel="stylesheet" href="Styles/footer.css">
    <script src="Script/index.js"></script>
    <script src="Script/click_book_button.js"></script>
    <script src="Script/search.js"></script>
    <script> const basePath = "<%=request.getContextPath()%>";</script>
</head>
<body>
<div class="nav-menu">
    <div class="lelf-menu">
        <a href="index.jsp">
            <img id="logo-cinema" src="img/img/Logo_tachnen.jpg" alt="Cinema Logo"/>
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim"
               onkeypress="redirectToPage(event)">
        <a href="Pages/Search.jsp" class="menu">Phim</a>
        <a href="Pages/ticket-price.jsp" class="menu">Giá vé</a>
        <a href="Pages/login.jsp" class="menu">Đăng nhập</a>
        <a href="Pages/user-infor.jsp">
            <img src="img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="slide-show">
    <div class="list-img">
        <img class="slide-img" src="img/img/gadar_bg.jpg" alt=""/>
        <img class="slide-img" src="img/img/bg.png" alt=""/>
        <img class="slide-img" src="img/img/avenger_bg.jpg" alt=""/>
        <img class="slide-img" src="img/img/ant_man_bg.jpg" alt=""/>
    </div>
    <div class="btns">
        <div class="btn-left btn">
            <i class="fa-solid fa-chevron-left"></i>
        </div>
        <div class="btn-right btn">
            <i class="fa-solid fa-chevron-right"></i>
        </div>
    </div>
    <div class="dots-container">
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
    </div>
</div>
<div class="title-movie-showing">
    <h1>Phim đang chiếu</h1>
</div>
<div class="movie-showing">
    <c:forEach var="movie" items="${movies}" varStatus="status">
        <c:if test="${status.index < 8}">
            <div class="movie">
                <div class="movie-infor">
                    <div class="movie_img">
                        <img src="${movie.posterUrl}" height="1100" width="1148"/>
                    </div>
                    <div class="infor-text">
                        <h3><span class="highlight">Quốc gia:</span>${movie.country}</h3>
                        <h3><span class="highlight">Thời lượng:</span>${movie.duration}p</h3>
                        <h3><span class="highlight">Ngôn ngữ:</span>${movie.language}</h3>
                        <h3><span class="highlight">Phụ đề:</span>${movie.subtitle}</h3>
                    </div>
                </div>
                <div class="book_link">
                    <a href="Pages/book.jsp">${movie.title}</a>
                    <button class="book-button">Đặt vé</button>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>
<div class="more-bttn">
    Xem thêm
</div>
<div class="title-movie-incoming">
    <h1>Phim sắp chiếu</h1>
</div>
<div class="movie-incoming">
    <div class="movie">
        <div class="movie-infor">
            <img src="img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="Pages/detail.jsp">Jawan</a>
        <button class="book-button future">Chi tiết</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="Pages/detail.jsp">Jawan</a>
        <button class="book-button future">Chi tiết</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="Pages/detail.jsp">Jawan</a>
        <button class="book-button future">Chi tiết</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="Pages/detail.jsp">Jawan</a>
        <button class="book-button future">Chi tiết</button>
    </div>
</div>
<div class="more-bttn">
    Xem thêm
</div>
<div class="footer">
    <div class="column-1">
        <div class="logo-footer">
            <img id="logo-cinema-footer" src="../img/img/logo_tachnen.jpg"/>
            <a href="">Cinema</a>
        </div>

    </div>
    <div class="column-2">
        <div class="social-icons">
            <h2>follow us</h2>
            <li><a href=""><i class="fa-brands fa-facebook-f"></i> Facebook</a></li>
            <li><a href=""><i class="fa-brands fa-instagram"></i> Instagram</a></li>
            <li><a href=""><i class="fa-brands fa-tiktok"></i> TikTok</a></li>
        </div>
    </div>
    <div class="column-3">
        <div class="contact-address">
            <h2>Địa chỉ</h2>
            <li class="address1"><i class="fa-solid fa-location-dot"></i>Thủ Đức, TpHCM</li>
            <li><a href=""><i class="fa-solid fa-phone"></i>+84 12345678</a></li>
            <li><a href=""><i class="fa-solid fa-envelope"></i> 123@gmail.com</a></li>
        </div>
    </div>
</div>
</body>
</html>