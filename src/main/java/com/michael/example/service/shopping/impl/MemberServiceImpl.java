package com.michael.example.service.shopping.impl;

import org.springframework.stereotype.Service;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;
import com.michael.example.repository.primary.shopping.MemberRepository;
import com.michael.example.service.shopping.MemberService;
import com.michael.example.service.shopping.model.LoginMemberModel;
import com.michael.example.service.shopping.model.MemberCondition;
import com.michael.example.service.shopping.model.converter.MemberEntityToModelConverter;
import com.michael.example.util.AuthUtil;
import com.michael.example.util.JwtTokenUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;
	private final MemberEntityToModelConverter memberEntityToModelConverter;

	/**
	* 주어진 로그인 모델 정보를 바탕으로 회원을 로그인 처리합니다.
	*
	* @param model 로그인하려는 회원의 정보가 담긴 모델
	* @return 로그인한 회원의 정보가 담긴 모델
	* @throws ApiException 회원 정보가 유효하지 않거나 존재하지 않을 경우 발생
	*/
	public LoginMemberModel loginMember(LoginMemberModel model) {
		LoginMemberModel loginModel = memberEntityToModelConverter.convertMemberEntityToModel(
			memberRepository.loginMemberInfo(
				MemberCondition.builder()
					.id(model.getId())
					.password(model.getPassword())
					.build()
			)
		);

		if (!loginModel.validate()) {
			throw new ApiException(ResponseStatus.DATA_NOT_FOUND);
		}

		loginModel.jwtTockenGen();
		return loginModel;
	}

	/**
	* 주어진 사용자 ID를 통해 회원 정보를 반환하는 메소드.
	*
	* @param userId 정보를 요청하는 사용자의 ID
	* @return 해당 사용자의 로그인 회원 모델
	* @throws ApiException 인증 실패 시 또는 데이터가 유효하지 않을 경우 예외 발생
	*/
	public LoginMemberModel memberInfo(String userId) {
		// 인증 확인
		if (!AuthUtil.isLogin(userId)) {
			throw new ApiException(ResponseStatus.FORBIDDEN);
		}

		LoginMemberModel loginModel = memberEntityToModelConverter.convertMemberInfoEntityToModel(
			memberRepository.memberInfo(
				MemberCondition.builder()
					.id(userId)
					.build()
			)
		);

		if (!loginModel.validate()) {
			throw new ApiException(ResponseStatus.DATA_NOT_FOUND);
		}

		return loginModel;
	}
}
