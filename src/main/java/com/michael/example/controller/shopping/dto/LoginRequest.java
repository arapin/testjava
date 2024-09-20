package com.michael.example.controller.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginRequest {
	private String id;
	private String password;

	@Builder
	public LoginRequest(String id, String password) {
		this.id = id;
		this.password = password;
	}
}
