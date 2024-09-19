package com.michael.example.controller.sample;

import com.michael.example.controller.sample.dto.SampleDto;
import com.michael.example.controller.sample.dto.SampleUpdateDto;
import com.michael.example.controller.sample.converter.SampleConverter;
import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.model.http.ResponseMessage;
import com.michael.example.service.sample.SampleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
@Tag(name = "Michael Test Api Example", description = "This is an API example. Please refer to it.")
public class ExampleController {
	private final SampleService sampleService;
	private final SampleConverter converter;

	@GetMapping(value = {"/sample"})
	public ResponseMessage<List<SampleDto>> sample() {
		List<SampleDto> result = converter.convertSampleModelListToSampleDtoList(sampleService.selectSampleData());
		return ResponseMessage.success(result, ResponseStatus.TEST_SUCCESS.getMessage());
	}

	@GetMapping(value = {"/sample/{seq}"})
	public ResponseMessage<SampleDto> sampleDataConditionSelect(@PathVariable int seq) {
		return ResponseMessage.success(converter.convertSampleModelToSampleDto(sampleService.selectSampleOneData(seq)),
			ResponseStatus.TEST_SUCCESS.getMessage());
	}

	@PostMapping(value = {"/sample"})
	public ResponseMessage<Void> sampleRegist(@RequestBody SampleDto dto) {
		sampleService.sampleDataSaved(converter.convertSampleDtoToSampleModel(dto));
		return ResponseMessage.success(null, ResponseStatus.SAMPLE_REGIST_SUCCESS.getMessage());
	}

	@PutMapping(value = {"/sample"})
	public ResponseMessage<Void> sampleUpdate(@RequestBody SampleUpdateDto dto) {
		sampleService.sampleDataUpdated(converter.convertSampleUpdateDtoToSampleModel(dto));
		return ResponseMessage.success(null, ResponseStatus.SAMPLE_UPDATE_SUCCESS.getMessage());
	}

	@DeleteMapping(value = "/sample/{seq}")
	public ResponseMessage<Void> sampleDelete(@PathVariable int seq) {
		sampleService.sampleDataDeleted(seq);
		return ResponseMessage.success(null, ResponseStatus.SAMPLE_DELETE_SUCCESS.getMessage());
	}
}
