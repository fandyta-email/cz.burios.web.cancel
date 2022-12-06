package cz.burios.ux.cancel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.burios.ux.cancel.model.UserDetails;
import cz.burios.ux.cancel.rowmapper.UserRowMapper;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDetails getUser(String username) {
		try {
			final String sql = 
				"SELECT u.user_name user_name, u.user_pass user_pass, ur.user_role user_role "
				+ "FROM user u, user_role ur "
				+ "WHERE u.user_name = ? and u.user_name = ur.user_name";

			UserDetails userDetails = jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);

			return userDetails;
		} catch (EmptyResultDataAccessException ex) {
			// should have proper handling of Exception
			return null;
		}
	}
}
