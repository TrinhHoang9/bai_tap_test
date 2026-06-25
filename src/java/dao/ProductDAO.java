package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import utils.DBUtils;

/**
 * @author Trịnh Hoàng Dũng
 */
public class ProductDAO {
    
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT ProductID, SubCategoryID, Title, OriginalPrice, PromoPrice, CurrentStock, ImageURL FROM Product";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("ProductID"),
                    rs.getInt("SubCategoryID"),
                    rs.getString("Title"),
                    rs.getDouble("OriginalPrice"),
                    rs.getDouble("PromoPrice"),
                    rs.getInt("CurrentStock"),
                    rs.getString("ImageURL")
                );
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}