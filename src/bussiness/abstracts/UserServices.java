package bussiness.abstracts;

import entities.concretes.User;

public interface UserServices {
	
	void logIn(String email, String password);
	void signUp(User user);
}
