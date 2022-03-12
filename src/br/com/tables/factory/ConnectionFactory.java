package br.com.tables.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASEURL = "jdbc:mysql://localhost:3306/simple_crud_java?allowMultiQueries=true";
	
	
	
	public static Connection createConnectionToMySQL() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("Connection successfully made");
			con.close();
		}
	}
	
}
