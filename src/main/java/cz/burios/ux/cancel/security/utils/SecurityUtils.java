package cz.burios.ux.cancel.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtils {
	
	public static String encryptPassword(String userPass) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(userPass);
	}

	public static boolean passwordEquals(String userPass, String passEncrypted) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(userPass, passEncrypted);
	}
}
