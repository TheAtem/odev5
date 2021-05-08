package core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.abstracts.RegexServices;
import entities.concretes.User;

public class RegexManagerAdapter implements RegexServices{

	private String regex = "[A-Za-z0-9+_.-]+@(.+)$";
	private Pattern pattern = Pattern.compile(regex);
	private Matcher matcher;
	
	public boolean checkEmail(String email) {
		matcher = pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public int checkCharNumber(String chars) {
		return chars.toCharArray().length;
	}

	@Override
	public boolean checkUser(User user) {
		if(!checkEmail(user.getEmail())) {
			System.out.println("Eksik yada yanliþ bir email adresi girdiniz.");
			return false;
		}else if(checkCharNumber(user.getPassword()) < 6) {
			System.out.println("Eksik yada yanliþ þifre girdiniz.");
			return false;
		}else if(checkCharNumber(user.getFirstName()) < 2) {
			System.out.println("Eksik yada yanliþ bir isim girdiniz.");
			return false;
		}else if(checkCharNumber(user.getLastName()) < 2) {
			System.out.println("Eksik yada yanliþ bir soyisim girdiniz.");
			return false;
		}
		return true;
	}
	
	

}
