package com.michael.example.service.shopping;

import com.michael.example.service.shopping.model.LoginMemberModel;

public interface MemberService {
	/**
	 * 회원 로그인 메소드
	 *
	 * 주어진 로그인 정보를 기반으로 회원 로그인을 처리합니다.
	 *
	 * @param loginMemberModel 로그인 정보가 담긴 객체
	 * @return 로그인된 회원 정보를 반환
	 */
	LoginMemberModel loginMember(LoginMemberModel loginMemberModel);
	/**
	 * 회원 정보 조회 메소드
	 *
	 * 주어진 사용자 ID를 기반으로 회원 정보를 조회합니다.
	 *
	 * @param userId 회원의 사용자 ID
	 * @return 조회된 회원 정보를 반환
	 */
	LoginMemberModel memberInfo(String userId);
}
