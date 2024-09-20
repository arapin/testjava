package com.michael.example.repository.primary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Table(name = "member", schema = "michael_test")
@ToString
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq", nullable = false)
	private Integer seq;

	@Size(max = 20)
	@Column(name = "id", length = 20)
	private String id;

	@Size(max = 255)
	@Column(name = "password")
	private String password;

	@Size(max = 50)
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "last_login")
	private String lastLogin;

	@Column(name = "create_date")
	private String createDate;

	@Builder
	public Member(Integer seq, String id, String password, String name, String lastLogin, String createDate) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.lastLogin = lastLogin;
		this.createDate = createDate;
	}
}