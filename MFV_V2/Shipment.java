import java.util.*;
/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
    // instance variables - replace the example below with your own
    private int shipmentId;
    private Date expiry_Date;
    //private Product productId; 
    
    /**
     * Constructor for objects of class Shipment
     */
    public Shipment()
    {
        // initialise instance variables
        shipmentId = 0;
        //productId = new Product();
        expiry_Date = new Date(); 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setShipmentId(int shipId)
    {
        shipmentId = shipId;
    }
    public int getShipmentId()
    {
        return shipmentId;
    }
    public void setExpiryDate(Date date)
    {
        expiry_Date = date;
    }
    public Date getExpiryDate()
    {
        return expiry_Date;
    }
   /* public void setProductId(Product proId)
    {
        productId = proId;
    }
    public Product getProductd()
    {
        return productId;
    }*/
}
