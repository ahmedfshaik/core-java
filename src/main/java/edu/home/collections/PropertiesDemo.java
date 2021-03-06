package edu.home.collections;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesDemo {
    private static Properties props = null;
    
    static {
        try {
            props = new Properties();
            props.load(new FileInputStream("src/connection.properties"));
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        Connection con = null;
        final String driverClass = props.getProperty("driverClassName");
        final String url = props.getProperty("url");
        final String username = props.getProperty("username");
        final String pwd = props.getProperty("password");
        try {
            // Load & Register JDBC Driver class
            Class.forName(driverClass);
            
            con = DriverManager.getConnection(url, username, pwd);
        } catch (final SQLException e) {
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(final String[] args) throws Exception {
        final Connection con = PropertiesDemo.getConnection();
        
        final DatabaseMetaData dbmd = con.getMetaData();
        
        System.out.println("Database Name:" + dbmd.getDatabaseProductName());
        System.out.println("Database Product version:" + dbmd.getDatabaseProductVersion());
        System.out.println("Driver Name:" + dbmd.getDriverName());
        System.out.println("Driver Version:" + dbmd.getDriverVersion());
    }
}
