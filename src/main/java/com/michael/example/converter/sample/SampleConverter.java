package com.michael.example.converter.sample;

import com.michael.example.controller.sample.dto.SampleDto;
import com.michael.example.controller.sample.dto.SampleUpdateDto;
import com.michael.example.service.sample.model.SampleModel;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleConverter {
	/***
	 * SampleModelList <-> SampleDtoList Converter
	 * @param sampleModelList List<SampleModel>
	 * @return List<SampleDto>
	 */
	List<SampleDto> convertSampleModelListToSampleDtoList(List<SampleModel> sampleModelList);

	/***
	 * SampleModel <-> SampleDto Converter
	 * @param sampleModel SampleModel
	 * @return SampleDto
	 */
	SampleDto convertSampleModelToSampleDto(SampleModel sampleModel);

	/***
	 * SampleDto <-> SampleModel Converter
	 * @param sampleDto SampleDto
	 * @return SampleModel
	 */
	SampleModel convertSampleDtoToSampleModel(SampleDto sampleDto);

	/***
	 * SampleUpdateDto <-> SampleModel Converter
	 * @param sampleDto SampleDto
	 * @return SampleModel
	 */
	SampleModel convertSampleUpdateDtoToSampleModel(SampleUpdateDto sampleDto);
}
