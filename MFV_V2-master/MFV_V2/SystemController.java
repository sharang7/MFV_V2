package MFV_V2;

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
     * This method gets details of a new customer from the boundary class and calls writeUserDataBase()
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
    
    /**
     * This method validates credentials entered by the user against those stored in MFV database.
     */
    public String confirmationForLogin(String userName,String password)
    {
        HashMap<String,String[]> credentials = readUserDatabase("user_db.txt");
        if(credentials.keySet().contains(userName))
            if(credentials.get(userName)[0].equals(Integer.toString(password.hashCode()))&&credentials.get(userName)[1]!="false")
                return "Valid";
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
    /*public boolean editProfile(int index, String userName, String newAddress)
    {
        String line="";
        try
        {
            FileReader fileReader = new FileReader("user_db.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String old = "";
            String newLine = userName;
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(",");
                if(content[0].equals(userName))
                {
                    if(index == 1)
                        content[0] = userName;
                    else
                        content[index]= newAddress;
                }
                for(int i=1;i<content.length;i++)
                    newLine=newLine+","+content[i];
                old=old+newLine+System.lineSeparator();
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
    }*/
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
                questions.put(content[3],content[5]);
                questions.put(content[4],content[6]);
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
            old.append(userName+","+password.hashCode()+","+email+","+questions[0]+","+questions[1]+","+answers[0]+","+
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
            String newLine=userName;
            while((line = br.readLine()) != null)
            {
                String content [] = line.split(",");
                if(content[0].equals(userName))
                {
                    if(index==1)
                        content[1]=Integer.toString(newValue.hashCode());
                    else
                        content[index]=newValue;
                }
                for(int i=1;i<content.length;i++)
                    newLine=newLine+","+content[i];
                old=old+newLine+System.lineSeparator();
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
    
    //editCart()
    //checkout(int,int):String
    //viewTransaction(int):String
    //fetchProduct(String):Product
}