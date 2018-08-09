package group2.bsms.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	private static Properties prop;
	private static String url;
	private static String driver;
	private static Connection conn;
	
	static {
		try {
			InputStream input = DBConnection.class.getResourceAsStream("db.properties");
			prop = new Properties();
			prop.load(input);
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			System.out.println(url);
			System.out.println(driver);
		}
		catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, prop);
			System.out.println("Connected succesfully");
			return conn;
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("Connect Error");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeQuietly(Connection connect) {
        try {
            connect.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection connect) {
        try {
            connect.rollback();
        } catch (Exception e) {
        }
    }
    
	public static void main(String[] args) {
		DBConnection.getConnection();
	}
}
