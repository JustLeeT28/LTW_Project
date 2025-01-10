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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
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
        <jsp:include page="Rooms/room1.jsp"/>
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
<jsp:include page="Includes/footer.jsp"/>
</body>
</html>