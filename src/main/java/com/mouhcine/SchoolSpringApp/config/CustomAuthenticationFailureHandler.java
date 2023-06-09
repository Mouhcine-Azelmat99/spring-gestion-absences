package com.mouhcine.SchoolSpringApp.config;

import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		// write your custom code here

		if (exception instanceof DisabledException) {
			response.sendRedirect("showMyLoginPage?error=disabled");
			return;

		} 
		
		else if (exception instanceof LockedException) {
			response.sendRedirect("showMyLoginPage?error=locked");
			return;

		} 
		else if (exception instanceof CredentialsExpiredException) {
			response.sendRedirect("showMyLoginPage?error=expired");
			return;

		} 
		else {
			response.sendRedirect("showMyLoginPage?error=other");

		}
	}

}