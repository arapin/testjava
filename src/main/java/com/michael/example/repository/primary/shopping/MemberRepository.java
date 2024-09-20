package com.michael.example.repository.primary.shopping;

import com.michael.example.repository.primary.entity.MemberBoundEntity;
import com.michael.example.service.shopping.model.MemberCondition;

public interface MemberRepository {
	MemberBoundEntity loginMemberInfo(MemberCondition condition);
	MemberBoundEntity memberInfo(MemberCondition condition);
}
