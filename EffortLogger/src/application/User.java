package application;

import java.util.HashMap;

public class User {
	private String username;
	private String password;
	private String userID;
	
	private String firstName;
	private String lastName;
	private Phone phoneData;
	
	private Integer clearance;
	
	public static User user;
	
	private static HashMap<String, User> users = new HashMap<String, User>();
	
	public static void init() {		
		Phone nphone = new Phone("5204427153", "AT&T");
		
		User normalEmployee = new User();
		normalEmployee.userID = "1234567890";
		normalEmployee.username = "johndoe";
		normalEmployee.password = "1234";
		normalEmployee.firstName = "John";
		normalEmployee.lastName = "Doe";
		normalEmployee.clearance = 0;
		normalEmployee.phoneData = nphone;
		
		User adminEmployee = new User();
		adminEmployee.userID = "0";
		adminEmployee.username = "admindoe";
		adminEmployee.password = "1234";
		adminEmployee.firstName = "Admin";
		adminEmployee.lastName = "Doe";
		adminEmployee.clearance = 1;
		adminEmployee.phoneData = nphone;
		
		users.put(normalEmployee.username, normalEmployee);
		users.put(adminEmployee.username, adminEmployee);
	}
	
	public static User findUser(String username) {
		User foundUser = users.get(username);
		return foundUser;
	}
	
	public void login() {
		user = this;
	}
	
	public boolean checkCredentials(String pass) {
		if (password.equals(pass)) {
			System.out.println("Correct Credentials!");
			return true;
		}
		System.out.println("Login Failed!");
		return false;
	}
	
	public Integer getClearance() {
		return clearance;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Phone getPhoneData() {
		return phoneData;
	}
}
