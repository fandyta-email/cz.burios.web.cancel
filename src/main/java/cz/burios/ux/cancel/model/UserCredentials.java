package cz.burios.ux.cancel.model;

public class UserCredentials {

	// `ID` VARCHAR(16) NOT NULL DEFAULT '' COLLATE 'utf8_czech_ci',
	private String id;
	// `USER_ID` VARCHAR(16) NOT NULL DEFAULT '' COLLATE 'utf8_czech_ci',
	private String userId;
	// `USER_NAME` VARCHAR(64) NOT NULL DEFAULT '' COLLATE 'utf8_czech_ci',
	private String userName;
	// `USER_PASSWORD` VARCHAR(64) NOT NULL DEFAULT '' COLLATE 'utf8_czech_ci',
	private String userPassword;
	// `USER_ROLE` VARCHAR(32) NOT NULL DEFAULT '' COLLATE 'utf8_czech_ci',
	private String userRole;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// `ENABLED` TINYINT(4) NULL DEFAULT '1',	
	private Boolean enabled;
	public UserCredentials() {
		super();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
