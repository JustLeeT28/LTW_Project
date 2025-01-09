<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đặt ghế</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/book.css">
    <script src="../Script/booked-chair.js"></script>
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/footer.css">
    <script src="../Script/search.js"></script>
</head>
<body>
<div class="nav-menu">
    <div class="lelf-menu">
        <a href="../index.jsp">
            <img id="logo-cinema" src="../img/img/Logo_tachnen.jpg" alt="Cinema Logo"/>
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim"
               onkeypress="redirectToPage(event)">
        <a href="Search.jsp" class="menu">Phim</a>
        <a href="ticket-price.jsp" class="menu">Giá vé</a>
        <a href="login.jsp" class="menu">Đăng nhập</a>
        <a href="user-infor.jsp">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="book">
    <div class="left">
        <img src="${movie.posterUrl}"/>
        <div class="play_bttn">
            <i class="bi bi-play-fill" id="play_bttn"></i>
        </div>
        <div class="infor">
            <h6>Đạo diễn: </h6>
            <c:forEach var="director" items="${directors}">
                <p>${director.name}</p>
            </c:forEach>
            <h6>Diễn viên chính </h6>
            <c:forEach var="actor" items="${actors}">
                <p>${actor.name}</p>
            </c:forEach>
            <h6>Biên tập bởi</h6>
            <p>Ruben</p>
        </div>
    </div>
    <div class="right" style="--banner-url: url('../${movie.bannerUrl}');">
        <div class="head_time">
            <h1>${movie.title}</h1>
            <div class="time">
                <h6>
                    <i class="bi bi-clock"></i>
                    165 phút
                </h6>
                <button>PG-13</button>
            </div>
        </div>
        <div class="film_sumary">
            <h1>Nội dung phim</h1>
            <p>${movie.description}</p>
        </div>
        <div class="date_type">
            <div class="left_card">
                <h6 class="tittle">
                    Thứ sáu, ngày 13, tháng 7
                </h6>
                <div class="card_month">
                    <li>
                        <h6>Thứ hai</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Thứ ba</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Thứ tư</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Thứ năm</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Thứ sáu</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Thứ bảy</h6>
                        <h6>1</h6>
                    </li>
                    <li>
                        <h6>Chủ nhật</h6>
                        <h6>1</h6>
                    </li>
                </div>
            </div>
            <div class="right_card">
                <h6 class="tittle">
                    Thời gian
                </h6>
                <div class="card_month">
                    <li>
                        <h6>2D</h6>
                        <h6>12:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>13:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>12:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>13:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>12:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>09:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>11:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>13:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>15:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>17:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>19:00</h6>
                    </li>
                    <li>
                        <h6>2D</h6>
                        <h6>21:00</h6>
                    </li>
                </div>
            </div>
        </div>
        <div class="screen">
            Screen
        </div>
        <!--chairs-->
        <div class="chair">
            <div class="row">
                <span>A</span>
                <li class="seat" data-row="A" data-seat="1">1</li>
                <li class="seat" data-row="A" data-seat="2">2</li>
                <li class="seat" data-row="A" data-seat="3">3</li>
                <li class="seat" data-row="A" data-seat="4">4</li>
                <li class="seat" data-row="A" data-seat="5">5</li>
                <li class="seat" data-row="A" data-seat="6">6</li>
                <li class="seat" data-row="A" data-seat="7">7</li>
                <li class="seat" data-row="A" data-seat="8">8</li>
                <li class="seat" data-row="A" data-seat="9">9</li>
                <li class="seat" data-row="A" data-seat="10">10</li>
                <li class="seat" data-row="A" data-seat="11">11</li>
                <li class="seat" data-row="A" data-seat="12">12</li>
                <li class="seat" data-row="A" data-seat="13">13</li>
                <li class="seat" data-row="A" data-seat="14">14</li>
                <li class="booked" data-row="A" data-seat="15">15</li>
                <li class="seat" data-row="A" data-seat="16">16</li>
                <li class="seat" data-row="A" data-seat="17">17</li>
                <li class="seat" data-row="A" data-seat="18">18</li>
                <li class="seat" data-row="A" data-seat="19">19</li>
                <li class="seat" data-row="A" data-seat="20">20</li>
                <li class="seat" data-row="A" data-seat="21">21</li>
                <li class="booked" data-row="A" data-seat="22">22</li>
                <li class="booked" data-row="A" data-seat="23">23</li>
                <li class="booked" data-row="A" data-seat="24">24</li>
                <span>A</span>
            </div>

            <div class="row">
                <span>B</span>
                <li class="seat" data-row="B" data-seat="1">1</li>
                <li class="seat" data-row="B" data-seat="2">2</li>
                <li class="seat" data-row="B" data-seat="3">3</li>
                <li class="seat" data-row="B" data-seat="4">4</li>
                <li class="seat" data-row="B" data-seat="5">5</li>
                <li class="seat" data-row="B" data-seat="6">6</li>
                <li class="seat" data-row="B" data-seat="7">7</li>
                <li class="seat" data-row="B" data-seat="8">8</li>
                <li class="seat" data-row="B" data-seat="9">9</li>
                <li class="seat" data-row="B" data-seat="10">10</li>
                <li class="seat" data-row="B" data-seat="11">11</li>
                <li class="seat" data-row="B" data-seat="12">12</li>
                <li class="seat" data-row="B" data-seat="13">13</li>
                <li class="seat" data-row="B" data-seat="14">14</li>
                <li class="seat" data-row="B" data-seat="15">15</li>
                <li class="seat" data-row="B" data-seat="16">16</li>
                <li class="seat" data-row="B" data-seat="17">17</li>
                <li class="seat" data-row="B" data-seat="18">18</li>
                <li class="seat" data-row="B" data-seat="19">19</li>
                <li class="seat" data-row="B" data-seat="20">20</li>
                <li class="seat" data-row="B" data-seat="21">21</li>
                <li class="seat" data-row="B" data-seat="22">22</li>
                <li class="seat" data-row="B" data-seat="23">23</li>
                <li class="seat" data-row="B" data-seat="24">24</li>
                <span>B</span>
            </div>

            <div class="row">
                <span>C</span>
                <li class="seat" data-row="C" data-seat="1">1</li>
                <li class="seat" data-row="C" data-seat="2">2</li>
                <li class="seat" data-row="C" data-seat="3">3</li>
                <li class="seat" data-row="C" data-seat="4">4</li>
                <li class="seat" data-row="C" data-seat="5">5</li>
                <li class="seat" data-row="C" data-seat="6">6</li>
                <li class="seat" data-row="C" data-seat="7">7</li>
                <li class="seat" data-row="C" data-seat="8">8</li>
                <li class="seat" data-row="C" data-seat="9">9</li>
                <li class="seat" data-row="C" data-seat="10">10</li>
                <li class="seat" data-row="C" data-seat="11">11</li>
                <li class="seat" data-row="C" data-seat="12">12</li>
                <li class="seat" data-row="C" data-seat="13">13</li>
                <li class="seat" data-row="C" data-seat="14">14</li>
                <li class="seat" data-row="C" data-seat="15">15</li>
                <li class="seat" data-row="C" data-seat="16">16</li>
                <li class="seat" data-row="C" data-seat="17">17</li>
                <li class="seat" data-row="C" data-seat="18">18</li>
                <li class="seat" data-row="C" data-seat="19">19</li>
                <li class="seat" data-row="C" data-seat="20">20</li>
                <li class="seat" data-row="C" data-seat="21">21</li>
                <li class="seat" data-row="C" data-seat="22">22</li>
                <li class="seat" data-row="C" data-seat="23">23</li>
                <li class="seat" data-row="C" data-seat="24">24</li>
                <span>C</span>
            </div>

            <div class="row">
                <span>D</span>
                <li class="seat" data-row="D" data-seat="1">1</li>
                <li class="seat" data-row="D" data-seat="2">2</li>
                <li class="seat" data-row="D" data-seat="3">3</li>
                <li class="seat" data-row="D" data-seat="4">4</li>
                <li class="seat" data-row="D" data-seat="5">5</li>
                <li class="seat" data-row="D" data-seat="6">6</li>
                <li class="seat" data-row="D" data-seat="7">7</li>
                <li class="seat" data-row="D" data-seat="8">8</li>
                <li class="seat" data-row="D" data-seat="9">9</li>
                <li class="seat" data-row="D" data-seat="10">10</li>
                <li class="seat" data-row="D" data-seat="11">11</li>
                <li class="seat" data-row="D" data-seat="12">12</li>
                <li class="seat" data-row="D" data-seat="13">13</li>
                <li class="seat" data-row="D" data-seat="14">14</li>
                <li class="seat" data-row="D" data-seat="15">15</li>
                <li class="seat" data-row="D" data-seat="16">16</li>
                <li class="seat" data-row="D" data-seat="17">17</li>
                <li class="seat" data-row="D" data-seat="18">18</li>
                <li class="seat" data-row="D" data-seat="19">19</li>
                <li class="seat" data-row="D" data-seat="20">20</li>
                <li class="seat" data-row="D" data-seat="21">21</li>
                <li class="seat" data-row="D" data-seat="22">22</li>
                <li class="seat" data-row="D" data-seat="23">23</li>
                <li class="seat" data-row="D" data-seat="24">24</li>
                <span>D</span>
            </div>
            <div class="row">
                <span>E</span>
                <li class="seat" data-row="E" data-seat="1">1</li>
                <li class="seat" data-row="E" data-seat="2">2</li>
                <li class="seat" data-row="E" data-seat="3">3</li>
                <li class="seat" data-row="E" data-seat="4">4</li>
                <li class="seat" data-row="E" data-seat="5">5</li>
                <li class="seat" data-row="E" data-seat="6">6</li>
                <li class="seat" data-row="E" data-seat="7">7</li>
                <li class="seat" data-row="E" data-seat="8">8</li>
                <li class="seat" data-row="E" data-seat="9">9</li>
                <li class="seat" data-row="E" data-seat="10">10</li>
                <li class="seat" data-row="E" data-seat="11">11</li>
                <li class="seat" data-row="E" data-seat="12">12</li>
                <li class="seat" data-row="E" data-seat="13">13</li>
                <li class="seat" data-row="E" data-seat="14">14</li>
                <li class="seat" data-row="E" data-seat="15">15</li>
                <li class="seat" data-row="E" data-seat="16">16</li>
                <li class="seat" data-row="E" data-seat="17">17</li>
                <li class="seat" data-row="E" data-seat="18">18</li>
                <li class="seat" data-row="E" data-seat="19">19</li>
                <li class="seat" data-row="E" data-seat="20">20</li>
                <li class="seat" data-row="E" data-seat="21">21</li>
                <li class="seat" data-row="E" data-seat="22">22</li>
                <li class="seat" data-row="E" data-seat="23">23</li>
                <li class="seat" data-row="E" data-seat="24">24</li>
                <span>E</span>
            </div>

            <div class="row">
                <span>F</span>
                <li class="seat" data-row="F" data-seat="1">1</li>
                <li class="seat" data-row="F" data-seat="2">2</li>
                <li class="seat" data-row="F" data-seat="3">3</li>
                <li class="seat" data-row="F" data-seat="4">4</li>
                <li class="seat" data-row="F" data-seat="5">5</li>
                <li class="seat" data-row="F" data-seat="6">6</li>
                <li class="seat" data-row="F" data-seat="7">7</li>
                <li class="seat" data-row="F" data-seat="8">8</li>
                <li class="seat" data-row="F" data-seat="9">9</li>
                <li class="seat" data-row="F" data-seat="10">10</li>
                <li class="seat" data-row="F" data-seat="11">11</li>
                <li class="seat" data-row="F" data-seat="12">12</li>
                <li class="seat" data-row="F" data-seat="13">13</li>
                <li class="seat" data-row="F" data-seat="14">14</li>
                <li class="seat" data-row="F" data-seat="15">15</li>
                <li class="seat" data-row="F" data-seat="16">16</li>
                <li class="seat" data-row="F" data-seat="17">17</li>
                <li class="seat" data-row="F" data-seat="18">18</li>
                <li class="seat" data-row="F" data-seat="19">19</li>
                <li class="seat" data-row="F" data-seat="20">20</li>
                <li class="seat" data-row="F" data-seat="21">21</li>
                <li class="seat" data-row="F" data-seat="22">22</li>
                <li class="seat" data-row="F" data-seat="23">23</li>
                <li class="seat" data-row="F" data-seat="24">24</li>
                <span>F</span>
            </div>

            <div class="row">
                <span>G</span>
                <li class="seat" data-row="G" data-seat="1">1</li>
                <li class="seat" data-row="G" data-seat="2">2</li>
                <li class="seat" data-row="G" data-seat="3">3</li>
                <li class="seat" data-row="G" data-seat="4">4</li>
                <li class="seat" data-row="G" data-seat="5">5</li>
                <li class="seat" data-row="G" data-seat="6">6</li>
                <li class="seat" data-row="G" data-seat="7">7</li>
                <li class="seat" data-row="G" data-seat="8">8</li>
                <li class="seat" data-row="G" data-seat="9">9</li>
                <li class="seat" data-row="G" data-seat="10">10</li>
                <li class="seat" data-row="G" data-seat="11">11</li>
                <li class="seat" data-row="G" data-seat="12">12</li>
                <li class="seat" data-row="G" data-seat="13">13</li>
                <li class="seat" data-row="G" data-seat="14">14</li>
                <li class="seat" data-row="G" data-seat="15">15</li>
                <li class="seat" data-row="G" data-seat="16">16</li>
                <li class="seat" data-row="G" data-seat="17">17</li>
                <li class="seat" data-row="G" data-seat="18">18</li>
                <li class="seat" data-row="G" data-seat="19">19</li>
                <li class="seat" data-row="G" data-seat="20">20</li>
                <li class="seat" data-row="G" data-seat="21">21</li>
                <li class="seat" data-row="G" data-seat="22">22</li>
                <li class="seat" data-row="G" data-seat="23">23</li>
                <li class="seat" data-row="G" data-seat="24">24</li>
                <span>G</span>
            </div>

            <div class="row">
                <span>H</span>
                <li class="seat" data-row="H" data-seat="1">1</li>
                <li class="seat" data-row="H" data-seat="2">2</li>
                <li class="seat" data-row="H" data-seat="3">3</li>
                <li class="seat" data-row="H" data-seat="4">4</li>
                <li class="seat" data-row="H" data-seat="5">5</li>
                <li class="seat" data-row="H" data-seat="6">6</li>
                <li class="seat" data-row="H" data-seat="7">7</li>
                <li class="seat" data-row="H" data-seat="8">8</li>
                <li class="seat" data-row="H" data-seat="9">9</li>
                <li class="seat" data-row="H" data-seat="10">10</li>
                <li class="seat" data-row="H" data-seat="11">11</li>
                <li class="seat" data-row="H" data-seat="12">12</li>
                <li class="seat" data-row="H" data-seat="13">13</li>
                <li class="seat" data-row="H" data-seat="14">14</li>
                <li class="seat" data-row="H" data-seat="15">15</li>
                <li class="seat" data-row="H" data-seat="16">16</li>
                <li class="seat" data-row="H" data-seat="17">17</li>
                <li class="seat" data-row="H" data-seat="18">18</li>
                <li class="seat" data-row="H" data-seat="19">19</li>
                <li class="seat" data-row="H" data-seat="20">20</li>
                <li class="seat" data-row="H" data-seat="21">21</li>
                <li class="seat" data-row="H" data-seat="22">22</li>
                <li class="seat" data-row="H" data-seat="23">23</li>
                <li class="seat" data-row="H" data-seat="24">24</li>
                <span>H</span>
            </div>

        </div>
        <div class="details" id="det">
            <div class="details_chair">
                <li>Available</li>
                <li>Booked</li>
                <li>Selected</li>
            </div>
        </div>
        <div class="book_movie">
            <div class="lef_book">
                <p class="text_total_pay">Các ghế đã chọn: </p>
                <div id="seats-select"></div>
            </div>
            <div class="lef_book">
                <p class="text_total_pay">Tổng thanh toán: </p>
                <div id="total_need_pay">0 VNĐ</div>
            </div>
            <div class="btn-book">Đặt vé</div>
        </div>
    </div>
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