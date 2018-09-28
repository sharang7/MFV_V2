import java.util.*;
import java.io.*;
/**
 * Write a description of class SystemController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SystemController
{
    // instance variables - replace the example below with your own
    private User user;
    /**
     * Constructor for objects of class SystemController
     */
    public SystemController()
    {
        // initialise instance variables
        //user = new User();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean registerNewCustomer(String userName,String password,String email,String questions[],String answers[],String customerAddress,
    boolean disableProfile)
    {
        Customer customer=new Customer(userName,password,email,questions,answers,customerAddress,disableProfile);
        boolean result = writeUserDatabase(customer.getUserName(),customer.getUserPassword(),customer.getEmail(),customer.getQuestions(),customer.getAnswers()
        ,customer.getAddress(),customer.getDisableProfile());
        return result;
    }
    public boolean confirmationForLogin(String username,String password)
    {
        
        return true;
    }
    public void editProfile(int id, boolean answer)
    {
    }
    public String searchProduct(int id)
    {
        String name="";
        return name;
    }
    public HashMap<String,String> readUserDatabase(String fileName)
    {
        HashMap<String,String> credentials = new HashMap<>();
        String line="";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                credentials.put(content[0],content[1]);
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return credentials;
    }
    public boolean writeUserDatabase(String userName,String password,String email,String questions[],String answers[],String customerAddress,
    boolean disableProfile)
    {
        try
        {
            PrintWriter writer = new PrintWriter("user_db.txt");
            writer.println(userName+","+password.hashCode()+","+email+","+questions[0]+","+questions[1]+","+answers[0]+","+
            answers[1]+","+disableProfile);
            writer.close();
            return true;
        }
        catch(Exception e)
        {
        }
        return false;
    }
    //editCart()
    //checkout(int,int):String
    //viewTransaction(int):String
    //fetchProduct(String):Product
}
