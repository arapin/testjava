package com.michael.example.repository.primary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SampleBoundEntity {
	private int seq;
	private String id;
	private String name;

	@Builder
	public SampleBoundEntity(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}

}
