package com.michael.example.model.log;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LogInsertModel {
	private long customerId;
	private long loanAppNo;
	private String div;
	private String sendUrl;
	private String requestDate;
	private String requestBody;
	private String responseBody;
	private String saveTime;

	@Builder
	public LogInsertModel(long customerId, long loanAppNo, String div, String sendUrl, String requestDate,
		String requestBody, String responseBody, String saveTime) {
		this.customerId = customerId;
		this.loanAppNo = loanAppNo;
		this.div = div;
		this.sendUrl = sendUrl;
		this.requestDate = requestDate;
		this.requestBody = requestBody;
		this.responseBody = responseBody;
		this.saveTime = saveTime;
	}
}
