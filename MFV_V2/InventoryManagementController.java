import java.io.*;
import java.util.*;
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
    public boolean addProduct(String name,String origin,String type,String packaging, double price,double discount,int quantity,int shipmentID)
    {
        Product product = new Product();
        product.setProductID(1);//generate product ID.
        product.setProductName(name);
        product.setProductType(type);
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

    public String viewProduct(String productName)
    {
        Product product = null;
        StringBuilder old=new StringBuilder();
        try
        {
            FileReader fileReader = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
            {
                String temp[]=line.split(",");
                if(temp[1].equalsIgnoreCase(productName))
                {
                    //  <Product_ID>,<Prodcut Name>,<product type>,<Product_Origin>,
                    //<type of packaging(weighted,bunch)>,<price per unit>,<discount percent>,<quantity available>,<shipmentID>
                    product = new Product();
                    product.setProductID(Integer.parseInt(temp[0]));
                    product.setProductName(temp[1]);
                    product.setProductType(temp[2]);
                    product.setOrigin(temp[3]);
                    product.setPackaging(temp[4]);
                    product.setPrice(Double.parseDouble(temp[5]));
                    product.setDiscountPrice(Double.parseDouble(temp[6]));
                    product.setQuantity(Integer.parseInt(temp[7]));
                    //shipment ID
                    return product.toString();
                }
            }
            fileReader.close();

        }
        catch(Exception e)
        {

        }
        return "";
    }

    public boolean removeProduct(String productName)
    {
        boolean delete =false;
        StringBuilder old=new StringBuilder();
        try
        {
            FileReader fileReader = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
            {
                String temp[] = line.split(",");
                if(temp[1].equalsIgnoreCase(productName))
                {
                    delete=true;
                    continue;
                }
                old.append(line + System.lineSeparator()); //add all lines in the current version of the file
            }
            fileReader.close();
            PrintWriter writer = new PrintWriter("inventory.txt");
            writer.print(old); //write old lines + new line to the file
            writer.close();
        }
        catch(Exception e)
        {
        }
        return delete;
    }
}