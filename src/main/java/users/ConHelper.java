package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConHelper {

	public Connection getConnection(){
		
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
