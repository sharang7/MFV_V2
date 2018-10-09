import java.util.*;
import java.io.*;
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
    private int productId; 
    
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
    public void setProductId(int proId)
    {
        productId = proId;
    }
    public int getProductd()
    {
        return productId;
    }
    
    public String toString()
    {
        return shipmentId+","+expiry_Date+","+productId;
    }
    
    public int getNewShipmentID()
    {
        int id=1;
        try
        {
            FileReader fileReader = new FileReader("shipment_list.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
                {
                    id=Integer.parseInt(line.split(",")[0]);
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return id+1;
    }
}
