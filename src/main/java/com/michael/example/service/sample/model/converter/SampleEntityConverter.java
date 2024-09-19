package com.michael.example.service.sample.model.converter;

import com.michael.example.repository.primary.sample.entity.SampleBoundEntity;
import com.michael.example.service.sample.model.SampleModel;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleEntityConverter {
	/***
	 * SampleEntityList <-> SampleModelList Converter
	 * @param sampleEntityList List<SampleEntity>
	 * @return List<SampleModel>
	 */
	List<SampleModel> convertSampleEntityListToSampleModelList(List<SampleBoundEntity> sampleEntityList);

	SampleModel convertSampleEntityToSampleModel(SampleBoundEntity sampleBoundEntity);
}
