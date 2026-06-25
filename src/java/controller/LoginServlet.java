package controller;

import dao.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 * @author Trịnh Hoàng Dũng
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng tới trang giao diện đăng nhập
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Validation cơ bản (Không bỏ trống)
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Email và mật khẩu không được để trống!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        AccountDAO dao = new AccountDAO();
        Account acc = dao.login(email, password);

        if (acc != null) {
            // Đăng nhập thành công -> Lưu vào HttpSession
            HttpSession session = request.getSession();
            session.setAttribute("USER", acc);
            
            // Chuyển hướng dựa theo vai trò (Role ID)
            if (acc.getRoleID() == 1 || acc.getRoleID() == 2) {
                response.sendRedirect("admin-dashboard"); // Trang quản trị (Staff/Admin)
            } else {
                response.sendRedirect("home"); // Trang chủ (Customer)
            }
        } else {
            // Thất bại
            request.setAttribute("error", "Tài khoản hoặc mật khẩu không chính xác!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}