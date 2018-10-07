
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

    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        // initialise instance variables
        cartAmount = 00.00;
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
}
