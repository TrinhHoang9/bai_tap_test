package model;

/**
 * @author Trịnh Hoàng Dũng
 */
public class Account {
    private int accountID;
    private int roleID;
    private String fullName;
    private String email;
    private String password; // Trong thực tế là PasswordHash
    private String phone;
    private boolean status;

    public Account() {
    }

    public Account(int accountID, int roleID, String fullName, String email, String password, String phone, boolean status) {
        this.accountID = accountID;
        this.roleID = roleID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
    }

    // Getters and Setters
    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    public int getRoleID() { return roleID; }
    public void setRoleID(int roleID) { this.roleID = roleID; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}