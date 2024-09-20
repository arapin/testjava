package com.michael.example.service.shopping.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.michael.example.repository.primary.entity.MemberBoundEntity;
import com.michael.example.service.shopping.model.LoginMemberModel;

@Mapper(componentModel = "spring")
public interface MemberEntityToModelConverter {

	/**
	 * 주어진 MemberBoundEntity 객체를 LoginMemberModel 객체로 변환합니다.
	 * 비밀번호와 토큰 필드는 무시됩니다.
	 *
	 * @param entity 변환할 MemberBoundEntity 객체
	 * @return 변환된 LoginMemberModel 객체
	 */
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertMemberEntityToModel(MemberBoundEntity entity);

	/**
	 * 주어진 MemberBoundEntity 객체를 LoginMemberModel 객체로 변환합니다.
	 * 비밀번호와 토큰 필드는 무시됩니다.
	 *
	 * @param entity 변환할 MemberBoundEntity 객체
	 * @return 변환된 LoginMemberModel 객체
	 */
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "token", ignore = true)
	LoginMemberModel convertMemberInfoEntityToModel(MemberBoundEntity entity);

}
