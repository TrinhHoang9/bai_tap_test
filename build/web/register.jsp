<%-- 
    Document   : register
    Created on : Jun 24, 2026, 8:55:26 PM
    Author     : TRINH HOANG DUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký Tài Khoản</title>
</head>
<body>
    <h2>Đăng Ký Thành Viên Nhà Sách</h2>
    
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <form action="register" method="POST">
        <label>Họ và tên *:</label><br>
        <input type="text" name="fullName" required><br><br>
        
        <label>Email *:</label><br>
        <input type="email" name="email" required><br><br>
        
        <label>Mật khẩu *:</label><br>
        <input type="password" name="password" required><br><br>
        
        <label>Số điện thoại:</label><br>
        <input type="text" name="phone"><br><br>
        
        <button type="submit">Đăng ký</button>
    </form>
    <p>Đã có tài khoản? <a href="login">Đăng nhập</a></p>
</body>
</html>