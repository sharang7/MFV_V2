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
    private Customer customer;
    /**
     * Constructor for objects of class SystemController
     */
    public SystemController()
    {
        // initialise instance variables
        //user = new User();
        //cust = new Customer();
    }

    /**
     * This method gets details of a new customer from the boundary class and calls writeUserDataBase()
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean registerNewCustomer(String userName,String password,String email,String questions[],String answers[],String customerAddress,
    boolean disableProfile)
    {
        customer=new Customer(userName,password,email,customerAddress,questions,answers,disableProfile);
        boolean result = writeUserDatabase(customer.getUserName(),customer.getUserPassword(),customer.getEmail(),customer.getQuestions(),customer.getAnswers()
        ,((Customer)customer).getAddress(),((Customer)customer).getDisableProfile());
        return result;
    }
    
    /**
     * This method validates credentials entered by the user against those stored in MFV database.
     */
    public String confirmationForLogin(String userName,String password)
    {
        HashMap<String,String[]> credentials = readUserDatabase("user_db.txt");
        if(credentials.keySet().contains(userName))
            if(credentials.get(userName)[0].equals(Integer.toString(password.hashCode()))&&credentials.get(userName)[1]!="false")
                {
                    String line="";
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            {
                if(userName.equals(line.split(",")[0]))
                {
                    String content[]=line.split(",");
                    String questions[]=new String[2];
                    String answers[]=new String[2];
                    questions[0]=content[4];
                    questions[1]=content[5];
                    answers[0]=content[6];
                    answers[1]=content[7];
                    customer = new Customer(content[0],content[1],content[2],content[3],questions,answers,Boolean.parseBoolean(content[7]));
                }
            }
            return "Valid";
                }
                    catch(Exception e)
                    {
                        return "";
                    }
                }
            else
                return "Incorrect Password";
        else
            return "User does not exist";

    }
    
    public HashMap<String,String> checkSecurityQuestions(String userName)
    {
        HashMap<String,String> questions = readSecurityQuestions(userName);
        return questions;
        
    }
    
    public boolean editProfile(int index, String userName, String newValue)
    {
        String line="";
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String old="";
            String newLine="";
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(",");
                if(content[0].equals(userName))
                {
                    if(index == 2)
                    {
                        content[2] = newValue;
                        System.out.print("Your Email has changed successfully");
                    }
                    else if (index == 3)
                    {
                        content[3] = newValue;
                        System.out.print("Your address has changed successfully");
                    }
                    else if (index == 8)
                    {
                        content[8] = newValue;
                        System.out.print("Your account has disactivated");
                    }
                    for(int i=0;i<content.length;i++)
                        if(i==0)
                            newLine=userName;
                            else
                                newLine=newLine+","+content[i];
                    old=old+newLine+System.lineSeparator();
                }
                else
                    old=old+line+System.lineSeparator();
            }
            fileReader.close();
            PrintWriter writer = new PrintWriter("user_db.txt");
            writer.print(old);
            writer.close();
        }
        catch(Exception e)
        {
        }
        return true;
    }
    
    public String searchProduct(int id)
    {
        String name="";
        return name;
    }
    
    /**
     * Method used to check if a user exists and is an active user of MFV.
     */
    public HashMap<String,String[]> readUserDatabase(String fileName)
    {
        HashMap<String,String[]> credentials = new HashMap<>();
        String line="";
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) //loop runs till end of file for each line
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                String cred[] = new String[2]; 
                cred[0] = content[1];
                cred[1] = content[7];
                credentials.put(content[0],cred);
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return credentials;
    }
    
    public HashMap<String,String> readSecurityQuestions(String userName)
    {
        HashMap<String,String> questions = new HashMap<>();
        String line="";
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                if(content[0].equals(userName))
                {
                questions.put(content[4],content[6]);
                questions.put(content[5],content[7]);
            }
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return questions;
    }
    
    public boolean writeUserDatabase(String userName,String password,String email,String questions[],String answers[],String customerAddress,
    boolean disableProfile)
    {
        StringBuilder old=new StringBuilder(); //to store current contents of the file
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line="";
            while(((line=br.readLine())!=null))
                old.append(line + System.lineSeparator()); //add all lines in the current version of the file
            PrintWriter writer = new PrintWriter("user_db.txt");
            old.append(userName+","+password.hashCode()+","+email+","+customerAddress+","+questions[0]+","+questions[1]+","+answers[0]+","+
            answers[1]+","+disableProfile); //append the new line to the current lines
            writer.print(old); //write old lines + new line to the file
            writer.close();
            return true;
        }
        catch(Exception e)
        {
        }
        return false;
    }
    public boolean updateUserData(int index,String userName,String newValue)
    {
        String line="";
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String old="";
            String newLine="";
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(",");
                if(content[0].equals(userName))
                {
                    if(index==1)
                        content[1]=Integer.toString(newValue.hashCode());
                    else
                        content[index]=newValue;
                    for(int i=0;i<content.length;i++)
                        if(i==0)
                            newLine=userName;
                            else
                                newLine=newLine+","+content[i];
                    old=old+newLine+System.lineSeparator();
                }
                else
                    old=old+line+System.lineSeparator();
            }
            fileReader.close();
            PrintWriter writer = new PrintWriter("user_db.txt");
            writer.print(old);
            writer.close();
        }
        catch(Exception e)
        {
        }
        return true;
    }
    
    public ArrayList<String> viewAllTransactions()
    {
        ArrayList<String> transactions = new ArrayList<>();
        String line="";
        try
        {
           FileReader fileReader = new FileReader("transactions.txt");
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            { 
                transactions.add(line);
            }
        }
        catch(Exception e)
        {
        }
        return transactions;
    }
    
    public ArrayList<String> viewTransactions(String userName)
    {
        ArrayList<String> transactions = new ArrayList<>();
        String line="";
        try
        {
           FileReader fileReader = new FileReader("transactions.txt");
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null)
            { 
                if(line.split(",")[1].equals(userName))
                    transactions.add(line);
            }
        }
        catch(Exception e)
        {
        }
        return transactions;
    }
    
    public boolean addToCart(int id,int quantity)
    { 
       HashMap<Integer,Integer> cart = customer.getCart().getCartContents();
        //HashMap<Integer,Integer> cart =new HashMap<>();
        cart.put(id,quantity);
        customer.getCart().setCartContents(cart);
        //System.out.println("Product added to the cart");
        return true;
    }
    
    public boolean removeFromCart(int id,int quantity)
    {
        
        return true;
    }
    public ArrayList<String> viewCart ()
    {
        HashMap<Integer,Integer> cart = customer.getCart().getCartContents();
        String line="";
        ArrayList<String> result = new ArrayList<String>();
        String fileName = "inventory.txt";
        
        for (int id: cart.keySet())
        {
            try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) //loop runs till end of file for each line
            {
                String content [] = line.split(","); //store a line read from input file as an element of a string array
                if (content [0] == Integer.toString(id))
       
                       result.add(content [0]+ "," + content [1] + "," + content [2] + "," + content [3] +"," + content [4] + "," + content [5] + "," + cart.get(id));
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
            
        }
        return result;
    }
}
