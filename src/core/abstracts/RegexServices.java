package core.abstracts;

import entities.concretes.User;

public interface RegexServices {

	boolean checkEmail(String email);
	int checkCharNumber(String chars);
	boolean checkUser(User user);
}
