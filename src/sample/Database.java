package sample;

//Oğulcan Şahin 170503007

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn;

    public static Connection getConnenction(){
        try{
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\Ogulcan\\Desktop\\ProjeDatabase\\;shutdown=true";
            conn = DriverManager.getConnection(url,"Rendall","RelmAdo239");
        }
        catch (SQLException e) {
            System.out.println("Database connection error:" + e);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
        }

        return conn;
    }
}
