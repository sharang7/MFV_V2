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
    private InventoryManagementController inventoryController = new InventoryManagementController();
    private Scanner sc = new Scanner(System.in);
    String userName = "";
    String answer="";
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
    public void startMFV() throws Exception
    {

        printOutput("                    WELCOME TO MONASH FRUIT AND VEGETABLES                           ");
        printOutput("*************************************************************************************");
        printOutput("Please Enter your ID");
        printOutput("Or if you are new customer please inter 'yes'");
        answer = readInput();
        if(answer.equalsIgnoreCase("yes"))
        {
            printOutput("Please enter your name");
            userName= readInput();
            answer=userName;
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
            printOutput("Please enter your address");
            String address=readInput().replaceAll(",","");

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
                displayEditingMenu();
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
                        while(!(newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+!^=])(?=\\S+$).{8,}$")))
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
                if(answer.equals("admin123"))
                    displayOwnerMenu();
                else
                    displayCustomerMenu();
        }
    }

    public void displayCustomerMenu() throws Exception
    {
        int option = 0;
        do
        {
            System.out.println("*************************************************************************************");
            System.out.println("\n Please select from the next menu:");
            printOutput("1: Update your profile");
            printOutput("2: Search Product");
            printOutput("3: View Product");
            printOutput("4: View Cart");
            printOutput("5: Proceed to checkout");
            printOutput("6: View previous transactions");
            printOutput("7: Logout from MFV");
            option = Integer.parseInt(readInput());
            switch(option)
            {
                case 1:
                    displayEditingMenu();
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
        while(option!=8);
    }

    public void displayOwnerMenu() throws Exception
    {
        int option = 0;
        do
        {
            printOutput("*************************************************************************************");
            printOutput("\n Please select from the next menu:");
            printOutput("1: Add New Product");
            printOutput("2: Search a Product");
            printOutput("3: Edit a Product");
            printOutput("4: Delete a Product");
            printOutput("5: View a Product");
            printOutput("6: View All Transactions");
            printOutput("7: View Specific Transaction");
            printOutput("8: Logout of MFV");
            option = Integer.parseInt(readInput());
            switch(option)
            {
                case 1:
                printOutput("Shipment Details");
                printOutput("Please enter expiry date of the product (dd/MM/yyyy)");
                printOutput("For example: 29/10/2018");
                String expiry = readInput();
                printOutput("Please enter product Name");
                String name = readInput();
                printOutput("Please enter product Origin");
                String origin = readInput();
                printOutput("Please enter type of packaging (Loose/Bunch/Bags)");
                String packaging=readInput();
                printOutput("Please enter price per unit");
                double price=Double.parseDouble(readInput());
                printOutput("Please enter discount in percent (if applicable)");
                String discount=readInput();
                double discount_percent;
                if(discount.equals(""))
                    discount_percent=0;
                else
                    discount_percent=Double.parseDouble(discount);
                printOutput("Please enter quantity of product received in the shipment");
                int quantity = Integer.parseInt(readInput());
                boolean result = inventoryController.addProduct(expiry,name,origin,packaging,price,discount_percent,quantity);
                if(result)
                    printOutput("Product Added Successfully");
                else
                    printOutput("Failed to add product. Please try again.");
                break;
                case 2:

                break;
                case 3:
                break;
                case 4:
                printOutput("Please enter name of the product to delete");

                break;

                case 5:
                break;
                case 6:
                ArrayList<String> transactions = systemController.viewAllTransactions();
                System.out.format("%10s%10s%10s","Transaction ID","Customer Name","Amount"); //add padding for columns
                printOutput("\n");
                printOutput("************************************************************************************");
                for(String transaction : transactions)
                {
                    String content[] = transaction.split(",");
                    System.out.format("%10s%10s%10s",content[0],content[1],content[3]);
                }
                break;

                case 7:
                printOutput("Please enter user Name of a customer to view their transactions");
                ArrayList<String> user_transactions = systemController.viewTransactions(readInput());
                if(user_transactions.size()==0)
                    printOutput("No transactions performed by this user");
                else
                {
                    System.out.format("%10s%10s%10s","Transaction ID","Customer Name","Amount"); //add padding for columns
                    printOutput("\n");
                    printOutput("************************************************************************************");
                    for(String transaction : user_transactions)
                    {
                        String content[] = transaction.split(",");
                        System.out.format("%10s%10s%10s",content[0],content[1],content[3]);
                    }
                }
                break;
                default:
                System.out.println("Invalid option");
                break;
            }
        }
        while(option!=8);
    }

    public void displayEditingMenu() throws Exception
    {
        int option = 0;
        do
        {
        printOutput("*************************************************************************************");
        printOutput("Please enter your choice from the following menue: ");
        printOutput("1. Edit your address");
        printOutput("2. Deactivate Account");
        printOutput("3. Edit your email ");
        printOutput("4. Go to previous menue ");
        option = Integer.parseInt(readInput());
        if(option == 1)
        {
            printOutput("Please enter your new address:");
            String newAddress = readInput();
            systemController.editProfile(3,userName,newAddress);     
        }
        else if (option == 2)
        {
            systemController.editProfile(8,userName,"True");
        }
        else if (option == 3)
        {
            printOutput("Please enter your new email:");
            String newEmail = readInput();
            systemController.editProfile(2,userName,newEmail);
        }
    }
    while(option!=4);
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
