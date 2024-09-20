package com.michael.example.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.michael.example.util.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private final String BEARER = "Bearer ";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws
		ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token != null && token.startsWith(BEARER)) {
			token = token.substring(7);
			String userId = JwtTokenUtil.validateToken(token);

			if(userId != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} else {
			log.error("Error At nullCheck Authorization = {}", token);
		}
		filterChain.doFilter(request, response);
	}
}
