package com.michael.example.repository.primary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MemberBoundEntity {
	private Integer seq;
	private String id;
	private String password;
	private String name;
	private String lastLogin;
	private String createDate;

	@Builder
	public MemberBoundEntity(Integer seq, String id, String password, String name, String lastLogin,
		String createDate) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.lastLogin = lastLogin;
		this.createDate = createDate;
	}
}
