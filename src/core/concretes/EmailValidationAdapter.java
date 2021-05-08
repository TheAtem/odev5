package core.concretes;

import core.abstracts.ValidationServices;

public class EmailValidationAdapter implements ValidationServices{

	@Override
	public void sendEmail(String email) {
		System.out.println(email + " adresine doğrulama linki gönderildi.");
	}

	@Override
	public boolean isValidated() {
		return false;
	}

}
