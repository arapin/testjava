package com.michael.example.logging;

import java.util.Arrays;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.michael.example.constant.GlobalConstants;
import com.michael.example.constant.LogConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is an Aspect class that provides global logging capabilities for the application.
 * It intercepts method calls in specified packages and logs information before and after the method invocation.
 */
@Slf4j
@Aspect
@Component
public class GlobalLoggingAspect {

	private static final String LOG_TAB = "\t";

	@Pointcut("within(com.michael.example.controller..*)") // 패키지 범위 설정
	public void controllerMethods() {
	}

	@Before("controllerMethods()")
	public void logBeforeController(JoinPoint joinPoint) {
		logStart(joinPoint, GlobalConstants.START_REQUEST, true);
	}

	@AfterReturning(pointcut = "controllerMethods()", returning = "returnValue")
	public void logAfterReturningController(JoinPoint joinPoint, Object returnValue) {
		logEnd(joinPoint, returnValue, GlobalConstants.END_REQUEST);
	}

	@Pointcut("within(com.michael.example.service..*)")
	public void serviceMethods() {
	}

	@Before("serviceMethods()")
	public void logBeforeService(JoinPoint joinPoint) {
		logStart(joinPoint, GlobalConstants.REQUEST_SERVICE, false);
	}

	@AfterReturning(pointcut = "serviceMethods()", returning = "returnValue")
	public void logAfterReturningService(JoinPoint joinPoint, Object returnValue) {
		logEnd(joinPoint, returnValue, GlobalConstants.END_SERVICE);
	}

	@AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
	public void logAfterThrowingService(JoinPoint joinPoint, Exception ex) {
		log.error(GlobalConstants.ERROR_IN_SERVICE, joinPoint.getSignature().toShortString());
		log.error(LOG_TAB + "{}", ex);
	}

	private void logStart(JoinPoint joinPoint, String logMessage, boolean isController) {

		if (isController) {
			MDC.put(LogConstants.GUID_ID, UUID.randomUUID().toString());
			log.info("###GUID is creating###");
		}

		log.info(logMessage, joinPoint.getSignature().toShortString());
		Arrays.stream(joinPoint.getArgs())
			.map(Object::toString)
			.map(arg -> LOG_TAB + arg)
			.forEach(log::info);
	}

	private void logEnd(JoinPoint joinPoint, Object returnValue, String logMessage) {
		log.info(logMessage, joinPoint.getSignature().toShortString());
		if (returnValue != null) {
			log.info(LOG_TAB + "{}", returnValue);
		}
	}
}
