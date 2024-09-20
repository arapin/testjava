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
