package cz.burios.ux.cas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Tester {

	public static void main(String[] args) {
		try {
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String pwd = encoder.encode("demo");
			System.out.println("demo: " + pwd);
			pwd = encoder.encode("fanDyta_89");
			System.out.println("fanDyta_89: " + pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
