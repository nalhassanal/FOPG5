package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnect {
    public sqlconnect(){
    }

    public Connection connector (){
        String url = "jdbc:mysql://127.0.0.1:3306/mayav2?serverTimezone=UTC";
        String user = "nal";
        String password = "Hassanalharriz8122*";
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        if (con != null){
            return con;
        }
        return con;
    }
}
