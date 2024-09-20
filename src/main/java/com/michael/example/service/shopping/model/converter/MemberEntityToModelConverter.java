package com.michael.example.service.shopping.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.michael.example.repository.primary.entity.MemberBoundEntity;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface MemberEntityToModelConverter {
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertMemberEntityToModel(MemberBoundEntity entity);

	@Mapping(target = "password", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertMemberInfoEntityToModel(MemberBoundEntity entity);
}
