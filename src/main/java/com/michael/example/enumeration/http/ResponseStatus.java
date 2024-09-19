package com.michael.example.enumeration.http;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The ResponseStatus enum represents the possible response statuses for an API request.
 * It provides constants for various HTTP response statuses along with their corresponding
 * success flag and message.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum ResponseStatus {
	// 400 Bad Request
	BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "잘못된 요청입니다."),
	ID_BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "필수 요소가 없습니다."),

	// 403 Forbidden
	FORBIDDEN(HttpStatus.FORBIDDEN, false, "권한이 없습니다."),

	// 404 Not Found
	DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "데이터가 없습니다."),
	FILE_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "찾고자 하는 파일이 존재 하지 않습니다."),

	// 405 Method Not Allowed
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, false, "허용되지 않은 메소드입니다."),

	// 409 Conflict
	USER_ALREADY_EXIST(HttpStatus.CONFLICT, false, "이미 가입한 사용자입니다."),

	// 500 Internal Server Error
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "서버에 오류가 발생하였습니다."),
	CUSTOMER_CREATE_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "고객 정보 생성중 서버에 오류가 발생하였습니다."),
	DATABASE_INSERT_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "데이터 등록중 서버에 오류가 발생하였습니다."),
	DATABASE_UPDATE_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "데이터 수정중 서버에 오류가 발생하였습니다."),
	DATABASE_DELETE_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "데이터 삭제중 서버에 오류가 발생하였습니다."),
	FILE_SAVE_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, false, "파일을 저장중에 오류가 발생을 하였습니다."),

	// 200 OK
	TEST_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 조회 성공"),
	SAMPLE_REGIST_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 등록 성공"),
	SAMPLE_UPDATE_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 수정 성공"),
	SAMPLE_DELETE_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 삭제 성공"),

	// 201 Created
	CUSTOMER_CREATE_SUCCESS(HttpStatus.CREATED, true, "고객정보 생성 성공");

	private final HttpStatus httpStatus;
	private final Boolean success;
	private final String message;

	public int getHttpStatusCode() {
		return httpStatus.value();
	}
}
