<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết phim</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css'>
    <link rel="stylesheet" href="../Styles/detail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/nav_menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/footer.css">
    <script src="../Script/search.js"></script>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
<div class="book">
    <div class="left">
        <img src="../img/img/jawan.jpg"/>
        <div class="play_bttn">
            <i class="bi bi-play-fill" id="play_bttn"></i>
        </div>
        <div class="infor">
            <h6>Đạo diễn: </h6>
            <p>Atlee</p>
            <h6>Diễn viên chính </h6>
            <p>
                Shah Rukh Khan
                Nayanthara
                Vijay Sethupathi
                Deepika Padukone
            </p>
            <h6>Biên tập bởi</h6>
            <p>Ruben</p>
        </div>
    </div>
    <div class="right">
        <div class="head_time">
            <h1>Jawan</h1>
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
            <p>Jawan kể về Vikram Rathore (do Shah Rukh Khan thủ vai) - một cựu sĩ quan quân đội quyết tâm báo thù kẻ
                thù đã làm gia đình anh tan nát và đấu tranh chống lại tham nhũng. Anh giả danh thành một kẻ khủng bố để
                lật tẩy các quan chức tham nhũng và bảo vệ người dân. Phim đan xen những pha hành động mãn nhãn cùng
                thông điệp về công lý và lòng yêu nước.</p>
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
                <li class="seat" data-row="A" data-seat="15">15</li>
                <li class="seat" data-row="A" data-seat="16">16</li>
                <li class="seat" data-row="A" data-seat="17">17</li>
                <li class="seat" data-row="A" data-seat="18">18</li>
                <li class="seat" data-row="A" data-seat="19">19</li>
                <li class="seat" data-row="A" data-seat="20">20</li>
                <li class="seat" data-row="A" data-seat="21">21</li>
                <li class="seat" data-row="A" data-seat="22">22</li>
                <li class="seat" data-row="A" data-seat="23">23</li>
                <li class="seat" data-row="A" data-seat="24">24</li>
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
        <div class="btn-book">Chưa tới ngày ra mắt</div>
    </div>
</div>

<jsp:include page="Includes/footer.jsp"/>
</body>
</html>