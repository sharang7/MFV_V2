
/**
 * a description of class UserInterface:
 * It is a class to deal with Custmers of MFV 
 * @author (Shararng, Gauri,Najma,Hala)
 * @version (3)
 */
public class Customer extends User
{
    private String customerAddress;
    private boolean disableProfile;
    private Cart cart;
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userName,String password,String email,String questions[],String answers[],String customerAddress,
    boolean disableProfile)
    {
        super(userName,password,email,questions,answers);
        this.customerAddress = customerAddress;
        this.disableProfile = disableProfile;
        cart = new Cart();
    }

    /**
     * It is a method to save customer's address
     *
     * @param  address
     * @ no return
     */
    public void setAddress(String address)
    {
        customerAddress = address;
    }
    
    /**
     * It is a method to return customer's address
     *
     * @ no param  
     * @ return the address
     */    
    public String getAddress()
    {
        return customerAddress;
    }
    
    /**
     * It is a method to set the option of disable profile
     *
     * @param  profile stae
     * @ no return
     */
    public void setDisableProfile(boolean profileState)
    {
        disableProfile = profileState;
    }
    
    /**
     * It is a method to get the state of a profile
     *
     * @ no param 
     * @ return the state
     */
    public boolean getDisableProfile()
    {
        return disableProfile;
    }
    
    /**
     * It is a method to set a cart
     *
     * @param  new cart
     * @ no return
     */
    public void setCart( Cart newCart)
    {
        cart = newCart;
    }
    
    /**
     * It is a method to obtain the cart
     *
     * @ no param
     * @ return the cart
     */
    public Cart getCart()
    {
        return cart;
    }
}
