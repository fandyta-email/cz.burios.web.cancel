package cz.burios.ux.cancel.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.hanbo.writer.admin.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import cz.burios.ux.cancel.security.models.UserModel;
import cz.burios.ux.cancel.security.models.UserRoleModel;
import cz.burios.ux.cancel.security.utils.SecurityUtils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserAuthenticationService implements AuthenticationProvider {
	
	private static Logger _logger = LogManager.getLogger(UserAuthenticationService.class);

	@Autowired
	private LoginUserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Authentication retVal = null;
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (name == null || name.length() <= 0) {
			System.err.println("Authentication failed. User name is null or empty.");
			return retVal;
		}
		if (password == null || password.length() <= 0) {
			System.err.println("Authentication failed. User password is null or empty.");
			return retVal;
		}
		UserModel authenticatedUser = this.authenticateUser(name, password);
		if (authenticatedUser != null) {
			boolean isUserActive = authenticatedUser.isActive();
			if (!isUserActive) {
				return null;
			}
			Authentication userAuth = createAuthentication(authenticatedUser, password);
			return userAuth;
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private Authentication createAuthentication(UserModel userPrincipal, String credential) {
		List<GrantedAuthority> grantedAuths = createLoginUserAuthority(userPrincipal.getUserRoles());

		if (grantedAuths.size() == 0) {
			return null;
		}
		credential = encryptPassword(credential);
		System.out.println("Creating authentication here...");
		Authentication auth = new UsernamePasswordAuthenticationToken(userPrincipal, credential, grantedAuths);
		System.out.println("Creating authentication here... Done.");
		return auth;
	}

	private UserModel authenticateUser(String userName, String userPass) {
		UserModel user = userService.getLoginUser(userName);
		if (user != null) {
			String passEncrypted = user.getHashedUserPass();
			if (SecurityUtils.passwordEquals(userPass, passEncrypted)) {
				System.out.println("Authentication Successful.");
				return user;
			}
		}
		return null;
	}

	private List<GrantedAuthority> createLoginUserAuthority(List<UserRoleModel> userRoles) {
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		Set<GrantedAuthority> uniqueAuths = new HashSet<GrantedAuthority>();
		for (UserRoleModel userRole : userRoles) {
			if (userRole.getRoleName().equals(UserRoleModel.ROLE_SITE_ADMIN)) {
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_ADMIN"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_STAFF"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_USER"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			} else if (userRole.getRoleName().equals(UserRoleModel.ROLE_SITE_SUPERVISOR)) {
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_STAFF"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_USER"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			} else if (userRole.getRoleName().equals(UserRoleModel.ROLE_SITE_USER)) {
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_SITE_USER"));
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			} else if (userRole.getRoleName().equals(UserRoleModel.ROLE_GUEST)) {
				uniqueAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			} else {
				uniqueAuths.clear();
			}
		}
		if (uniqueAuths.size() > 0) {
			grantedAuths.addAll(uniqueAuths);
			_logger.info("Number of roles: " + grantedAuths.size());
		}
		return grantedAuths;
	}

	private static String encryptPassword(Object credential) {
		String encryptedPass = "";
		if (credential != null) {
			String password = (String) credential;
			encryptedPass = SecurityUtils.encryptPassword(password);
		}
		return encryptedPass;
	}
}
