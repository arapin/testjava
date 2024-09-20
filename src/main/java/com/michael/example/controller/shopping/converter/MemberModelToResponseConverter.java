package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;

import com.michael.example.controller.shopping.dto.MemberResponse;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface MemberModelToResponseConverter {
	MemberResponse convertMemberModelToResponse(LoginMemberModel model);
}
