import java.util.*;
/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    private SystemController systemController= new SystemController();
    private Scanner sc = new Scanner(System.in);
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void startMFV()
    {
        String answer="";
        printOutput("                    WELCOME TO MONASH FRUIT AND VEGETABLES                           ");
        printOutput("*************************************************************************************");
        printOutput("Please Enter your ID");
        printOutput("Or if you are new customer please inter 'yes'");
        answer = readInput();
        if(answer.equalsIgnoreCase("yes"))
        {
            printOutput("Please enter your name");
            String userName= readInput();
            printOutput("Please enter a password that matches the following criteria");
            printOutput("1. Must be at least 8 characters long");
            printOutput("2. Must contain at least one upper case alphabet");
            printOutput("3. Must contain at least one lower case alphabet");
            printOutput("4. Must contain at least one number (0-9)");
            printOutput("5. Must contain at least one special character");
            String password=readInput();
            while(!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")))
            {
                printOutput("Password does not meet the criteria. Please try again");
                password=readInput();
            }
            printOutput("Please Confirm Password");
            String password_1=readInput();
            while(!(password.equals(password_1)))
            {
                printOutput("Passwords do not match. Please try again.");
                password_1=readInput();
            }
            printOutput("Please enter your email address");
            String email=readInput();
            while(!(email.contains("@")))
            {
                printOutput("Invalid Email Address. Please try again.");
                email=readInput();
            }
            printOutput("Please enter your address(Without any commas)");
            String address=readInput();
            while((address.contains(",")))
            {
                printOutput("Please do not use commas in address and try again");
                address=readInput();
            }
            String questions[] =new String[2];
            String answers[]=new String[2];
            for(int i=0;i<2;i++)
            {
                printOutput("Please enter your security question "+(i+1));
                questions[i]=readInput();
                printOutput("Please enter your answer for question "+(i+1));
                answers[i]=readInput();
            }
            boolean registration=systemController.registerNewCustomer(userName,password,email,questions,answers,address,false);
            if(registration)
            {
                printOutput("Registration Successful");
            }
            else
                printOutput("Registration Failed");
        }
        else 
        {
            printOutput("Please enter your password");
            String password = readInput();
            String userName="";
            String login = systemController.confirmationForLogin(answer,password);
            int i = 1;
            while(!(login.equalsIgnoreCase("valid")))
            {
                i++;
                if(i<4)
                {
                    printOutput(login+". Please try again.");
                    printOutput("Enter Username");
                    userName=readInput();
                    password=readInput();
                    login = systemController.confirmationForLogin(answer,password);
                }
                else
                {
                    printOutput("Reached maximum invalid attemps. Please answer your security questions.");
                    HashMap<String,String> questions = systemController.checkSecurityQuestions(userName);
                    boolean flag = true;
                    for(String question:questions.keySet())
                    {
                        printOutput(question);
                        String ans=readInput();
                        if(!(ans.equalsIgnoreCase(questions.get(question))))
                        {
                            systemController.updateUserData(7,userName,"true");
                            flag=false;
                        }
                    }
                    if(flag)
                    {
                        printOutput("Please enter a password that matches the following criteria");
                        printOutput("1. Must be at least 8 characters long");
                        printOutput("2. Must contain at least one upper case alphabet");
                        printOutput("3. Must contain at least one lower case alphabet");
                        printOutput("4. Must contain at least one number (0-9)");
                        printOutput("5. Must contain at least one special character");
                        String newPassword=readInput();
                        while(!(newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")))
                        {
                            printOutput("Password does not meet the criteria. Please try again");
                            password=readInput();
                        }
                        printOutput("Please Confirm Password");
                        String newPassword_1=readInput();
                        while(!(newPassword.equals(newPassword_1)))
                        {
                            printOutput("Passwords do not match. Please try again.");
                            newPassword_1=readInput();
                        }
                        systemController.updateUserData(1,userName,newPassword);
                        login="valid";
                        break;
                    }
                    else
                    {
                        printOutput("Account Locked. Please contact Store Owner");
                        break;
                    }
                }
            }
            if(login.equalsIgnoreCase("valid"))
                displayMenu();
        }
    }

    public void displayMenu()
    {
        int option = 0;
        System.out.println("*************************************************************************************");
        System.out.println("\n Please select from the next menu:");
        option = Integer.parseInt(readInput());
        switch(option)
        {
            case 1:
            break;
            case 2:
            break;
            case 3:
            break;
            default:
            System.out.println("Invalid option");
            break;
        }
    }

    public boolean askForConfirmation()
    {
        return true;
    }

    public String readInput()
    {
        String input="";
        input= sc.nextLine();
        return input;
    }

    public void printOutput(String output)
    {
        System.out.println(output);
    }
}
