package com.michael.example.controller.shopping.converter;

import org.mapstruct.Mapper;

import com.michael.example.controller.shopping.dto.MemberResponse;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface MemberModelToResponseConverter {
    /**
     * LoginMemberModel 객체를 MemberResponse 객체로 변환합니다.
     *
     * @param model 변환할 LoginMemberModel 객체
     * @return 변환된 MemberResponse 객체
     */
	MemberResponse convertMemberModelToResponse(LoginMemberModel model);
}
