<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lịch sử</title>
    <link rel="stylesheet" href="../Styles/history.css">
    <link rel="stylesheet" href="../Styles/nav_menu.css">
    <link rel="stylesheet" href="../Styles/left-menu.css">
    <script src="../Script/search.js"></script>
</head>
<body>
<div class="nav-menu" style="padding-top: 0">
    <div class="lelf-menu">
        <a href="../index.jsp">
            <img id="logo-cinema" src="../img/img/Logo_tachnen.jpg" alt="Cinema Logo"/>
        </a>
    </div>
    <div class="right-menu">
        <input type="text" id="movie-name" name="movie-name" placeholder="Nhập tên phim" onkeypress="redirectToPage(event)" >
        <a href="" class="menu">Phim</a>
        <a href="" class="menu">Giá vé</a>
        <a href="" class="menu">Đăng nhập</a>
        <a href="user-infor.jsp">
            <img src="../img/img/user.jpg" height="30" width="30"/>
        </a>
    </div>
</div>
<div class="leftmenu" style="height: 1200px; padding-top: 4%">
    <a href="user-infor.jsp" class="op-infor">Thông tin</a>
    <a href="user-updateInfor.jsp" class="op-update">Chỉnh sửa</a>
    <a href="history.html" class="op-history open">Lịch sử</a>
    <a href="" id="out">Đăng xuất</a>

</div>
<div class="history">
    <div class="title">
        <h1>LỊCH SỬ ĐẶT VÉ</h1>
    </div>
    <div class="t1">
        <h2>VÉ PHIM</h2>
    </div>
    <div class="ticket">
        <div class="tic">
            <div class="detail">
                <div class="card">
                    <h6>HÀNG J</h6>
                    <h6>NGÀY 28 THÁNG 8 NĂM 2024</h6>
                </div>
                <div class="card">
                    <h6>Ghế 10</h6>
                    <h6>23:00</h6>
                </div>
                <svg id="barcode"></svg>
            </div>
            <div class="ticket-detail">
                <div class="type">2D</div>
                <h5 class="pvr">LTW <span>CINEMA</span></h5>
                <h1>JAWAN</h1>
                <div class="seat-detail">
                    <div class="seat-cr">
                        <h6>PHÒNG</h6>
                        <h6>1</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>HÀNG</h6>
                        <h6>J</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>GHẾ</h6>
                        <h6>18</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>NGÀY</h6>
                        <h6>28 <sub>tháng 7</sub></h6>
                    </div>
                    <div class="seat-cr">
                        <h6>THỜI GIAN</h6>
                        <h6>23:00</h6>
                    </div>
                </div>
            </div>
        </div>
        <div class="tic">
            <div class="detail">
                <div class="card">
                    <h6>HÀNG J</h6>
                    <h6>NGÀY 28 THÁNG 8 NĂM 2024</h6>
                </div>
                <div class="card">
                    <h6>Ghế 10</h6>
                    <h6>23:00</h6>
                </div>
                <svg id="barcode"></svg>
            </div>
            <div class="ticket-detail">
                <div class="type">2D</div>
                <h5 class="pvr">LTW <span>CINEMA</span></h5>
                <h1>JAWAN</h1>
                <div class="seat-detail">
                    <div class="seat-cr">
                        <h6>PHÒNG</h6>
                        <h6>1</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>HÀNG</h6>
                        <h6>J</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>GHẾ</h6>
                        <h6>18</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>NGÀY</h6>
                        <h6>28 <sub>tháng 7</sub></h6>
                    </div>
                    <div class="seat-cr">
                        <h6>THỜI GIAN</h6>
                        <h6>23:00</h6>
                    </div>
                </div>
            </div>
        </div>
        <div class="tic">
            <div class="detail">
                <div class="card">
                    <h6>HÀNG J</h6>
                    <h6>NGÀY 28 THÁNG 8 NĂM 2024</h6>
                </div>
                <div class="card">
                    <h6>Ghế 10</h6>
                    <h6>23:00</h6>
                </div>
                <svg id="barcode"></svg>
            </div>
            <div class="ticket-detail">
                <div class="type">2D</div>
                <h5 class="pvr">LTW <span>CINEMA</span></h5>
                <h1>JAWAN</h1>
                <div class="seat-detail">
                    <div class="seat-cr">
                        <h6>PHÒNG</h6>
                        <h6>1</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>HÀNG</h6>
                        <h6>J</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>GHẾ</h6>
                        <h6>18</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>NGÀY</h6>
                        <h6>28 <sub>tháng 7</sub></h6>
                    </div>
                    <div class="seat-cr">
                        <h6>THỜI GIAN</h6>
                        <h6>23:00</h6>
                    </div>
                </div>
            </div>
        </div>
        <div class="tic">
            <div class="detail">
                <div class="card">
                    <h6>HÀNG J</h6>
                    <h6>NGÀY 28 THÁNG 8 NĂM 2024</h6>
                </div>
                <div class="card">
                    <h6>Ghế 10</h6>
                    <h6>23:00</h6>
                </div>
                <svg id="barcode"></svg>
            </div>
            <div class="ticket-detail">
                <div class="type">2D</div>
                <h5 class="pvr">LTW <span>CINEMA</span></h5>
                <h1>JAWAN</h1>
                <div class="seat-detail">
                    <div class="seat-cr">
                        <h6>PHÒNG</h6>
                        <h6>1</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>HÀNG</h6>
                        <h6>J</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>GHẾ</h6>
                        <h6>18</h6>
                    </div>
                    <div class="seat-cr">
                        <h6>NGÀY</h6>
                        <h6>28 <sub>tháng 7</sub></h6>
                    </div>
                    <div class="seat-cr">
                        <h6>THỜI GIAN</h6>
                        <h6>23:00</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="t1">
        <h2>VÉ ĐỒ ĂN</h2>
    </div>
    <div class="ticket-food">
        <div class="tic">
            <div class="detail">
                <div class="card">
<!--                    <h6>Combo 1: 0</h6>-->
                    <h6>Combo 2: 3</h6>
                    <h6>Combo 3: 2</h6>
                </div>
            </div>
            <div class="ticket-img">

                <img src="../img/img/food.jpg" height="294" width="736"/></div>
        </div>
        <div class="tic">
            <div class="detail">
                <div class="card">
<!--                    <h6>Combo 1: 0</h6>-->
                    <h6>Combo 2: 3</h6>
                    <h6>Combo 3: 2</h6>
                </div>
            </div>
            <div class="ticket-img">

                <img src="../img/img/food.jpg" height="294" width="736"/></div>
        </div>
        <div class="tic">
            <div class="detail">
                <div class="card">
<!--                    <h6>Combo 1: 0</h6>-->
                    <h6>Combo 2: 3</h6>
                    <h6>Combo 3: 2</h6>
                </div>
            </div>
            <div class="ticket-img">

                <img src="../img/img/food.jpg" height="294" width="736"/></div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jsbarcode/3.11.6/JsBarcode.all.js"
        integrity="sha512-wkHtSbhQMx77jh9oKL0AlLBd15fOMoJUowEpAzmSG5q5Pg9oF+XoMLCitFmi7AOhIVhR6T6BsaHJr6ChuXaM/Q=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>JsBarcode("#barcode", "428151414998");
</script>
</body>
</html>