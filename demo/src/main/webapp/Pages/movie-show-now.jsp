<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phim đang chiếu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/Search.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="../Script/click_book_button.js"></script>
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="header">
    <h1>PHIM ĐANG CHIÉU</h1>
</div>
<div class="Se-movie ">


</div>
<div class="container-movie">
    <c:forEach var="movie" items="${movies_now}" varStatus="status">
        <div class="movie">
            <div class="movie-infor">
                <div class="movie_img">
                    <img src="${movie.posterUrl}" height="1100" width="1148"/>
                </div>
                <div class="infor-text">
                    <h3><span class="highlight">Quốc gia:</span>${movie.country}</h3>
                    <h3><span class="highlight">Thời lượng:</span>${movie.duration}</h3>
                    <h3><span class="highlight">Ngôn ngữ:</span>${movie.language}</h3>
                    <h3><span class="highlight">Phụ đề:</span>${movie.subtitle}</h3>
                </div>
            </div>
            <div class="book_link">
                <a href="book?mId=${movie.id}">${movie.title}</a>
                <button class="book-button" data-id="${movie.id}"><a href="book?mId=${movie.id}"
                                                                     style="color: black">Đặt vé</a></button>                </div>
        </div>
    </c:forEach>
</div>
<div class="pagination">
    <ul class="page">
        <li class="num-page">
            <a href="movieNow?page=${currentPage - 1}" class="number-icon" ${currentPage == 1 ? 'style="pointer-events:none;opacity:0.5;"' : ''}>&lt;&lt;</a>
        </li>
        <c:forEach var="page" begin="1" end="${totalPages}">
            <li class="num-page">
                <a href="movieNow?page=${page}" class="number ${page == currentPage ? 'active' : ''}">${page}</a>
            </li>
        </c:forEach>
        <li class="num-page">
            <a href="movieNow?page=${currentPage + 1}" class="number-icon" ${currentPage == totalPages ? 'style="pointer-events:none;opacity:0.5;"' : ''}>&gt;&gt;</a>
        </li>
    </ul>
</div>

<jsp:include page="Includes/footer.jsp"/>
</body>
</html>
