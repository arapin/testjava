package com.michael.example.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * This class represents an aspect that logs the performance of methods in a global manner.
 * It measures the execution time of methods and logs the duration.
 */
@Aspect
@Component
@Slf4j
public class GlobalPerformanceLoggingAspect {
	@Around("execution(* com.gme.gmeloanapi.service..*(..))")
	public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		long executionDuration = endTime - startTime;

		String methodName = joinPoint.getSignature().getName();

		logExecutionTime(methodName, executionDuration);

		return result;
	}

	private void logExecutionTime(String methodName, long duration) {
		log.info("{} executed : {}ms", methodName, duration);
	}
}
