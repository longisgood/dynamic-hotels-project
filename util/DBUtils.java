package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {
	
	private DBUtils() {}
	
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn ==null) {
			try {
				
				String driver= "com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://192.168.1.97:3306/db_project_rv";
				String username= "BigData";
				String password= "12345";
				Class.forName(driver);
				conn= DriverManager.getConnection(url, username, password);
				
				
				
				//conn= DriverManager.getConnection(url, user, password);
				conn= DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void close(AutoCloseable... closers) {
		for(AutoCloseable c: closers) {
			try {
				if(c != null) c.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
