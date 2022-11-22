package cz.burios.ux.cancel;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cz.burios.ux.cancel.config.SecurityConfig;
import cz.burios.ux.cancel.config.WebConfig;
import cz.burios.ux.cancel.jdbc.JdbcConfig;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
			JdbcConfig.class,
			// WebConfig.class
			// RootConfig.class,
			SecurityConfig.class
			// JerseyResourceConfig.class 
		};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { 
			WebConfig.class
		};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}