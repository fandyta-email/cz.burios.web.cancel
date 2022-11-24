package cz.burios.ux.cancel.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class SampleAccessDeniedHandler implements AccessDeniedHandler {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
		String redirectUrl = request.getContextPath();
		redirectUrl = redirectUrl + "/accessDenied";
		response.sendRedirect(redirectUrl);
	}
}
