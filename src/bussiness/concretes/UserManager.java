package bussiness.concretes;

import bussiness.abstracts.UserServices;
import core.abstracts.RegexServices;
import core.abstracts.ScannerServices;
import core.abstracts.ValidationServices;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserServices{
	
	private UserDao userDao;
	private RegexServices regexServices;
	private ValidationServices validationServices;
	private ScannerServices scannerServices;
	
	
	public UserManager(UserDao userDao, RegexServices regexServices, ValidationServices validationServices,
			ScannerServices scannerServices) {
		this.userDao = userDao;
		this.regexServices = regexServices;
		this.validationServices = validationServices;
		this.scannerServices = scannerServices;
	}

	public void logIn(String email, String password) {
		if((regexServices.checkEmail(email)) & (regexServices.checkCharNumber(password)>6)) {
			if(userDao.getUser(email, password) != null) {
				System.out.println("Merhaba");
				System.out.println("Hoþ Geldiniz");
			}else {
				System.out.println("Kullanýcý kaydý bulunamamýþtýr.");
				System.out.println("Bilgilerinizi kontrol ederek tekrar deneyiniz veya kayýt olunuz.");
			}
		}else {
			System.out.println("Hatali giriþ yaptiniz.Tekrar deneyin.");
		}
	}

	@Override
	public void signUp(User user) {
		if(userDao.getUser(user.getEmail(), user.getPassword()) != null)
		{
			System.out.println("Sistemde kaydýnýz bulunmaktadýr.");
			return;
		}
		if(regexServices.checkUser(user)) {
			
			validationServices.sendEmail(user.getEmail());
			System.out.println("Emaillerinizi kontrol ediniz. Emaildeki linki týklayýnýz");
			System.out.print("Linki týkladýktan sonra 'evet', email size ulaþmadýysa 'hayýr' yazýnýz.");
			
			if((scannerServices.scannerInputString().toUpperCase().equals("EVET"))) {
				userDao.add(user);
				System.out.println("Sisteme baþarý ile kayýt yapýldý : " + user.getFirstName());
			}else {
				System.out.println("Sisteme kayýt yapýlamadý tekrar deneyiniz.");
			}
		}
	}
	
}
