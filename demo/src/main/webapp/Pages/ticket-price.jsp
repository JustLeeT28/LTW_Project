<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <style>
        .bang-gia-ve-title {
            text-align: center;
            font-size: 2.5em;
            margin-top: 120px;
            color: white;
            margin-bottom: 50px;

        }

        .bang-gia-ve-table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            font-size: 1.2em;
            margin-bottom: 200px;
        }

        .bang-gia-ve-table th, .bang-gia-ve-table td {
            border: 1px solid #202020;
            padding: 12px;
            text-align: center;
        }

        .bang-gia-ve-table th {
            background-color: #85e3b3;
            font-weight: bold;
        }

        .bang-gia-ve-table tr:nth-child(even), .bang-gia-ve-table tr:nth-child(odd) {
            background-color: #fff;
        }

        .bang-gia-ve-table tr:hover {
            background-color: #ddd;
        }


    </style>
</head>
<body>
<jsp:include page="Includes/menu.jsp"/>
    <h1 class="bang-gia-ve-title"><strong>Bảng Giá Vé</strong></h1>
    <table class="bang-gia-ve-table">
        <thead>
        <tr>
            <th>Loại Phòng</th>
            <th>Giá Vé (VNĐ)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>2D</td>
            <td>${price2D} VNĐ</td>
        </tr>
        <tr>
            <td>3D</td>
            <td>${price3D} VNĐ</td>
        </tr>
        <tr>
            <td>Imax</td>
            <td>${priceImax} VNĐ</td>
        </tr>
        <tr>
            <td>4Dx</td>
            <td>${price4D} VNĐ</td>
        </tr>
        </tbody>
    </table>
    </body>
    </html>
</div>
<jsp:include page="Includes/footer.jsp"/>
</body>
</html>