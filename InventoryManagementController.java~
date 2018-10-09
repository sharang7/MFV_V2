import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  
/**
 * Write a description of class InventoryManagementController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InventoryManagementController
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class InventoryManagementController
     */
    public InventoryManagementController()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean addProduct(String expiryDate,String name,String origin,String packaging, double price,double discount,int quantity)
    throws Exception
    {
        Date expiry_Date=new SimpleDateFormat("dd/MM/yyyy").parse(expiryDate);
        Product product = new Product();
        int productID=product.getNewProductID();
        System.out.print(productID);
        product.setProductID(productID);//generate product ID.
        int shipmentID=product.addShipment(expiry_Date,productID);
        product.setShipmentID(shipmentID);
        product.setProductName(name);
        product.setOrigin(origin);
        product.setPackaging(packaging);
        product.setPrice(price);
        product.setDiscountPrice(discount);
        product.setQuantity(quantity);
        StringBuilder old=new StringBuilder(); //to store current contents of the file
        try
        {
            FileReader fileReader = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
                old.append(line + System.lineSeparator()); //add all lines in the current version of the file
            PrintWriter writer = new PrintWriter("inventory.txt");
            old.append(product.toString()+"\n"); //append the new line to the current lines
            writer.print(old); //write old lines + new line to the file
            writer.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
        
    public boolean searchProduct(String name,String origin)
    {
        Product p1= new Product();
        p1.setProductName(name);
        p1.setOrigin(origin);
        return true;
    }
}
