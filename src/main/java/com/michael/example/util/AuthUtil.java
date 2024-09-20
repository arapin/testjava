package com.michael.example.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;

public class AuthUtil {
	public static boolean isLogin(String value) {
		String jwtSub = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!jwtSub.equals(value)) {
			throw new ApiException(ResponseStatus.FORBIDDEN);
		}
		return true;
	}
}
