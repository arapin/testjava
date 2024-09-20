package com.michael.example.controller.shopping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.example.controller.shopping.converter.LoginModelToResponseConverter;
import com.michael.example.controller.shopping.converter.LoginRequestToModelConverter;
import com.michael.example.controller.shopping.dto.LoginRequest;
import com.michael.example.controller.shopping.dto.LoginResponse;
import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.model.http.ResponseMessage;
import com.michael.example.service.shopping.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
@Tag(name = "Shopping Mall Api", description = "This is an Shopping API. Please refer to it.")
public class LoginController {
	private final MemberService memberService;
	private final LoginRequestToModelConverter loginRequestToModelConverter;
	private final LoginModelToResponseConverter loginModelToResponseConverter;

	@PostMapping(value = {"/login"})
	@Operation(summary = "고객 로그인 API", description = "고객정보를 조회후에 Jwt token을 반환한다.")
	public ResponseMessage<LoginResponse> login(@RequestBody LoginRequest request) {
		return ResponseMessage.success(
			loginModelToResponseConverter.convertLoginModelToResponse(
				memberService.loginMember(
					loginRequestToModelConverter.convertLoginRequestToModel(request)
				)
			),
			ResponseStatus.LOGIN_SUCCESS.getMessage()
		);
	}
}
