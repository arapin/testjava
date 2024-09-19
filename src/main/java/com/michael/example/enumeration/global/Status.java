package com.michael.example.enumeration.global;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Status class represents the status of an entity.
 * It is an enumeration class that defines two status values: "Y" and "N".
 * Each status value has a corresponding code and a description.
 * The code is a string representation of the status value,
 * and the description provides a human-readable explanation of the status.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum Status {
	STATUS_Y("Y", "yes"),
	STATUS_N("N", "no");

	private final String code;
	private final String desc;
}
