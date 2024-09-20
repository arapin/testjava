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
