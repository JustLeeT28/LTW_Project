<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tìm phim</title>
    <link rel="stylesheet" href="../Styles/Search.css">
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <script src="../Script/click_book_button.js"></script>
    <link rel="stylesheet" href="../Styles/footer.css">
    <script src="../Script/search.js"></script>
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
    <select class="combobox" name="movie-genre" id="genre">
        <option value="" disabled selected>Thể loại</option>
        <option value="Funny">Hài Hước</option>
        <option value="horror">Kinh dị</option>
        <option value="action">Hành động</option>
        <option value="romatic">Ngôn tình</option>
    </select>
    <select class="combobox" name="movie-sort" id="sort">
        <option value="" disabled selected>Sắp xếp</option>
        <option value="new-movie">Phim mới chiếu</option>
        <option value="best-movie">Phim xem nhiều</option>
    </select>
</div>
<div class="container-movie">
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
    <div class="movie">
        <div class="movie-infor">
            <img src="../img/img/jawan.jpg" height="1530" width="1148"/>
            <div class="infor-text">
                <h3><span class="highlight">Quốc gia:</span>Mỹ</h3>
                <h3><span class="highlight">Thời lượng:</span>165p</h3>
                <h3><span class="highlight">Ngôn ngữ:</span>Tiếng Anh</h3>
                <h3><span class="highlight">Phụ đề:</span>Tiếng Việt</h3>
            </div>
        </div>
        <a href="book.jsp">Jawan</a>
        <button class="book-button">Đặt vé</button>
    </div>
</div>
<div class="pagination">
    <ul class="page">
        <li class="num-page">
            <a href="" class="number-icon"><<</a>
        </li>
        <li class="num-page">
            <a href="" class="number">1</a>
        </li>
        <li class="num-page">
            <a href="" class="number">2</a>
        </li>
        <li class="num-page">
            <a href="" class="number">3</a>
        </li>
        <li class="num-page">
            <a href="" class="number disable">...</a>
        </li>
        <li class="num-page">
            <a href="" class="number">7</a>
        </li>
        <li class="num-page">
            <a href="" class="number-icon">>></a>
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
