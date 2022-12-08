/**
 * 
 */
package assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Model class for the usage of database
 * mysql-connector-j-8.0.31.jar is used
 * @author Chamindu
 *
 */
//https://youtu.be/L0f-jfKKXGg
public class DBConnect {

	String driver = "com.mysql.cj.jdbc.Driver";
	String path = "jdbc:mysql://localhost:3306/quiz_game?useSSL=false";
	String userName = null;
	String password = null;
	Connection con = null;
	Statement stm = null;

	/**
	 * @param name
	 * @param pass
	 */
	public DBConnect(String name, String pass) {
		userName = name;
		password = pass;
	}

	/**
	 * Create the connection
	 * @throws SQLException
	 * @throws Exception
	 */
	public void connect() throws SQLException, Exception {
		System.out.println("Connecting");
		con = DriverManager.getConnection(path, userName, password);
		stm = con.createStatement();
	}

	/**
	 * @throws SQLException
	 * @throws Exception
	 */
	public void closeConnection() throws SQLException, Exception {
		stm.close();
		con.close();
	}

	/**
	 * @return stm
	 */
	public Statement getStatement() {
		return stm;
	}

	/**
	 * @return con
	 */
	public Connection getConnection() {
		return con;
	}
}