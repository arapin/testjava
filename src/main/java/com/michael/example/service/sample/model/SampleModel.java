package com.michael.example.service.sample.model;

import org.apache.commons.lang3.StringUtils;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleModel {
	private int seq;
	private String id;
	private String name;

	@Builder
	public SampleModel(int seq, String id, String name) {
		this.seq = seq;
		this.id = id;
		this.name = name;
	}

	public boolean validate() {
		return StringUtils.isNotBlank(id) || StringUtils.isNotBlank(name);
	}
}
