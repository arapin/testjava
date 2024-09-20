package com.michael.example.controller.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberResponse {
	private String id;
	private String name;

	@Builder
	public MemberResponse(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
