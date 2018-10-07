import java.util.*;
/**
 * a description of class UserInterface:
 * It is the boundry class that can deal with users directly 
 * In addition it is connect to 2 controller to do the necessary operations for MFV
 * The main function here is startMFV
 * @author (Shararng, Gauri,Najma,Hala)
 * @version (3)
 */
public class UserInterface
{
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
     * It is a first method user has to start with
     *no parameter
     * no return value
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
                password = readInput();
            }
            printOutput("Please Confirm Password");
            String password_1 = readInput();
            while(!(password.equals(password_1)))
            {
                printOutput("Passwords do not match. Please try again.");
                password_1 = readInput();
            }
            printOutput("Please enter your email address");
            String email = readInput();
            while(!(email.contains("@")))
            {
                printOutput("Invalid Email Address. Please try again.");
                email = readInput();
            }
            printOutput("Please enter your address");
            String address = readInput().replaceAll(",","");
            while((address.contains(",")))
            {
                printOutput("Please do not use commas in address and try again");
                address = readInput();
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
                int option = 0;
                printOutput("*************************************************************************************");
                printOutput("Please enter a password that matches the following criteria");
                printOutput("1. Edit your address");
                printOutput("2. Deactiva ");
                option = Integer.parseInt(readInput());
                if(option == 1)
                {
                    printOutput("Please enter your new address");
                    String newAddress = readInput();
                    systemController.editProfile(3,userName,newAddress);
                }
                else if (option == 2)
                {
                systemController.updateUserData(7,userName,"true");
                }
            }
            else
                printOutput("Registration Failed");
        }
        else 
        {
            printOutput("Please enter your password");
            String password = readInput();
            String login = systemController.confirmationForLogin(answer,password);
            int i = 1;
            while(!(login.equalsIgnoreCase("valid")))
            {
                i++;
                if(i<4)
                {
                    printOutput(login+". Please try again.");
                    password=readInput();
                    login = systemController.confirmationForLogin(answer,password);
                }
                else
                {
                    printOutput("Reached maximum invalid attemps. Please answer your security questions.");
                    HashMap<String,String> questions = systemController.checkSecurityQuestions(answer);
                    boolean flag = true;
                    for(String question:questions.keySet())
                    {
                        printOutput(question);
                        String ans=readInput();
                        if(!(ans.equalsIgnoreCase(questions.get(question))))
                        {
                            systemController.updateUserData(7,answer,"true");
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
                        systemController.updateUserData(1,answer,newPassword);
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
    /**
     * *****************************************
     *no parameter
     * no return value
     */
    public void displayMenu()
    {
        int option = 0;
        String answer="";
        printOutput("*************************************************************************************");
        printOutput("Please enter a password that matches the following criteria");
        printOutput("1. Edit your profile");
        printOutput("2. Deactiva ");
        /*
        String newPassword=readInput();;
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
            printOutput("Invalid option");
            break;
        }
        */
    }
    /**
     * It is a method to ensure the password is confirm
     * no parameter
     * return value is true
     */
    public boolean askForConfirmation()/////////no need
    {
        return true;
    }
    /**
     * It is a method to read the input from the users
     * no parameter
     * return the input value by users
     */
    public String readInput()
    {
        String input="";
        input= sc.nextLine();
        return input;
    }
    /**
     * It is a method to display information to users
     * The parameter is the words that want to display
     * no return value
     */
    public void printOutput(String output)
    {
        System.out.println(output);
    }
}
