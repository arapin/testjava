package com.michael.example.repository.primary.sample.impl;

import static com.michael.example.repository.primary.sample.entity.QSampleEntity.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.michael.example.repository.primary.sample.entity.SampleBoundEntity;
import com.michael.example.service.sample.model.SampleModel;
import com.michael.example.repository.primary.sample.SampleRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class SampleRepositoryImpl implements SampleRepository {
	private final JPAQueryFactory jpaQueryFactory;

	public SampleRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	/***
	 * Sample 조회
	 * @return List<SampleEntity>
	 */
	@Override
	public List<SampleBoundEntity> selectSampleTestData() {
		return jpaQueryFactory.select(
				Projections.bean(SampleBoundEntity.class, sampleEntity.name, sampleEntity.id, sampleEntity.seq))
			.from(sampleEntity)
			.fetch();
	}

	/***
	 * Sample 조건 검색
	 * @param seq int
	 * @return SampleBoundEntity
	 */
	@Override
	public SampleBoundEntity selectSampleTestDataById(int seq) {
		return jpaQueryFactory.select(
				Projections.bean(SampleBoundEntity.class, sampleEntity.name, sampleEntity.id, sampleEntity.seq))
			.from(sampleEntity)
			.where(sampleEntity.seq.eq(seq))
			.fetchOne();
	}

	/***
	 * Sample 저장
	 * @param sampleModel SampleModel
	 */
	@Override
	public void insertSampleTestData(SampleModel sampleModel) {
		jpaQueryFactory.insert(sampleEntity)
			.columns(sampleEntity.id, sampleEntity.name)
			.values(sampleModel.getId(), sampleModel.getName())
			.execute();
	}

	/***
	 * Sample 수정
	 * @param sampleModel SampleModel
	 */
	@Override
	public void updateSampleTestData(SampleModel sampleModel) {
		jpaQueryFactory.update(sampleEntity)
			.set(sampleEntity.name, sampleModel.getName())
			.set(sampleEntity.id, sampleModel.getId())
			.where(sampleEntity.seq.eq(sampleModel.getSeq()))
			.execute();
	}

	/***
	 * Sample 삭제
	 * @param seq int
	 */
	@Override
	public void deleteSampleTestData(int seq) {
		jpaQueryFactory.delete(sampleEntity).where(sampleEntity.seq.eq(seq)).execute();
	}
}
