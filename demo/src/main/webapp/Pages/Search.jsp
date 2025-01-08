<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tìm phim</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/Search.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <script src="../Script/click_book_button.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="../Script/search.js"></script>
    <script> const basePath = "<%=request.getContextPath()%>";</script>
</head>
<body>
<div class="nav-menu">
    <div class="lelf-menu">
        <a href="../index.jsp">
            <img id="logo-cinema" src="../img/img/Logo_tachnen.jpg" alt="Cinema Logo" />
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim" onkeypress="redirectToPage(event)" >
        <a href="Search.html" class="menu">Phim</a>
        <a href="ticket-price.jsp" class="menu">Giá vé</a>
        <a href="login.jsp" class="menu">Đăng nhập</a>
        <a href="user-infor.jsp">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="header">
    <h1>KẾT QUẢ TÌM KIẾM PHIM</h1>
</div>
<div class="Se-movie ">
    <form id="filterForm" method="get" action="${pageContext.request.contextPath}/search">
        <!-- Combobox Thể loại -->
        <select class="combobox" name="genre" id="genre" onchange="document.getElementById('filterForm').submit();">
            <option value="">Thể loại</option>
            <c:forEach var="g" items="${genres}">
                <option value="${g.id}" ${g.id == genre ? 'selected' : ''}>${g.genre}</option>
            </c:forEach>
        </select>

        <!-- Combobox Trạng thái -->
        <select class="combobox" name="condition" id="condition" onchange="document.getElementById('filterForm').submit();">
            <option value="">Sắp xếp</option>
            <option value="new" ${'new' == condition ? 'selected' : ''}>Phim mới chiếu</option>
            <option value="hot" ${'hot' == condition ? 'selected' : ''}>Phim xem nhiều</option>
        </select>
    </form>

</div>
<div class="container-movie">
    <c:forEach var="movie" items="${movies_all}" varStatus="status">
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
                    <a href="Pages/book.jsp">${movie.title}</a>
                    <button class="book-button">Đặt vé</button>
                </div>
            </div>
    </c:forEach>
</div>
<div class="pagination">
    <ul class="page">
        <li class="num-page">
            <a href="search?page=${currentPage - 1}&genre=${genre}&condition=${condition}" class="number-icon" ${currentPage == 1 ? 'style="pointer-events:none;opacity:0.5;"' : ''}>&lt;&lt;</a>
        </li>
        <c:forEach var="page" begin="1" end="${totalPages}">
            <li class="num-page">
                <a href="search?page=${page}&genre=${genre}&condition=${condition}" class="number${page == currentPage ? 'active' : ''}">${page}</a>
            </li>
        </c:forEach>
        <li class="num-page">
            <a href="search?page=${currentPage + 1}&genre=${genre}&condition=${condition}" class="number-icon" ${currentPage == totalPages ? 'style="pointer-events:none;opacity:0.5;"' : ''}>&gt;&gt;</a>
        </li>
    </ul>
</div>
        <div class="footer">
    <div class="column-1">
        <div class="logo-footer">
            <img id="logo-cinema-footer" src="../img/img/Logo_tachnen.jpg"/>
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
