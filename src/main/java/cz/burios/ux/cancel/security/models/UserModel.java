package cz.burios.ux.cancel.security.models;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	private String userId;
	private String userName;
	private String userPass;
	private String hashedUserPass;
	private boolean active;

	private List<UserRoleModel> userRoles;

	public UserModel() {
		userRoles = new ArrayList<UserRoleModel>();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getHashedUserPass() {
		return hashedUserPass;
	}

	public void setHashedUserPass(String hashedUserPass) {
		this.hashedUserPass = hashedUserPass;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserRoleModel> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleModel> userRoles) {
		this.userRoles = userRoles;
	}
}