package com.michael.example.controller.sample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class SampleUpdateDto {
	private int seq;
	private String id;
	private String name;

	@Builder
	public SampleUpdateDto(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}
}
