package com.michael.example.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.michael.example.constant.GlobalConstants;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("DateUtil 클래스의")
@DataJpaTest
class DateUtilTest {
	//mock 설정부분
	//테스트할 클래스

	//테스트할 클래스 생성
	@BeforeEach
	void init() {
	}

	/*테스트 METHOD를 입력하여주십시요*/
	@Nested // Describe 의 여러건에 대한 처리 입니다.
	@Order(1) // 현 Test 진행 시 Describe 의 테스트 진행 순서입니다.
	@TestClassOrder(ClassOrderer.OrderAnnotation.class) // 순서 처리를 위한 주석입니다.
	@DisplayName("getDateDiffMonth 메서드의")
	class Describe_test {
		/*Context를 작성해주십시요.*/
		@Nested
		@Order(1) //실행순서 -> 알맞게 변경
		@DisplayName("정상적인 날짜를 넣으면 금일과 비교를 하여") //화면에 보여질 명칭
		class Context_getDateDiffMonthTest {
			//사용될 클래스를 선언
			long expected;

			//테스트전 데이터 지정
			@BeforeEach
			void init() {
				expected = 11;
			}

			/*테스트 코드를 작성하여 주십시요.*/
			//실제 테스트
			@Test
			@DisplayName("올바른 결과 값을 반환 한다.")
			void It_willTesting() {
				// given 기대하는 데이터를 설정
				LocalDate actualDate = LocalDate.parse("2025-08-23");
				//실제 메소드를 실행하는 부분 when
				long actual = DateUtil.getDateDiffMonth(actualDate);
				//원하는 결과값과 테스트해서 나오는 결과값을 비교하는 부분 then
				assertEquals(expected, actual);
			}
		}

		/*Context를 작성해주십시요.*/
		@Nested
		@Order(2) //실행순서 -> 알맞게 변경
		@DisplayName("정상적인 날짜를 넣으면 금일을 활용하여서") //화면에 보여질 명칭
		class Context_loanEndDateTest {
			//사용될 클래스를 선언
			String expected;

			//테스트전 데이터 지정
			@BeforeEach
			void init() {
				expected = "20241031";
			}

			/*테스트 코드를 작성하여 주십시요.*/
			//실제 테스트
			@Test
			@DisplayName("올바른 결과 값을 반환 한다.")
			void It_willTesting() {
				// given 기대하는 데이터를 설정
				LocalDate actualDate = LocalDate.now().plusMonths(1);
				//실제 메소드를 실행하는 부분 when
				String actual = DateUtil.loanEndDate(actualDate);
				//원하는 결과값과 테스트해서 나오는 결과값을 비교하는 부분 then
				assertEquals(expected, actual);
			}
		}

		/*Context를 작성해주십시요.*/
		@Nested
		@Order(3) //실행순서 -> 알맞게 변경
		@DisplayName("정상적인 날짜를 넣으면 입력한 날짜를 활용하여서") //화면에 보여질 명칭
		class Context_loanEndDate2Test {
			//사용될 클래스를 선언
			String expected;

			//테스트전 데이터 지정
			@BeforeEach
			void init() {
				expected = "20250531";
			}

			/*테스트 코드를 작성하여 주십시요.*/
			//실제 테스트
			@Test
			@DisplayName("올바른 결과 값을 반환 한다.")
			void It_willTesting() {
				// given 기대하는 데이터를 설정
				LocalDate actualDate = LocalDate.parse("2025-08-30").minusMonths(3);
				//실제 메소드를 실행하는 부분 when
				String actual = DateUtil.loanEndDate(actualDate);
				//원하는 결과값과 테스트해서 나오는 결과값을 비교하는 부분 then
				assertEquals(expected, actual);
			}
		}

		/*Context를 작성해주십시요.*/
		@Nested
		@Order(4) //실행순서 -> 알맞게 변경
		@DisplayName("정상적인 날짜를 넣으면 입력한 날짜를 활용하여서") //화면에 보여질 명칭
		class Context_monthTermTest {
			//사용될 클래스를 선언
			Long expected;

			//테스트전 데이터 지정
			@BeforeEach
			void init() {
				expected = Long.valueOf(116);
			}

			/*테스트 코드를 작성하여 주십시요.*/
			//실제 테스트
			@Test
			@DisplayName("올바른 결과 값을 반환 한다.")
			void It_willTesting() {
				// given 기대하는 데이터를 설정
				LocalDate actualDate = LocalDate.parse("20340823", DateTimeFormatter.ofPattern(GlobalConstants.datePathNameFormat)).minusMonths(3);
				//실제 메소드를 실행하는 부분 when
				long actual = DateUtil.monthTerm(actualDate);
				//원하는 결과값과 테스트해서 나오는 결과값을 비교하는 부분 then
				assertEquals(expected, actual);
			}
		}
	}
}