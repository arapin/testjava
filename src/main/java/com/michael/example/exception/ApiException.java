package com.michael.example.exception;

import com.michael.example.enumeration.http.ResponseStatus;

import lombok.Getter;

/**
 * The ApiException class represents an exception specific to the API.
 * It extends the GolbalException class and is thrown when there is an error
 * in processing an API request.
 */
@Getter
public class ApiException extends GolbalException {
	public ApiException(ResponseStatus responseStatus) {
		super(responseStatus);
	}
}
