package users;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SocialMedia {
	
	Connection connection=new ConHelper().getConnection();
	
	
	public void signUp(User user,Scanner scanner){
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
		    preparedStatement.setString(1, user.getFirst_name());
		    preparedStatement.setString(2, user.getLast_name());
		    preparedStatement.setString(3, user.getEmail_id());
		    preparedStatement.setLong(4,user.getContact_number() );
		    preparedStatement.setString(5,user.getGender());
		    preparedStatement.setString(6, user.getDate_of_birth());
		    preparedStatement.setString(7, user.getPassword());
		    System.out.println("Press");
		    System.out.println("1---> Submit");
		    System.out.println("2---> Cancel");
		    switch(scanner.nextInt()){
		    case 1:preparedStatement.execute();
		    System.out.println("Account Created Successfully");
		    break;
		    case 2:break;
		    }
		} catch (SQLException e) {
			System.out.println("Account Already Exists Please Try With Other Contact Number or Email Id");
//			e.printStackTrace();
		}
	}
	
	public void logIn(User user,Scanner sc,Date date,Post post){
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select*,count(*) from user  where mail_id=?");
			preparedStatement.setString(1, user.getEmail_id());
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			if(resultSet.getInt(8)!=0){
			
			//Object pwd=(Object)resultSet.getString(7);
			for(int i=1;i<=3;i++){
			if(user.getPassword().equals(resultSet.getString(7))){
				int date1=date.getDate();
				int month=date.getMonth();
				int hours=date.getHours();
				int min=date.getMinutes();
				 String Date=""+date1+"-"+(month+1)+"-2022";
				 String Time=""+hours+":"+min+"";
				System.out.println("Logged in Successfully");
				System.out.println();
				System.out.println();
				System.out.println("Log In Time--->"+Time);
				System.out.println();
				System.out.println("First Name--->"+resultSet.getString(1));
				System.out.println("Last Name--->"+resultSet.getString(2));
				System.out.println("Gender--->"+resultSet.getString(5));
				System.out.println("Contact number--->"+resultSet.getLong(4));
				System.out.println("Date of Birth--->"+resultSet.getString(6));
				System.out.println();
				System.out.println("Posts");
				post.getPost(user);
				boolean flag=true;
				while(flag){
					System.out.println();
				System.out.println("Press 1--->To add Post");
				System.out.println("Press 2--->To Exit");
				switch (sc.nextInt()) {
				case 1:System.out.println("Enter the Post");
				String post1=sc.nextLine();
				post1+=sc.nextLine();
					user.setPost(post1);
					post.postStatus(user, date);
					System.out.println("Post added Successfully");
					break;

				default:flag=false;
					System.out.println("Thank you");
					break;
				}}
				
				break;
			}else{
				
				if(i==3){
					System.out.println("Your 3 trials to logIn are over try again later");
					break;
				}
				System.out.println("Password Incorrect Enter Valid Password");
				user.setPassword(sc.next());
			}
			}
			}else{
				System.out.println("Account dosn't exist Enter valid Email id");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
