package com.michael.example.service.sample.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;
import com.michael.example.service.sample.model.SampleModel;
import com.michael.example.service.sample.model.converter.SampleEntityConverter;
import com.michael.example.repository.primary.sample.SampleRepository;
import com.michael.example.service.sample.SampleService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	private final SampleRepository sampleRepository;
	private final SampleEntityConverter sampleEntityConverter;

	/***
	 * Sample Data 조회
	 * @return List<SampleModel>
	 */
	@Override
	public List<SampleModel> selectSampleData() {
		List<SampleModel> dataLists = sampleEntityConverter.convertSampleEntityListToSampleModelList(
			sampleRepository.selectSampleTestData());

		if (CollectionUtils.isEmpty(dataLists)) {
			throw new ApiException(ResponseStatus.DATA_NOT_FOUND);
		}
		return dataLists;
	}

	/***
	 * Sample Data 조건 조회
	 * @param seq int
	 * @return SampleModel
	 */
	@Override
	public SampleModel selectSampleOneData(int seq) {
		SampleModel data = sampleEntityConverter.convertSampleEntityToSampleModel(
			sampleRepository.selectSampleTestDataById(seq));

		if (!data.validate()) {
			throw new ApiException(ResponseStatus.DATA_NOT_FOUND);
		}

		return data;
	}

	/***
	 * Sample Data 저장
	 * @param sampleModel SampleModel
	 */
	@Transactional
	@Override
	public void sampleDataSaved(SampleModel sampleModel) {
		try {
			sampleRepository.insertSampleTestData(sampleModel);
		} catch (Exception exception) {
			throw new ApiException(ResponseStatus.DATABASE_INSERT_SERVER_ERROR);
		}
	}

	/***
	 * Sample Data 수정
	 * @param sampleModel SampleModel
	 */
	@Transactional
	@Override
	public void sampleDataUpdated(SampleModel sampleModel) {
		try {
			sampleRepository.updateSampleTestData(sampleModel);
		} catch (Exception exception) {
			throw new ApiException(ResponseStatus.DATABASE_UPDATE_SERVER_ERROR);
		}
	}

	/***
	 * Sample Data 수정
	 * @param seq int
	 */
	@Transactional
	@Override
	public void sampleDataDeleted(int seq) {
		try {
			sampleRepository.deleteSampleTestData(seq);
		} catch (Exception exception) {
			throw new ApiException(ResponseStatus.DATABASE_DELETE_SERVER_ERROR);
		}
	}
}
