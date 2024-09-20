package com.michael.example.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import io.jsonwebtoken.Jwts;

public class JwtTokenUtil {
	private static String key = "18305813a67445ba77f31aac2b3197f70566b0577b474843dec4c97dc616a86bc01d2782d7220a9d9c34d1cf3d8b661c61f4bc3307333a88793f2e8114effcbd";

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
