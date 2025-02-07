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
    <script src="${pageContext.request.contextPath}/Script/chooseDate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <style>
        .book {
            margin-top: 655px;
            margin-bottom: 390px;
        }
        .date_type{
            margin-top: 15px;
        }
    </style>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="book">
    <div class="left">
        <img src="${movie.posterUrl}"/>
        <div class="play_bttn" onclick=" toggleTrailer()">
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
                    ${movie.duration} phút
                </h6>
                <button>${movie.ageRating}</button>
            </div>
        </div>
        <div class="film_sumary">
            <h1>Nội dung phim</h1>
            <p>${movie.description}</p>
        </div>
        <div class="trailer" id="trailerContainer" style="display: none;">
            <video width="950" height="500" controls>
            <source src="${movie.trailerUrl}" type="video/mp4">
<%--            Your browser does not support the video tag.--%>
            </video>
            <c:if test="${empty movie.trailerUrl}">
                <p style="color:white;">Thông tin trailer chưa được cập nhập!</p>
            </c:if>
        </div>
        <script>
            function toggleTrailer() {
                var trailerContainer = document.getElementById('trailerContainer');
                if (trailerContainer.style.display === 'none') {
                    trailerContainer.style.display = 'block';
                } else {
                    trailerContainer.style.display = 'none';
                }
            }
        </script>
        <div class="date_type">
            <div class="left_card">
                <h6 class="tittle" style="margin-top: 15px" >Ngày chiếu</h6>
                <div class="card_month">
                    <%--<ul style="list-style: none; display: flex; padding: 0; margin: 0;">--%>
                    <ul style="display: flex; list-style: none; padding: 0;">
                        <c:forEach var="showtimeSame" items="${showtimesSameDate}">
                            <form id="bookingForm" method="GET" action="${pageContext.request.contextPath}/book">
                                <li style="margin-right: 20px; text-align: center;">
                                    <h6>
                                            ${showtimeSame.getDayOfWeek()}
                                    </h6>
                                    <h6
                                            class="clickable"
                                            data-day="${showtimeSame.getDay()}"
                                            data-month="${showtimeSame.getMonth()}">
                                            ${showtimeSame.getDay()}/${showtimeSame.getMonth()}
                                    </h6>
                                </li>
                                <input type="hidden" name="day" id="selectedDay"/>
                                <input type="hidden" name="month" id="selectedMonth"/>
                                <input type="hidden" name="mId" value="${param.mId}"/>
                            </form>
                        </c:forEach>
                    </ul>

                    <!-- Các input ẩn sẽ chứa dữ liệu -->

                    <%--</ul>--%>

                </div>
            </div>
            <div class="right_card">
                <h6 class="tittle">Thời gian</h6>
                <div class="card_month">
                    <ul style="display: flex; list-style: none; padding: 0;">
                        <c:forEach var="showtimeAll" items="${showtimesByDateAndId}">
                            <li style="margin-right: 20px; text-align: center;">
                                <form method="GET" action="${pageContext.request.contextPath}/book">
                                    <h6>2D</h6>
                                    <h6
                                            class="clickableTime"
                                            data-hour="${showtimeAll.getHour()}"
                                            data-minute="${showtimeAll.getMinute()}"
                                            onclick="submitFormWithTime(this, '${showtimeAll.getRoomId()}', ${showtimeAll.getId()})">
                                            ${showtimeAll.getHour()}:${showtimeAll.getMinute()}
                                    </h6>
                                    <input type="hidden" name="hour" id="selectedHour" value="${showtimeAll.getHour()}"/>
                                    <input type="hidden" name="minute" id="selectedMinute" value="${showtimeAll.getMinute()}"/>
                                    <input type="hidden" name="showtimeId" value="${showtimeAll.getId()}">
                                    <input type="hidden" name="roomId" value="${showtimeAll.getRoomId()}"/>
                                    <input type="hidden" name="mId" value="${param.mId}"/>
                                    <input type="hidden" name="day" value="${param.day}"/>
                                    <input type="hidden" name="month" value="${param.month}"/>
                                </form>
                            </li>
                        </c:forEach>
                    </ul>

                    <script>
                        function submitFormWithTime(element, roomId, showtimeId) {
                            const form = element.closest('form'); // Lấy form gần nhất
                            form.querySelector('input[name="roomId"]').value = roomId; // Gán giá trị roomId nếu cần
                            form.querySelector('input[name="showtimeId"]').value = showtimeId; // Gán giá trị roomId nếu cần
                            form.submit(); // Gửi form
                        }
                    </script>
                </div>
            </div>
        </div>
        <div class="screen">
            Screen
        </div>
        <!--chairs-->
        <c:if test="${not empty roomId}">
            <jsp:include page="Rooms/room${roomId}.jsp"/>
        </c:if>

    </div>
</div>
<jsp:include page="Includes/footer.jsp"/>
</body>

</html>