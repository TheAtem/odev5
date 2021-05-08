package entities.concretes;

import entities.abstracts.Entities;

public class User implements Entities{
	
	private static int id = 0;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User() {
		User.id ++ ;
	}

	public User(String firstName, String lastName, String email, String password) {
		User.id += 1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public static int getId() {
		return User.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
