package cz.burios.ux.devel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cz.burios.ux.devel.model.UserDetails;

public class UserDetailsRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int row) throws SQLException {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(rs.getString("USER_NAME"));
		userDetails.setPassword(rs.getString("USER_PASSWORD"));
		userDetails.setRole(rs.getString("USER_ROLE"));

		return userDetails;
	}

}
