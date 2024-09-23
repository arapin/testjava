package com.michael.example.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;

public class AuthUtil {
	/**
	 * 주어진 값이 현재 로그인된 사용자의 JWT Sub와 일치하는지 확인합니다.
	 *
	 * @param value 확인할 값
	 * @return boolean 값이 일치하면 true를 반환
	 * @throws ApiException 값이 일치하지 않으면 FORBIDDEN 상태로 예외를 던짐
	 */
	public static boolean isLogin(String value) {
		String jwtSub = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!jwtSub.equals(value)) {
			throw new ApiException(ResponseStatus.FORBIDDEN);
		}
		return true;
	}
}
