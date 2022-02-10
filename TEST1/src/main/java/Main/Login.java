package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 *
 * @author Hassanal
 */
public class Login {
    static Connection con;
    static Statement stmt;
    static PreparedStatement prstmt;
    static ResultSet rs;
    static Scanner in;
    public static void main(String[] args){
        in = new Scanner(System.in);
        String cond;
        System.out.println("Do you have an account? ");
        cond = in.next();
        if ( cond.equals("NO") ){
            //connector();
            registration();
            System.out.println("Successfully registered !!");
        }
        else{
            System.out.println("Thank you");
        }
    }
    
    public static void registration(){
        connector();
        in = new Scanner(System.in);
        String username;
        String password;
        int index = 0;
        System.out.println("Enter your user ID (matrix no.)");
        username = in.nextLine();
        System.out.println("Enter your password");
        password = in.nextLine();
        try{
            index++;
            String query;
            query = "INSERT INTO user(index, UserID, UserPass) value( ?, ?, ?)";
            prstmt = con.prepareStatement(query);
            prstmt.setInt(1, index);
            prstmt.setString(2, username);
            prstmt.setString(3, password);
            prstmt.execute();
            System.out.println("Successfully registered");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void connector(){
        String url ="jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Hassanal8122*_";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is Successful to the database "+url);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
