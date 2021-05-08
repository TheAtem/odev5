package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	private List<User> users;
	
	public HibernateUserDao(List<User> users) {
		this.users = users;
	}

	@Override
	public void add(User user) {
		System.out.println("Sisteme " + user.getFirstName() + " isimli kullanýcý eklendi.");
		this.users.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println("Sistemden " + user.getFirstName() + " isimli kullanýcý silindi.");
		this.users.remove(this.users.indexOf(user));
	}

	@Override
	public void upgrade(User user) {
		System.out.println("Sistem de " + user.getFirstName() + " isimli kullanýcý bilgileri güncellendi.");

	}
	
	public User getUser(String email, String password) {
		for(User u : users) {
			if((u.getEmail().equals(email)) & (u.getPassword().equals(password))) {
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}
	

}
