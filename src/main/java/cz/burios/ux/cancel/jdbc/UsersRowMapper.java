package cz.burios.ux.cancel.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cz.burios.ux.cancel.model.UserCredentials;

public class UsersRowMapper implements RowMapper<UserCredentials> {

	@Override
	public UserCredentials mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCredentials users = new UserCredentials();
		users.setId(rs.getString("ID"));
		users.setUserId(rs.getString("USER_ID"));
		users.setUserName(rs.getString("USER_NAME"));
		users.setUserPassword(rs.getString("USER_PASSWORD"));
		users.setUserRole(rs.getString("USER_ROLE"));
		users.setEnabled(rs.getInt("ENABLED") == 1 ? Boolean.TRUE : Boolean.FALSE);
		return users;
	}

}
