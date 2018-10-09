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
    
    public void searchProduct()
      {
        //readfile();
                System.out.println("------------------------------------------------");
        System.out.println("Enter criteria for searching the product");
        System.out.println("1.Search by product name");
        System.out.println("2.Search by product origin");
        System.out.println("3.Search by product name and origin");
        System.out.println("Please enter your choice - ");
        Scanner s1 = new Scanner(System.in); //taking input from console through console object
        int number = s1.nextInt();
        switch (number)//SWitch case for selecting option
        {
            case 1:
            System.out.println("Enter the product name -");
            String seq = s1.next();
            searchByProdName(seq);
            break;
            case 2:
            System.out.println("Enter the product Origin -");
            String seq1 = s1.next();
            searchByProdOrigin(seq1);
            break;
            case 3:
            System.out.println("Enter the product name -");
            String seq2 = s1.next();
            System.out.println("Enter the product Origin -");
            String seq3 = s1.next();
            searchByBoth(seq2,seq3);
            break;
            default:
            System.out.println("Invalid option");
            break;

        }
      }
      public void searchByProdName(String name)
    {
        String line="";
        ArrayList<String> result = new ArrayList<String>();
        boolean found = false;
        String fileName = "inventory.txt";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) //loop runs till end of file for each line
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                if (content [1].toLowerCase().contains(name.toLowerCase()))
                   {
                       result.add(content [0]+ "," + content [1] + "," + content [2] + "," + content [3] +"," + content [4] + "," + content [5]);
                       found = true;
                    }
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        if (found == true)
             System.out.println(result);
        else if (found == false)
              System.out.println("SORRY!! search result is not found");
        searchProduct();
    }
    
    public void searchByProdOrigin(String origin)
    {
        String line="";
        ArrayList<String> result = new ArrayList<String>();
        boolean found = false;
        String fileName = "inventory.txt";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) //loop runs till end of file for each line
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                if (content [2].toLowerCase().contains(origin.toLowerCase()))
                   {
                       result.add(content [0]+ "," + content [1] + "," + content [2] + "," + content [3] +"," + content [4] + "," + content [5]);
                       found = true;
                    }
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        if (found == true)
             System.out.println(result);
        else if (found == false)
              System.out.println("SORRY!! search result is not found");
        searchProduct();
       }
       public void searchByBoth(String name, String origin)
    {
        String line="";
        ArrayList<String> result = new ArrayList<String>();
        boolean found = false;
        String fileName = "inventory.txt";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) //loop runs till end of file for each line
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                   if (content [1].toLowerCase().contains(name.toLowerCase()) && content [2].toLowerCase().contains(origin.toLowerCase()))
                   {
                       result.add(content [0]+ "," + content [1] + "," + content [2] + "," + content [3] +"," + content [4] + "," + content [5]);
                       found = true;
                    }
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        if (found == true)
             System.out.println(result);
        else if (found == false)
              System.out.println("SORRY!! search result is not found");
        searchProduct();
        }
}
