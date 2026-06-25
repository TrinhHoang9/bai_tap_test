package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;
import utils.DBUtils;

/**
 * @author Trịnh Hoàng Dũng
 */
public class AccountDAO {

    // Hàm kiểm tra Đăng nhập
    public Account login(String email, String password) {
        String sql = "SELECT * FROM Account WHERE Email = ? AND PasswordHash = ? AND Status = 1";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, password); // Để đơn giản tạm thời lưu text thuần, đồ án có thể dùng MD5/SHA-256
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                        rs.getInt("AccountID"),
                        rs.getInt("RoleID"),
                        rs.getNString("FullName"),
                        rs.getString("Email"),
                        rs.getString("PasswordHash"),
                        rs.getString("Phone"),
                        rs.getBoolean("Status")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hàm kiểm tra Email đã tồn tại chưa (Validation trùng lặp)
    public boolean checkEmailExist(String email) {
        String sql = "SELECT AccountID FROM Account WHERE Email = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Hàm Đăng ký tài khoản mới (Mặc định RoleID = 3 cho Customer)
    public boolean register(Account acc) {
        String sql = "INSERT INTO Account (RoleID, FullName, Email, PasswordHash, Phone, Status) VALUES (3, ?, ?, ?, ?, 1)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setNString(1, acc.getFullName());
            ps.setString(2, acc.getEmail());
            ps.setString(3, acc.getPassword());
            ps.setString(4, acc.getPhone());
            
            int row = ps.executeUpdate();
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}