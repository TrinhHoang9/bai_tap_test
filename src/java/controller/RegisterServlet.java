package controller;

import dao.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 * @author Trịnh Hoàng Dũng
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        // Validation dữ liệu đầu vào
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Vui lòng điền đầy đủ các thông tin bắt buộc!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        AccountDAO dao = new AccountDAO();
        
        // Kiểm tra trùng lặp email
        if (dao.checkEmailExist(email)) {
            request.setAttribute("error", "Email này đã được sử dụng!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        Account newAcc = new Account(0, 3, fullName, email, password, phone, true);
        boolean isSuccess = dao.register(newAcc);

        if (isSuccess) {
            request.setAttribute("success", "Đăng ký thành công! Vui lòng đăng nhập.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Hệ thống gặp lỗi, vui lòng thử lại sau!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}