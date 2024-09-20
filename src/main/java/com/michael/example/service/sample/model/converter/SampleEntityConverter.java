package com.michael.example.service.sample.model.converter;

import com.michael.example.repository.primary.entity.SampleBoundEntity;
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

	/**
	 * Converts a SampleBoundEntity object to a SampleModel object.
	 *
	 * @param sampleBoundEntity the SampleBoundEntity object to be converted
	 * @return the corresponding SampleModel object, or null if the input is null
	 */
	SampleModel convertSampleEntityToSampleModel(SampleBoundEntity sampleBoundEntity);
}
