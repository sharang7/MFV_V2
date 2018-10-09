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
    ArrayList<String> list;
    ArrayList<String> searchList;

    /**
     * Constructor for objects of class InventoryManagementController
     */
    public InventoryManagementController()
    {
                list = new ArrayList<String>();
        searchList = new ArrayList<String>();
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean addProduct(String name,String origin,String packaging, double price,double discount,int quantity,int shipmentID)
    {
       
        Product product = new Product();
        product.setProductID(1);//generate product ID.
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
    
    public void readfile()
    {
        String filename = ("product.txt");
        String line = null;
        String[] lines = null;

        try
        {
            /* FileReader reads text files in the default encoding */
            FileReader fileReader = new FileReader(filename);

            /* always wrap the FileReader in BufferedReader */
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lines = line.split(",");
                list.add(new String(lines[0]));
                list.add(new String(lines[1]));
                //System.out.println(line);
                i++;
            }
            for (i=0;i<list.size();i++)
               // System.out.println(list.get(i));
            bufferedReader.close();
            searchCriteria();
        }
        catch(Exception e)
        {
            System.out.println("Error Reading File");
        }

    }
    
     public void searchCriteria()
    {
        //readfile();
                System.out.println("------------------------------------------------");
        System.out.println("Enter criteria for searching the product");
        System.out.println("1.Search by product name");
        System.out.println("2.Search by product origin");
        System.out.println("3.Search by product name and origin");
        System.out.println("Please enter your choice - ");
        Scanner s1 = new Scanner(System.in); //taking input from console through console object
        int name = s1.nextInt();

        switch (name)//SWitch case for selecting option
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

    public void searchByProdName(String seq)
    {
        for (int i=0;i<list.size();i++)
        {

            if(i % 2 == 0)
            {
                // System.out.println(list.get(i));

                String test = list.get(i); 
                boolean bool = (test.toLowerCase()).contains(seq.toLowerCase()); 
                if(bool == true)
                    System.out.println(list.get(i)+","+list.get(i+1));
            }
            
            if(i % 2 != 0)
            {
                continue;
            }
        }
        searchCriteria();
    }

    public void searchByProdOrigin(String seq)
    {
        for (int i=0;i<list.size();i++)
        {

            if(i % 2 != 0)
            {
                // System.out.println(list.get(i));

                String test = list.get(i); 
                boolean bool = (test.toLowerCase()).contains(seq.toLowerCase()); 
                if(bool == true)
                    System.out.println(list.get(i-1)+","+list.get(i));
            }
            
            if(i % 2 == 0)
            {
                continue;
            }
        }
        searchCriteria();
    }
    
    public void searchByBoth(String seq, String seq1)
    {
        for (int i=0;i<list.size();i++)
        {

            //String test = list.get(i); 
            //boolean bool = (test.toLowerCase()).contains(seq.toLowerCase()); 
                             //boolean bool1 = (test.toLowerCase()).contains(seq1.toLowerCase()); 
                             
             if(i % 2 == 0)
            {
                // System.out.println(list.get(i));

                String test = list.get(i); 
                boolean bool = (test.toLowerCase()).contains(seq.toLowerCase()); 
                if(bool == true)
                    System.out.println(list.get(i)+","+list.get(i+1));
            }
            
            if(i % 2 != 0)
            {
                continue;
            }
        }
        
        for (int j=0;j<list.size();j++)
        {
            if(j % 2 != 0)
            {
                // System.out.println(list.get(i));

                String test = list.get(j); 
                boolean bool = (test.toLowerCase()).contains(seq1.toLowerCase()); 
                if(bool == true)
                    System.out.println(list.get(j-1)+","+list.get(j));
            }
            
            if(j % 2 == 0)
            {
                continue;
            }
        }                   
            //boolean bool = (test.toLowerCase()).contains(seq.toLowerCase()); 

 //if(bool == true && i % 2 != 0)
              //  System.out.println(list.get(i-1)+","+list.get(i));
            //if(bool == true && i % 2 == 0 )
              //  System.out.println(list.get(i)+","+list.get(i+1));
             
        searchCriteria();
            
        }

    

    public void searchProduct()
    {
        readfile();
    }
}
