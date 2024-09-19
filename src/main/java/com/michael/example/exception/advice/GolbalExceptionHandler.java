package com.michael.example.exception.advice;

import com.michael.example.exception.ApiException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The GolbalExceptionHandler class is used to handle exceptions that occur within the API.
 * It provides a method to handle ApiException and return an appropriate response.
 */
@Slf4j
@RestControllerAdvice
public class GolbalExceptionHandler {
	@ExceptionHandler(ApiException.class)
	// public ResponseMessage<Void> handleApiException(ApiException exception){ // HttpStatus는 200으로 고정 헤더에 데이터 에러에 대한 부분을 넘겨줌
	public ResponseEntity<String> handleApiException(ApiException exception) {  // HttpStatus는 에러에 알맞게 변경
		// return ResponseMessage.fail(exception.getResponseStatus(), null); // HttpStatus는 200으로 고정 헤더에 데이터 에러에 대한 부분을 넘겨줌
		return ResponseEntity.status(exception.getResponseStatus().getHttpStatusCode())
			.body(exception.getResponseStatus().getMessage()); // HttpStatus는 에러에 알맞게 변경
	}
}
