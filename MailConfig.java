package com.acc.smtp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class MailConfig {
	/**
	 * Using SpringJavaMailSender to send an email
	 * 
	 * @return
	 */
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		// configuring host and need to change username and password to connect
		// mail server
		mailSender.setHost("smarthost.gamil.com");
		String username = "nrkreddy94@gmail.com";
		String password = "*********";

		if (username != null) {
			mailSender.setUsername(username);
		}

		if (username != null) {
			mailSender.setPassword(password);
		}

		Properties javaMailProperties = new Properties();
		// Prints out everything on screen
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.mime.charset", "UTF-8");
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
		fmConfigFactoryBean.setTemplateLoaderPath("/resources/email-templates");
		return fmConfigFactoryBean;
	}
}
