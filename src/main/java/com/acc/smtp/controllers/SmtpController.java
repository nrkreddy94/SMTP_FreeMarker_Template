package com.acc.smtp.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.smtp.mail.EmailService;
import com.acc.smtp.models.UserAccount;

@Controller
@RequestMapping({ "/smtp" })
public class SmtpController {
	private static final Logger logger = LoggerFactory
			.getLogger(SmtpController.class);
	@Inject
	private EmailService emailService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String afterLogin(HttpServletRequest request) {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/email", method = RequestMethod.POST, produces = { MediaType.TEXT_HTML_VALUE })
	public String authentication(
			@ModelAttribute("userAccount") UserAccount userAccount,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			emailService.sendMFAInstructionsEmail(userAccount);
		} catch (Exception exception) {
			System.out.println(exception);
		}

		return "mail has been sent successfully";
	}
}
