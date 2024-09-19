package com.michael.example.enumeration.leavestep;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum LeaveStep {
	TERM("1", "약관 동의"),
	SIGN("2", "사인");

	private final String code;
	private final String description;
}
