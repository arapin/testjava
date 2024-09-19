package com.michael.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.michael.example.constant.GlobalConstants;

public class DateUtil {
	/**
	 * Calculate the difference in months between a given start date and the current date.
	 *
	 * @param startDate The start date to calculate the difference from. Cannot be null.
	 * @return The difference in months between the start date and the current date. If the day of the start date is the same as the current date, the difference is increased by 1.
	 */
	public static long getDateDiffMonth(LocalDate startDate){
		LocalDate today = LocalDate.now();
		long diffMonth = ChronoUnit.MONTHS.between(today, startDate);
		if (startDate.getDayOfMonth() == today.getDayOfMonth()) {
			diffMonth += 1;
		}
		return diffMonth;
	}

	/**
	 * Calculates the loan end date based on the given loan basic date.
	 *
	 * @param loanBasicDate The loan basic date as a LocalDate object. Cannot be null.
	 * @return The loan end date formatted as a String. It is a combination of two date formats: ApplyConstants.LOAN_END_DATE_FORMAT and ApplyConstants.LOAN_END_DATE_FORMAT2.
	 */
	public static String loanEndDate(LocalDate loanBasicDate){
		String loanEndDate1 = loanBasicDate.format(
			DateTimeFormatter.ofPattern(GlobalConstants.LOAN_END_DATE_FORMAT));
		String loanEndDate2 = loanBasicDate.withDayOfMonth(loanBasicDate.lengthOfMonth())
			.format(DateTimeFormatter.ofPattern(GlobalConstants.LOAN_END_DATE_FORMAT2));
		return loanEndDate1 + loanEndDate2;
	}

	/**
	 * Calculates the difference in months between the given date and the current date.
	 *
	 * @param diffDate The date to calculate the difference from. Cannot be null.
	 * @return The difference in months between the given date and the current date.
	 */
	public static Long monthTerm(LocalDate diffDate){
		return ChronoUnit.MONTHS.between(LocalDate.now(), diffDate);
	}
}
