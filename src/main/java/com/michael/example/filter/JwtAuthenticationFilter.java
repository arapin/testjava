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

	/**
	 * 이 메소드는 필터 체인 내에서 요청을 처리합니다.
	 *
	 * @param request  HttpServletRequest 객체로서, 클라이언트 요청을 나타냅니다.
	 * @param response HttpServletResponse 객체로서, 서버의 응답을 나타냅니다.
	 * @param filterChain FilterChain 객체로서, 다른 필터로 요청을 전달합니다.
	 * @throws ServletException Servlet 관련 예외가 발생했을 때 던집니다.
	 * @throws IOException 입력 또는 출력 예외가 발생했을 때 던집니다.
	 */
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
			} else {
				log.error("Error Authorization = {}", token);
			}
		} else {
			log.error("Error At nullCheck Authorization = {}", token);
		}
		filterChain.doFilter(request, response);
	}
}
