package com.michael.example.repository.primary.shopping.impl;

import static com.michael.example.repository.primary.entity.QMember.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.michael.example.repository.primary.entity.MemberBoundEntity;
import com.michael.example.repository.primary.shopping.MemberRepository;
import com.michael.example.service.shopping.model.MemberCondition;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	private final JPAQueryFactory jpaQueryFactory;

	public MemberRepositoryImpl(@Qualifier("primaryQueryFactory") JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	/**
	 * 주어진 조건에 따라 회원 정보를 로그인합니다.
	 *
	 * @param condition 회원 조건을 포함한 객체입니다.
	 * @return 로그인된 회원 정보를 나타내는 MemberBoundEntity 객체를 반환합니다.
	 *         조건에 해당하는 회원 정보가 없으면 새로운 MemberBoundEntity 객체를 반환합니다.
	 */
	@Override
	public MemberBoundEntity loginMemberInfo(MemberCondition condition){
		return Optional.ofNullable(
			jpaQueryFactory.select(
					Projections.bean(
						MemberBoundEntity.class,
						member.id,
						member.name
					)
				)
				.from(member)
				.where(member.id.eq(condition.getId()), member.password.eq(condition.passwordEncrypt()))
				.fetchOne()
		).orElseGet(MemberBoundEntity::new);
	}

	/**
	 * 주어진 조건에 따른 회원 정보를 반환합니다.
	 *
	 * @param condition 회원 조건을 나타내는 객체
	 * @return 회원의 정보를 담고 있는 MemberBoundEntity 객체
	 */
	@Override
	public MemberBoundEntity memberInfo(MemberCondition condition){
		return jpaQueryFactory.select(
				Projections.bean(
					MemberBoundEntity.class,
					member.id,
					member.name
				)
			)
			.from(member)
			.where(member.id.eq(condition.getId()))
			.fetchOne();
	}
}
