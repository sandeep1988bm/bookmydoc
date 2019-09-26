package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dBase {

	private Connection connection;
	private Statement statement;
	private ResultSet results = null;
	@SuppressWarnings("unused")
	private String query;

	public void createConn() throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOK_MY_DOC", "root", "");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.140.4.104:1578:training", "training", "training2013");
		statement = connection.createStatement();
	}

	public ResultSet executeQuery(String q) throws SQLException {
		results = statement.executeQuery(q);
		return results;
	}

	public int doUpdate(String query) throws Exception {
		int i = statement.executeUpdate(query);
		return i;
	}

	public ResultSet getData(String query) throws Exception {
		results = statement.executeQuery(query);
		return results;
	}

	public int getRowCount(String query) throws Exception {
		int count = 0;
		results = statement.executeQuery(query);
		while (results.next()) {
			count++;
		}
		return count;
	}

	public void closeConn() throws SQLException {
		statement.close();
		connection.close();
	}
}
