package com.michael.example.model.http;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseHeader {
	private int code;
	private String message;

	@Builder
	public ResponseHeader(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
