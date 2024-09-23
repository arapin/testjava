package com.michael.example.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import io.jsonwebtoken.Jwts;

public class JwtTokenUtil {
	private static String key = "18305813a67445ba77f31aac2b3197f70566b0577b474843dec4c97dc616a86bc01d2782d7220a9d9c34d1cf3d8b661c61f4bc3307333a88793f2e8114effcbd";

	/**
	 * 주어진 문자열 값을 기반으로 JWT 토큰을 생성합니다.
	 *
	 * @param value 토큰에 포함될 주제(subject) 값
	 * @return 생성된 JWT 토큰 문자열
	 * @throws IllegalArgumentException base64로 인코딩된 비밀 키가 null이거나 빈 문자열인 경우 예외가 발생합니다.
	 */
	public static String generateToken(String value) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("base64-encoded secret key cannot be null or empty.");
		}

		return Jwts.builder()
			.setSubject(value)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + 86400000))
			.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, key)
			.compact();
	}

	/**
	 * 주어진 토큰을 유효성 검사하고 주제를 반환합니다.
	 *
	 * @param token 검증할 토큰
	 * @return 토큰의 주제 (subject)
	 * @throws IllegalArgumentException base64-encoded 비밀 키가 null이거나 비어있는 경우
	 */
	public static String validateToken(String token) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("base64-encoded secret key cannot be null or empty.");
		}

		return Jwts.parser()
			.setSigningKey(key)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}
}
