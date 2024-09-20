package com.michael.example.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;

public class AuthUtil {
	public static boolean isLogin(String userId) {
		String jwtUserId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!jwtUserId.equals(userId)) {
			throw new ApiException(ResponseStatus.FORBIDDEN);
		}
		return true;
	}
}
