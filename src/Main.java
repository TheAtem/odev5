import java.util.ArrayList;
import java.util.Scanner;

import bussiness.abstracts.UserServices;
import bussiness.concretes.UserManager;
import core.abstracts.ScannerServices;
import core.concretes.EmailValidationAdapter;
import core.concretes.RegexManagerAdapter;
import core.concretes.ScannerInputManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		ScannerServices consoleInput = new ScannerInputManagerAdapter(new Scanner(System.in));
		UserManager userServices = new UserManager(new HibernateUserDao(new ArrayList<User>()), 
				new RegexManagerAdapter(), new EmailValidationAdapter(), consoleInput);
		
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";
		
		boolean loop = true;
		int processNumber = 0;
		while(loop) {
			System.out.println("1 - Log in \n"
					+ "2 - Sign up \n"
					+ "3 - exit");
			System.out.print("Lütfen yapmak istediðiniz iþlemin numarasýný giriniz.");
			processNumber = consoleInput.scannerInputInt();
			
			if(processNumber == 1) {
				System.out.print("Email : ");
				email = consoleInput.scannerInputString();
				//System.out.print();
				System.out.print("Sifre : ");
				password = consoleInput.scannerInputString();
				userServices.logIn(email, password);
				
			}else if(processNumber == 2) {
				
				System.out.print("Email : ");
				email = consoleInput.scannerInputString();
				System.out.print("Sifre : ");
				password = consoleInput.scannerInputString();
				System.out.print("Ad : ");
				firstName = consoleInput.scannerInputString();
				System.out.print("Soyad : ");
				lastName = consoleInput.scannerInputString();
				userServices.signUp(new User(firstName, lastName, email, password));
				
			}else if(processNumber == 3) {
				loop = false;
				System.out.println("Sistemden çýkýþ yaptýnýz.");
			}else {
				System.out.println("Yanlýþ bir numara girdiniz.Tekrar deneyiniz.");
				System.out.println("===============================================");
			}
		}

	}

}
