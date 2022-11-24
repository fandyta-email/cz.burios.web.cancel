package cz.burios.ux.cancel.security.models;

public class UserRoleModel {
	
	public static final String ROLE_SITE_ADMIN = "SITE_ADMIN";
	public static final String ROLE_SITE_SUPERVISOR = "SITE_SUPERVISOR";
	public static final String ROLE_SITE_USER = "SITE_USER";
	public static final String ROLE_GUEST = "GUEST";

	private int roleId;
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
