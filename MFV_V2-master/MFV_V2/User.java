package MFV_V2;


/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    private String userName;
    private String userPassword;
    private String email;
    private String[] questions;
    private String[] answers;
    /**
     * Constructor for objects of class User
     */
    public User(String userName,String password,String email,String questions[],String answers[])
    {
        // initialise instance variables
        userPassword = password;
        this.userName = userName;
        this.email = email;
        this.questions = questions;
        this.answers = answers;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public void setUserPassword(String password)
    {
        // put your code here
        userPassword = password;
    }
    public String getUserPassword()
    {
        return userPassword;
    }
    public void setUserName (String name)
    {
        // put your code here
        userName = name;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setEmail(String mail)
    {
        // put your code here
        email = mail;
    }
    public String getEmail()
    {
        return email;
    }
    public void setQuestions(String[] ques)
    {
        ques[2]= new String();
        questions [0] = ques[0];
        questions [1] = ques[1];
    }
    public String[] getQuestions()
    {
        return questions;
    }
    public void setAnswers(String[] answr)
    {
        answr[2] = new String();
        answers [0] = answr[0];
        answers [1] = answr[1];
    }
    public String[] getAnswers()
    {
        return answers;
    }
}
