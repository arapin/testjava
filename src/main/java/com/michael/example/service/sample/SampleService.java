package com.michael.example.service.sample;

import com.michael.example.service.sample.model.SampleModel;

import java.util.List;

public interface SampleService {
	/***
	 * Sample Data 조회
	 * @return List<SampleModel>
	 */
	List<SampleModel> selectSampleData();

	/***
	 * Sample Data 조건 조회
	 * @param seq int
	 * @return SampleModel
	 */
	SampleModel selectSampleOneData(int seq);

	/***
	 * Sample Data 저장
	 * @param sampleModel SampleModel
	 */
	void sampleDataSaved(SampleModel sampleModel);

	/***
	 * Sample Data 수정
	 * @param sampleModel SampleModel
	 */
	void sampleDataUpdated(SampleModel sampleModel);

	/***
	 * Sample Data 삭제
	 * @param seq int
	 */
	void sampleDataDeleted(int seq);
}
