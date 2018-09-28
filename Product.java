
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private int productID;
    private String productName;
    private double price;
    private String packaging;
    private String purchaseMethod;
    private double discountPrice;
    private String productType;
    // private String weight;
    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        // initialise instance variables
        productID = 0;
        productName = new String();
        price = 0;
        packaging = new String();
        purchaseMethod = new String();
        discountPrice = 0;
        productType = new String();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setProductID(int id)
    {
        // put your code here
        productID = id;
    }
    public int getProductID()
    {
        return productID;
    }
    public void setProducName(String name)
    {
        // put your code here
        productName = name;
    }
    public String getProductName()
    {
        return productName;
    }
    public void setPrice(double cost)
    {
        // put your code here
        price = cost;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPackaging(String packag)
    {
        // put your code here
        packaging = packag;
    }
    public String getPackaging()
    {
        return packaging;
    }
    public void setPurchaseMethod(String purchMethod)
    {
        // put your code here
        purchaseMethod = purchMethod;
    }
    public String getPurchaseMethod()
    {
        return purchaseMethod;
    }
    public void setDiscountPrice(double discount)
    {
        // put your code here
        discountPrice = discount;
    }
    public double getDiscountPrice()
    {
        return discountPrice;
    }
    public void setProductType(String type)
    {
        // put your code here
        productType = type;
    }
    public String getProductType()
    {
        return productType;
    }
}
