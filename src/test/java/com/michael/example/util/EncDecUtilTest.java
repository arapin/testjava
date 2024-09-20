package com.michael.example.util;

import static org.junit.jupiter.api.Assertions.*;

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

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("EncDecUtil 클래스의")
@DataJpaTest
class EncDecUtilTest {
	//mock 설정부분

	@BeforeEach
	void init() {}

	/*테스트 METHOD를 입력하여주십시요*/
	@Nested // Describe 의 여러건에 대한 처리 입니다.
	@Order(1) // 현 Test 진행 시 Describe 의 테스트 진행 순서입니다.
	@TestClassOrder(ClassOrderer.OrderAnnotation.class) // 순서 처리를 위한 주석입니다.
	@DisplayName("sha256 메서드의")
	class Describe_sha256 {
		/*Context를 작성해주십시요.*/
		@Nested
		@Order(1) //실행순서 -> 알맞게 변경
		@DisplayName("암호화한 데이터를") //화면에 보여질 명칭
		class Context_returnTest {
			//사용될 클래스를 선언
			String expected;

			//테스트전 데이터 지정
			@BeforeEach
			void init() {
				expected = "0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e";
			}

			/*테스트 코드를 작성하여 주십시요.*/
			//실제 테스트
			@Test
			@DisplayName("비교한다.")
			void It_willTesting() {
				String actual = EncDecUtil.sha256("password1");
				assertEquals(expected, actual);
			}
		}
	}
}