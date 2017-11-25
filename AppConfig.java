package com.acc.smtp.config;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.acc.smtp" })
public class AppConfig {
	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	@Bean
	public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
		AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		beanPostProcessor.setAutowiredAnnotationType(Inject.class);

		return beanPostProcessor;
	}

}
