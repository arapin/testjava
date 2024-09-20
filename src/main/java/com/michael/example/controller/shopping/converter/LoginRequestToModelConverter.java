package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.michael.example.controller.shopping.dto.LoginRequest;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface LoginRequestToModelConverter {
    /**
     * LoginRequest 객체를 LoginMemberModel 객체로 변환합니다.
     *
     * @param request 변환할 LoginRequest 객체
     * @return 변환된 LoginMemberModel 객체
     */
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertLoginRequestToModel(LoginRequest request);
}
