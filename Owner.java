import java.util.ArrayList;
/**
 * Write a description of class Onwer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owner extends User
{
    // instance variables - replace the example below with your own
    private ArrayList<Transaction> transactionList;
     
    /**
     * Constructor for objects of class Onwer
     */
    public Owner(String userName,String password,String email,String questions[],String answers[])
    {
        // initialise instance variables
        super(userName,password,email,questions,answers);
        transactionList = new ArrayList<Transaction>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void viewAllTransactions()
    {
        System.out.println("Transactions list:");
        for(int count=0; count < transactionList.size(); count++)
        {
            System.out.println(transactionList.get(count));
        }
    }
    public void deletCustomerProfile(Customer custmerInfor)
    {
        
    }
}
