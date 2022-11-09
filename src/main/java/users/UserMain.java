package users;

import java.util.Date;
import java.util.Scanner;

public class UserMain {
public static void main(String[] args) {
	
	User user=new User();
	Scanner scanner = new Scanner(System.in);
	SocialMedia socialMedia=new SocialMedia();
	Date date=new Date();
	Post post=new Post();
	
	
//	 System.out.println("Enter the First name");
//	 String first_name=scanner.next();
//	
//	 System.out.println("Enter the Last name");
//	 String last_name=scanner.next();
//	 
//	 System.out.println("Enter the Gender");
//	 String gender=scanner.next();
//	 
//	 System.out.println("Enter the Contact number");
//	 long contact_number=scanner.nextLong();
//	 
//	 System.out.println("Enter the Date of Birth");
//	 String date_of_birth=scanner.next();
//	 
//	 System.out.println("Enter the Email id");
//	 String email_id=scanner.next();
////	 
//	 System.out.println("Enter the Password");
//	 String password=scanner.next();
//	 
//	 user.setFirst_name(first_name);
//	 user.setLast_name(last_name);
//	 user.setGender(gender);
//	 user.setContact_number(contact_number);
//	 user.setEmail_id(email_id);
//	 user.setDate_of_birth(date_of_birth);
//	 user.setPassword(password);
//	 
//	 System.out.println("Enter ");
//	
//	 socialMedia.signUp(user);
	boolean flag=true;
	
	 while(flag){
		    System.out.println();
		    System.out.println();
		    System.out.println();
		    System.out.println("Press 1---> To SignUp");
			System.out.println("Press 2---> To LogIn");
			System.out.println("Press 3---> To Exit");
	switch (scanner.nextInt()) {
	case 1:  System.out.println("Enter the First name");
	         String first_name=scanner.next();
	
	         System.out.println("Enter the Last name");
	         String last_name=scanner.next();
	 
	         System.out.println("Enter the Gender");
	         String gender=scanner.next();
	 
	         System.out.println("Enter the Contact number");
	         long contact_number=scanner.nextLong();
	 
	         System.out.println("Enter the Date of Birth");
	         String date_of_birth=scanner.next();
	 
	         System.out.println("Enter the Email id");
	         String email_id=scanner.next();

	         System.out.println("Enter the Password");
	         String password=scanner.next();
	 
	         user.setFirst_name(first_name);
	         user.setLast_name(last_name);
	         user.setGender(gender);
	         user.setContact_number(contact_number);
	         user.setEmail_id(email_id);
	         user.setDate_of_birth(date_of_birth);
	         user.setPassword(password);
		
		     socialMedia.signUp(user,scanner);
		
		     break;
    
	case 2:   System.out.println("Enter the Email id");
              String email_id1=scanner.next();

              System.out.println("Enter the Password");
              String password1=scanner.next();
              
              user.setEmail_id(email_id1);
              user.setPassword(password1);
              
              socialMedia.logIn(user, scanner,date,post);
              break;
		     
	default:System.out.println("Thank you");
		flag=false;
		break;
	}
}
}
}
