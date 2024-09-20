package com.michael.example.repository.primary.sample.impl;


import static com.michael.example.repository.primary.entity.QSample.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.michael.example.repository.primary.entity.SampleBoundEntity;
import com.michael.example.service.sample.model.SampleModel;
import com.michael.example.repository.primary.sample.SampleRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class SampleRepositoryImpl implements SampleRepository {
	private final JPAQueryFactory jpaQueryFactory;

	public SampleRepositoryImpl(@Qualifier("primaryQueryFactory") JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	/***
	 * Sample 조회
	 * @return List<SampleEntity>
	 */
	@Override
	public List<SampleBoundEntity> selectSampleTestData() {
		return Optional.ofNullable(
			jpaQueryFactory.select(
					Projections.bean(SampleBoundEntity.class, sample.name, sample.id, sample.seq))
				.from(sample)
				.fetch()
		).orElseGet(List::of);
	}

	/***
	 * Sample 조건 검색
	 * @param seq int
	 * @return SampleBoundEntity
	 */
	@Override
	public SampleBoundEntity selectSampleTestDataById(int seq) {
		return Optional.ofNullable(
			jpaQueryFactory.select(
					Projections.bean(SampleBoundEntity.class, sample.name, sample.id, sample.seq))
				.from(sample)
				.where(sample.seq.eq(seq))
				.fetchOne()
		).orElseGet(SampleBoundEntity::new);
	}

	/***
	 * Sample 저장
	 * @param sampleModel SampleModel
	 */
	@Override
	public void insertSampleTestData(SampleModel sampleModel) {
		jpaQueryFactory.insert(sample)
			.columns(sample.id, sample.name)
			.values(sampleModel.getId(), sampleModel.getName())
			.execute();
	}

	/***
	 * Sample 수정
	 * @param sampleModel SampleModel
	 */
	@Override
	public void updateSampleTestData(SampleModel sampleModel) {
		jpaQueryFactory.update(sample)
			.set(sample.name, sampleModel.getName())
			.set(sample.id, sampleModel.getId())
			.where(sample.seq.eq(sampleModel.getSeq()))
			.execute();
	}

	/***
	 * Sample 삭제
	 * @param seq int
	 */
	@Override
	public void deleteSampleTestData(int seq) {
		jpaQueryFactory.delete(sample).where(sample.seq.eq(seq)).execute();
	}
}
