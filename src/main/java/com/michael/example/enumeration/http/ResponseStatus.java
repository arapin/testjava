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
	ID_NUMBER_BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "외국인 등록번호 자릿수가 잘못 되었습니다."),
	LOAN_LIMIT_BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "대출조건이 맞지 않습니다 (6개월 이하로 남은 만료일)"),
	CONTACT_BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "고객의 연락처 3명 모두 입력하여 주십시요."),

	// 403 Forbidden
	FORBIDDEN(HttpStatus.FORBIDDEN, false, "권한이 없습니다."),

	// 404 Not Found
	DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "데이터가 없습니다."),
	CUSTOMER_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객 정보가 없습니다."),
	OPENBANK_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 오픈뱅킹 정보가 없습니다."),
	LOAN_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 대출 정보가 없습니다."),
	ID_IMAGE_FRONT_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 외국인 등록증(앞면) 정보가 없습니다."),
	FILE_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, false, "찾고자 하는 파일이 존재 하지 않습니다."),
	CUSTOMER_VISA_EXPIRY_DATE_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 여권 만료일을 찾을수 없습니다."),
	CUSTOMER_ACCOUNT_LIST_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 거래내역을 찾을수 없습니다."),
	CUSTOMER_LEAVE_STEP_NOT_FOUND(HttpStatus.NOT_FOUND, false, "고객의 이탈 단계를 찾을수 없습니다."),

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
	ACCOUNT_LOG_INSERT_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false,
		"고객 오픈뱅킹 조회 API LOG 저장시에 서버에 오류가 발생하였습니다."),

	// 200 OK
	TEST_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 조회 성공"),
	SAMPLE_REGIST_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 등록 성공"),
	SAMPLE_UPDATE_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 수정 성공"),
	SAMPLE_DELETE_SUCCESS(HttpStatus.OK, true, "SAMPLE DATA 삭제 성공"),
	CUSTOMER_AGREE_SUCCESS(HttpStatus.OK, true, "고객 동의 정보 조회 성공"),
	CUSTOMER_AGREE_UPDATE_SUCCESS(HttpStatus.OK, true, "고객 동의 정보 수정 성공"),
	OPENBANK_SUCCESS(HttpStatus.OK, true, "고객 오픈뱅킹 정보 조회 성공"),
	OPENBANK_INFO_SAVE_SUCCESS(HttpStatus.OK, true, "고객 오픈뱅킹 정보 저장 성공"),
	CUSTOMER_ACCOUNT_LOG_SUCCESS(HttpStatus.OK, true, "고객 오픈뱅킹 정보 조회 LOG 저장 성공"),
	CUSTOMER_DETAIL_CASE_INFO_SUCCESS(HttpStatus.OK, true, "고객 정보 조회 성공"),
	CUSTOMER_ID_FRONT_SAVE_SUCCESS(HttpStatus.OK, true, "고객 외국인 등록증 앞면 저장 성공"),
	CUSTOMER_ID_BACK_SAVE_SUCCESS(HttpStatus.OK, true, "고객 외국인 등록증 뒷면 저장 성공"),
	CUSTOMER_PASSPORT_SAVE_SUCCESS(HttpStatus.OK, true, "고객 여권 저장 성공"),
	CUSTOMER_WORK_CONTRACT_FRONT_SAVE_SUCCESS(HttpStatus.OK, true, "고객 근로자 계약서 앞면 저장 성공"),
	CUSTOMER_WORK_CONTRACT_BACK_SAVE_SUCCESS(HttpStatus.OK, true, "고객 근로자 계약서 뒷면 저장 성공"),
	CUSTOMER_LOAN_APPLY_INFO_SUCCESS(HttpStatus.OK, true, "고객 대출 정보 조회 성공"),
	CUSTOMER_LOAN_LIMIT_INFO_SUCCESS(HttpStatus.OK, true, "고객 대출 한도 설정 성공"),
	CUSTOMER_LOAN_MONTHLY_MONEY_INFO_SUCCESS(HttpStatus.OK, true, "고객 대출 월납입 금액 조회 성공"),
	CUSTOMER_LOAN_MONTHLY_MONEY_SAVE_SUCCESS(HttpStatus.OK, true, "고객 대출 월납입 금액 저장 성공"),
	CUSTOMER_FACEBOOK_PROFILE_SAVE_SUCCESS(HttpStatus.OK, true, "고객 페이스북 프로필 사진 저장 성공"),
	CUSTOMER_FAMILY_RELATIONSHIP_SAVE_SUCCESS(HttpStatus.OK, true, "고객 가족관계 사진 저장 성공"),
	CUSTOMER_CONTACT_SAVE_SUCCESS(HttpStatus.OK, true, "고객 비상연락망 저장 성공"),
	CUSTOMER_OPEN_BANK_INFO_SUCCESS(HttpStatus.OK, true, "고객 오픈뱅킹 정보 조회 성공"),
	CUSTOMER_OPEN_BANK_TRAMSACTION_INFO_SUCCESS(HttpStatus.OK, true, "고객 오픈뱅킹 계좌 및 거래내역 정보 조회 성공"),
	CUSTOMER_LEAVE_STEP_INFO_SUCCESS(HttpStatus.OK, true, "고객 이탈 단계 조회 성공"),
	CUSTOMER_LEAVE_STEP_SAVE_SUCCESS(HttpStatus.OK, true, "고객 이탈 단계 저장 성공"),

	// 201 Created
	CUSTOMER_CREATE_SUCCESS(HttpStatus.CREATED, true, "고객정보 생성 성공");

	private final HttpStatus httpStatus;
	private final Boolean success;
	private final String message;

	public int getHttpStatusCode() {
		return httpStatus.value();
	}
}
