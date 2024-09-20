package com.michael.example.controller.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginResponse {
	private String token;

	@Builder
	public LoginResponse(String token) {
		this.token = token;
	}
}
