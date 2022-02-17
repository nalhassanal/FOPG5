package Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hassanal
 */
public class Checker {

    /**
     * instance variable input
     */
    private String input;

    /**
     * constant instance variable mailRegex
     * this is the regular expression to be used by the email checker
     */
    private final String mailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$" ;

    /**
     * constant instance variable usernameRegex
     * this is the regular expression to be used by the username checker
     */
    private final String usernameRegex = "\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b";

    /**
     * constructor to initialize the instance variable input
     * @param input
     */
    public Checker(String input) {
        this.input = input;
    }
    
    /**
     * this method is used to check the email whether it follow the regular expression
     * @param email - gets input from caller from user input
     * @return true if email matches the pattern
     */
    public boolean emailCheck(){
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = pattern.matcher(input);
        boolean check = matcher.matches();
        if (check == true)
            return check;
        else
            return false;
    }
    
    /**
     * this method is used to check the name whether it follow the regular expression
     * @param name - gets input from caller from user input
     * @return true if name matches the pattern
     */
    public boolean usernameCheck(String name){
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher match = pattern.matcher(name);
        boolean check = match.matches();
        if ( check == true)
            return check;
        else
            return false;
    }
}