import java.util.*;
import java.io.*;
/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    // instance variables - replace the example below with your own
    private double cartAmount;
    private HashMap<Integer,Integer> cartContents;
    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        // initialise instance variables
        cartAmount = 0;
        cartContents = new HashMap<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setCartAmount(double amount)
    {
        cartAmount = amount;
    }
    
    public double getCartAmount()
    {
        return cartAmount;
    }
    
    public boolean addProduct(int addnumber)
    {
        return true;
    }
    
    
    public boolean removeProduct(int removenumber)
    {
        return false;
    }
    
    public HashMap<Integer,Integer> getCartContents()
    {
        return cartContents;
    }
    
    public void setCartContents(HashMap<Integer,Integer> cartContents)
    {
        this.cartContents = cartContents;
    }
    
    public double calculateCartValue()
    {
        String line="";
        try
        {
           FileReader fileReader = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            { 
                if(cartContents.keySet().contains(Integer.parseInt(line.split(",")[0])))
                {
                    String contents[]=line.split(",");
                    cartAmount=cartAmount+((Double.parseDouble(contents[4])-(Double.parseDouble(contents[4])*Double.parseDouble(contents[5])))*cartContents.get(Integer.parseInt(line.split(",")[0])));
                }
            }
        }
        catch(Exception e)
        {
        }
        return cartAmount;
    }
}
