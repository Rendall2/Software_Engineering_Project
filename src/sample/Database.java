package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn;

    public static Connection getConnenction(){
        try{
            System.out.println("Connecting database...");
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\Ogulcan\\Desktop\\ProjeFolderı\\;shutdown=true";
            conn = DriverManager.getConnection(url,"Rendall","RelmAdo239");
            System.out.println("Database connected!");
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
