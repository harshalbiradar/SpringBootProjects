package com.harshalit.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.harshalit.util.JWTUtil;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil util;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// read token from authorization header
		String token = request.getHeader("Authorization");
		if (token != null) {
			// do validation
			String userName = util.getUserName(token);
			// userName should not be empty and context auth must be empty
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = userDetailsService.loadUserByUsername(userName);

				// validate token
				boolean isValid = util.validateToken(token, user.getUsername());
				if (isValid) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName,
							user.getPassword(), user.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					// finally object stored in security context with userdetails
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
