package cz.burios.ux.cancel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cz.burios.ux.cancel.model.UserDetails;

public class UserRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int row) throws SQLException {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(rs.getString("user_name"));
		userDetails.setPassword(rs.getString("user_pass"));
		userDetails.setRole(rs.getString("user_role"));

		return userDetails;
	}

}