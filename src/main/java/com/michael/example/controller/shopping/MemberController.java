package com.michael.example.controller.shopping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.example.controller.shopping.converter.MemberModelToResponseConverter;
import com.michael.example.controller.shopping.dto.MemberResponse;
import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.model.http.ResponseMessage;
import com.michael.example.service.shopping.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
@Tag(name = "Shopping Mall Member Api", description = "This is an Shopping Member API. Please refer to it.")
public class MemberController {
	private final MemberService memberService;
	private final MemberModelToResponseConverter memberModelToResponseConverter;

	/**
	 * 고객 정보조회 API
	 *
	 * 이 메서드는 주어진 사용자 ID를 사용하여 고객정보를 조회하고,
	 * 응답 메시지를 반환합니다. 이 API는 JWT 토큰을 사용한 인증이 필요합니다.
	 *
	 * @param userId 조회할 사용자의 ID
	 * @return 고객 정보가 포함된 응답 메시지
	 */
	@GetMapping(value = {"/member/{userId}"})
	@Operation(summary = "고객 정보조회 API", description = "고객정보를 조회하여 응답한다. (로그인을 한후에 나온 JWT Token을 이용하여 인증을 한다.)", security = {
		@SecurityRequirement(name = "Authorization")})
	public ResponseMessage<MemberResponse> memberInfo(@PathVariable String userId) {
		return ResponseMessage.success(
			memberModelToResponseConverter.convertMemberModelToResponse(
				memberService.memberInfo(userId)
			),
			ResponseStatus.CUSTOMER_INFO_SELECT_SUCCESS.getMessage()
		);
	}
}
