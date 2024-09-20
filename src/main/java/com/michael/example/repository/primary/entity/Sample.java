package com.michael.example.repository.primary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "sample", schema = "michael_test")
@ToString
@Getter
@NoArgsConstructor
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private int seq;

	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Builder
	public Sample(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}
}
