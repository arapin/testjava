package com.michael.example.service.impl;

import com.michael.example.converter.sample.SampleConverter;
import com.michael.example.service.sample.model.converter.SampleEntityConverter;
import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;
import com.michael.example.repository.primary.sample.SampleRepository;
import com.michael.example.service.sample.impl.SampleServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("SampleService 클래스의")
@DataJpaTest
class SampleServiceImplTest {
    //mock 설정부분
    @Mock
    SampleServiceImpl sampleService;

    @Mock
    SampleRepository sampleRepository;

    @Mock
    SampleConverter sampleConverter;

    @Mock
    SampleEntityConverter sampleEntityConverter;

    //테스트할 클래스

    //테스트할 클래스 생성
    @BeforeEach
    void init() {
        sampleService = new SampleServiceImpl(sampleRepository, sampleEntityConverter);
    }

    /*테스트 METHOD를 입력하여주십시요*/
    @Nested // Describe 의 여러건에 대한 처리 입니다.
    @Order(1) // 현 Test 진행 시 Describe 의 테스트 진행 순서입니다.
    @TestClassOrder(ClassOrderer.OrderAnnotation.class) // 순서 처리를 위한 주석입니다.
    @DisplayName("test 메서드의")
    class Describe_test { // Describe_매서드명칭 으로 메서드 정의 합니다. METHOD는 테스트를할 method로 대체하여 주십시요.

        /*Context를 작성해주십시요.*/
        @Nested
        @Order(1) //실행순서 -> 알맞게 변경
        @DisplayName("반환값이 없으면") //화면에 보여질 명칭
        class Context_returnTest { //TEST에 알맞는 상황을 영문으로 입력하시오.
            //사용될 클래스를 선언
            ApiException expected;

            //테스트전 데이터 지정
            @BeforeEach
            void init() {
                expected = new ApiException(ResponseStatus.DATA_NOT_FOUND);
            }

            /*테스트 코드를 작성하여 주십시요.*/
            //실제 테스트
            @Test
            @DisplayName("에러를 반환 한다.")
            void It_willTesting() { // 원하는 기대치 대로 나오는지 테스트를 진행 합니다. will 다음에 기대하는 리턴값의 영문으로 적는다.
                // given 기대하는 데이터를 설정

                //실제 메소드를 실행하는 부분 when
                ApiException actual = assertThrows(ApiException.class, () -> {
                    /* WHEN */
                    sampleService.selectSampleData();
                });

                //원하는 결과값과 테스트해서 나오는 결과값을 비교하는 부분 then
                assertEquals(expected.getResponseStatus().getHttpStatusCode(), actual.getResponseStatus().getHttpStatusCode());
            }

            /*테스트 코드를 작성하여 주십시요.*/
        }
        /*Context를 작성해주십시요.*/
    }
    /*테스트 METHOD를 입력하여주십시요*/
}