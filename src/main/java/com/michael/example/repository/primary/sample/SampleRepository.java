package com.michael.example.repository.primary.sample;

import java.util.List;

import com.michael.example.repository.primary.entity.SampleBoundEntity;
import com.michael.example.service.sample.model.SampleModel;

public interface SampleRepository {
	/***
	 * Sample 조회
	 * @return List<SampleEntity>
	 */
	List<SampleBoundEntity> selectSampleTestData();

	/***
	 * Sample 저장
	 * @param sampleModel SampleModel
	 */
	void insertSampleTestData(SampleModel sampleModel);

	/***
	 * Sample 수정
	 * @param sampleModel SampleModel
	 */
	void updateSampleTestData(SampleModel sampleModel);

	/***
	 * Sample 조건 검색
	 * @param seq int
	 * @return SampleBoundEntity
	 */
	SampleBoundEntity selectSampleTestDataById(int seq);

	/***
	 * Sample 삭제
	 * @param seq int
	 */
	void deleteSampleTestData(int seq);
}
