package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void upgrade(User user);
	User getUser(String email, String password);
	List<User> getAll();
	



}
