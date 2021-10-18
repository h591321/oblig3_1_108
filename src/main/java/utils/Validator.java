package utils;

public class Validator {
	
	//mangler html skjekk+null etc
	public static boolean isValidPassword(String pw) {
		if(pw.equals("vesper")) {
			return true;
		}
		return false;
	}
	
}
