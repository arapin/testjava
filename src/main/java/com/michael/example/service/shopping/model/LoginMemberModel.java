package com.michael.example.service.shopping.model;

import org.apache.commons.lang3.StringUtils;

import com.michael.example.util.JwtTokenUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginMemberModel {
	private String id;
	private String name;
	private String password;
	private String token;

	@Builder
	public LoginMemberModel(String id, String name, String password, String token) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.token = token;
	}

	public boolean validate() {
		return StringUtils.isNotBlank(this.id) || StringUtils.isNotBlank(this.name);
	}
	public void jwtTockenGen() {
		this.token = JwtTokenUtil.generateToken(this.id);
	}
}
