package com.michael.example.service.shopping.model;

import com.michael.example.util.EncDecUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberCondition {
	private String id;
	private String password;

	@Builder
	public MemberCondition(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String passwordEncrypt() {
		return EncDecUtil.sha256(this.password);
	}
}
