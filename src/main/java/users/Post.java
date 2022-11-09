package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Post {

	Connection connection=new ConHelper().getConnection();
	
	public void postStatus(User user,Date date){
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into post values(?,?,?,?)");
			 preparedStatement.setString(1, user.getEmail_id());
			 preparedStatement.setString(2, user.getPost());
			 int date1=date.getDate();
				int month=date.getMonth();
				int hours=date.getHours();
				int min=date.getMinutes();
				 String Date=""+date1+"-"+(month+1)+"-2022";
				 String Time=""+hours+":"+min+"";
			 preparedStatement.setString(3,Date);
			 preparedStatement.setString(4, Time);
			 
			 preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getPost(User user){
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select* from post where mail_id=?");
		    preparedStatement.setString(1, user.getEmail_id());
		    ResultSet resultSet=preparedStatement.executeQuery();
		    while(resultSet.next()){
		    	
		    	System.out.println(resultSet.getString(3)+"  "+resultSet.getString(4)+"  "+resultSet.getString(2));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
