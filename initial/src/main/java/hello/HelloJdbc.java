package hello;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloJdbc {

	public static void main(String[] args) {
		try {
			new HelloJdbc().run();
			System.out.println("Normal termination.");
		} catch (Exception bland) {
			bland.printStackTrace();
		}

	}

	public void run() {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = getConnection();
			System.out.println("con="+con);
		} catch (Exception sqex) {
			sqex.printStackTrace();
		}
	}
	
	// from https://devcenter.heroku.com/articles/heroku-postgresql#connecting-in-java
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    String username = "mpayne";
	    String password = "";
	    String host = "localhost";
	    String dbUrl = "jdbc:postgresql://localhost/mpayne";

	    return DriverManager.getConnection(dbUrl, username, password);
	}
}
