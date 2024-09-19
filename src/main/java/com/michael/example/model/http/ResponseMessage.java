package com.michael.example.model.http;

import org.springframework.http.ResponseEntity;

import com.michael.example.enumeration.http.ResponseStatus;

import lombok.Data;

@Data
public class ResponseMessage<T> {
	private ResponseHeader header;
	private T data;
	private String msg;

	private static final int SUCCESS = 200;
	private static final int CREATE_SUCCESS = 201;

	public ResponseMessage(ResponseHeader header, T data, String msg) {
		this.header = header;
		this.data = data;
		this.msg = msg;
	}

	public static <T> ResponseMessage<T> success(T data, String message) {
		return new ResponseMessage<T>(new ResponseHeader(SUCCESS, "SUCCESS"), data, message);
	}

	public static ResponseEntity<String> successCreate() {
		return ResponseEntity.status(ResponseStatus.CUSTOMER_CREATE_SUCCESS.getHttpStatusCode())
			.body(ResponseStatus.CUSTOMER_CREATE_SUCCESS.getMessage());
	}

	public static <T> ResponseMessage<T> fail(ResponseStatus responseCode, T data) {
		return new ResponseMessage<T>(new ResponseHeader(responseCode.getHttpStatusCode(), responseCode.getMessage()),
			data, responseCode.getMessage());
	}
}
