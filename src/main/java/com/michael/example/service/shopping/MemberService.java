package com.michael.example.service.shopping;

import com.michael.example.service.shopping.model.LoginMemberModel;

public interface MemberService {
	LoginMemberModel loginMember(LoginMemberModel loginMemberModel);
	LoginMemberModel memberInfo(String userId);
}
