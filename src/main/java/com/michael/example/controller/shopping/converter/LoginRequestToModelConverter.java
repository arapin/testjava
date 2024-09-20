package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.michael.example.controller.shopping.dto.LoginRequest;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface LoginRequestToModelConverter {
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertLoginRequestToModel(LoginRequest request);
}
