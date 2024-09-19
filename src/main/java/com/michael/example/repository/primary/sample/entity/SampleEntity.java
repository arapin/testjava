package com.michael.example.repository.primary.sample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@SequenceGenerator(
	name = "sample_no_gen",
	sequenceName = "sample_seq",
	allocationSize = 1
)
@Table(name = "Sample")
@ToString
@Getter
@NoArgsConstructor
public class SampleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_no_gen")
	@Column(name = "no")
	private int seq;

	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Builder
	public SampleEntity(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}
}
