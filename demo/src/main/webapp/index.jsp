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
<jsp:include page="Pages/Includes/menu.jsp"/>
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
                    <a href="book?mId=${movie.id}">${movie.title}</a>
                    <button class="book-button" data-id="${movie.id}"><a href="book?mId=${movie.id}"
                                                                         style="color: black">Đặt vé</a></button>
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
    <c:forEach var="movie" items="${movies}" varStatus="status">
        <c:if test="${status.index < 8}">
            <div class="movie">
                <div class="movie-infor">
                    <div class="movie_img">
                        <img src="${movie.posterUrl}" height="1100" width="1148"/>
                    </div>
                    <div class="infor-text">
                        <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                        <h3><span class="highlight">Thời lượng:</span>165p</h3>
                        <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                        <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
                    </div>
                </div>
                <div class="book_link">
                    <a href="Pages/book.jsp">${movie.title}</a>
                    <button class="book-button future" data-id="${movie.id}">chi Tiết</button>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>
<div class="more-bttn">
    Xem thêm
</div>
<jsp:include page="Pages/Includes/footer.jsp"/>
</body>
</html>