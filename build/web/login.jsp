<%-- 
    Document   : login
    Created on : Jun 24, 2026, 8:54:41 PM
    Author     : TRINH HOANG DUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập - Nhà Sách</title>
</head>
<body>
    <h2>Đăng Nhập Hệ Thống</h2>
    
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${not empty success}">
        <p style="color: green;">${success}</p>
    </c:if>

    <form action="login" method="POST">
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>
        
        <label>Mật khẩu:</label><br>
        <input type="password" name="password" required><br><br>
        
        <button type="submit">Đăng nhập</button>
    </form>
    <p>Chưa có tài khoản? <a href="register">Đăng ký ngay</a></p>
</body>
</html>