package model;

/**
 * @author Trịnh Hoàng Dũng
 */
public class Product {
    private int productID;
    private int subCategoryID;
    private String title;
    private double originalPrice;
    private double promoPrice;
    private int currentStock;
    private String imageURL;

    public Product() {
    }

    public Product(int productID, int subCategoryID, String title, double originalPrice, double promoPrice, int currentStock, String imageURL) {
        this.productID = productID;
        this.subCategoryID = subCategoryID;
        this.title = title;
        this.originalPrice = originalPrice;
        this.promoPrice = promoPrice;
        this.currentStock = currentStock;
        this.imageURL = imageURL;
    }

    
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getPromoPrice() { return promoPrice; }
    public void setPromoPrice(double promoPrice) { this.promoPrice = promoPrice; }
    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
}