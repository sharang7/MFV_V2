import java.util.*;
import java.io.*;
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
    private String origin;
    private double discountPrice;
    private String productType;
    private int quantity;
    private int shipmentID;
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
        origin = new String();
        discountPrice = 0;
        productType = new String();
        quantity=0;
        shipmentID=0;
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
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return quantity;
    }
    
    public int getProductID()
    {
        return productID;
    }
    public void setProductName(String name)
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
    public void setOrigin(String origin)
    {
        // put your code here
        this.origin = origin;
    }
    public String getOrigin()
    {
        return origin;
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
    
    public void setShipmentID(int id)
    {
        this.shipmentID=id;
    }
    
    public int getShipmentID()
    {
        return shipmentID;
    }
    
    public String toString()
    {
        return productID+","+productName+","+origin+","+packaging+","+price+","+discountPrice+","+quantity+","+"10"+shipmentID;
    }
    
    public int addShipment(Date expiryDate,int productID)
    {
        Shipment shipment= new Shipment();
        int id=shipment.getNewShipmentID();
        shipment.setShipmentId(id);
        shipment.setExpiryDate(expiryDate);
        shipment.setProductId(productID);
        StringBuilder old=new StringBuilder();
        try
        {
            FileReader fileReader = new FileReader("shipment_list.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
                old.append(line + System.lineSeparator()); //add all lines in the current version of the file
            PrintWriter writer = new PrintWriter("shipment_list.txt");
            old.append(shipment.toString());
            System.out.println(shipment.toString());
            writer.print(old.toString());
            writer.close();
        }
        catch(Exception e)
        {
        }
        return id;
    }
    
    public int getNewProductID()
    {
        int id=1;
        try
        {
            FileReader fileReader = new FileReader("inventory.txt");
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
