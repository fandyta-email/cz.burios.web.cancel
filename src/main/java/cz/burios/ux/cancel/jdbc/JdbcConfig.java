package cz.burios.ux.cancel.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@ComponentScan("cz.burios.ux.cancel.jdbc")
public class JdbcConfig {
	
	public JdbcConfig() {
		System.out.println("JdbcConfig.JdbcConfig()");
	}
	
	@Bean
	public DataSource mysqlDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/cancel?useUnicode=true&characterEncoding=UTF8&useSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("aCiesCz68");

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
