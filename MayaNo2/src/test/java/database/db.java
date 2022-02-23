package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class db {
    public static Connection connect(){
        String url = "jdbc:mysql://localhost:3306/mayav2?serverTimezone=UTC";
        String user = "nal";
        String password = "Hassanaharriz8122*";
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
    public static void printTable(){
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String query = "select * from users ORDER BY idusers";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            System.out.println("id\t|username|\t|password");
            System.out.println("--\t---------\t---------");

            while(rs.next()){
                int id = rs.getInt("idusers");
                String username = rs.getString("UserName");
                String pass = rs.getString("userPassword");
                System.out.println(id+"\t|"+username+"|\t|"+pass);
                System.out.println("--\t---------\t---------");
            }
            con.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    public static void insert(){
        Scanner input = new Scanner(System.in);
        Connection con = connect();
        String query = "insert into users (UserName,userPassword) values (?,?)";

        try{
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter name");
            String name = input.nextLine();
            System.out.println("Enter password");
            String pass = input.nextLine();

            ps.setString(1, name);
            ps.setString(2, pass);

            ps.execute();

            input.close();
            con.close();
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args) {
        //insert();
        printTable();
    }
}
