<%-- 
    Document   : home
    Created on : Jun 24, 2026, 5:12:38 PM
    Author     : TRINH HOANG DUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ Nhà Sách</title>
</head>
<body>
    <h1>Danh sách Sản phẩm</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Giá bán</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listP}" var="o">
                <tr>
                    <td>${o.productID}</td>
                    <td><img src="${o.imageURL}" width="100" height="100"></td>
                    <td>${o.title}</td>
                    <td>${o.promoPrice} đ</td>
                    <td>
                        <a href="cart?action=add&id=${o.productID}">Thêm vào giỏ</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>