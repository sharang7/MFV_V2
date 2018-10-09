 
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own
    private String customerAddress;
    private boolean disableProfile;
    private Cart cart;
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userName,String password,String email,String customerAddress,String questions[],String answers[],
    boolean disableProfile)
    {
        // initialise instance variables
        super(userName,password,email,questions,answers);
        this.customerAddress = customerAddress;
        this.disableProfile = disableProfile;
        cart = new Cart();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setAddress(String address)
    {
        customerAddress = address;
    }
    
    public String getAddress()
    {
        return customerAddress;
    }
    
    public void setDisableProfile(boolean profileState)
    {
        disableProfile = profileState;
    }
    
    public boolean getDisableProfile()
    {
        return disableProfile;
    }
    
    public void setCart( Cart newCart)
    {
        cart = newCart;
    }
    
    public Cart getCart()
    {
        return cart;
    }
    
    public boolean addToCart(String addProduct)
    {
        return true;
    }
    
    
    public boolean removeFromCart(int removeProduct)
    {
        return false;
    }
}
