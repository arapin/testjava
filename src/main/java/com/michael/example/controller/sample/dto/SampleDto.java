package com.michael.example.controller.sample.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleDto {
	private int seq;
	private String id;
	private String name;

	@Builder
	public SampleDto(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}
}
