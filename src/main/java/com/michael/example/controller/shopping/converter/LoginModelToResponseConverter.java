package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;

import com.michael.example.controller.shopping.dto.LoginResponse;
import com.michael.example.controller.shopping.dto.MemberResponse;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface LoginModelToResponseConverter {
	LoginResponse convertLoginModelToResponse(LoginMemberModel model);

}
