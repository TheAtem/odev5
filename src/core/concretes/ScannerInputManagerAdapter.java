package core.concretes;

import java.util.Scanner;

import core.abstracts.ScannerServices;

public class ScannerInputManagerAdapter implements ScannerServices{

	private Scanner scannerInput;
	
	
	public ScannerInputManagerAdapter(Scanner scannerInput) {
		this.scannerInput = scannerInput;
	}

	@Override
	public int scannerInputInt() {
		return this.scannerInput.nextInt();
	}

	@Override
	public String scannerInputString() {
		return this.scannerInput.next();
	}


}
