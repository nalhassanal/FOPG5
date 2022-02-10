package test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hassanal
 */
public class Checker {
    private String input;
    private final String mailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$" ;
    private final String usernameRegex = "\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b";
    public Checker(String input) {
        this.input = input;
    }
    
    public boolean emailCheck(String email){
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = pattern.matcher(email);
        boolean check = matcher.matches();
        if (check == true)
            return check;
        else
            return false;
    }
    
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