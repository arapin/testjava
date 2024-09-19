package com.michael.example.exception;

import com.michael.example.enumeration.http.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The GolbalException class represents a global exception that can be thrown in the application.
 * It extends the RuntimeException class.
 */
@AllArgsConstructor
@Getter
public class GolbalException extends RuntimeException {
	private final ResponseStatus responseStatus;

	@Override
	public String getMessage() {
		return responseStatus.getMessage();
	}
}
