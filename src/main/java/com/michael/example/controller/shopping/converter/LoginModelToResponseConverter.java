package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;

import com.michael.example.controller.shopping.dto.LoginResponse;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface LoginModelToResponseConverter {
    /**
     * 로그인 모델을 응답으로 변환합니다.
     *
     * @param model 로그인 멤버 모델
     * @return 로그인 응답
     */
	LoginResponse convertLoginModelToResponse(LoginMemberModel model);

}
