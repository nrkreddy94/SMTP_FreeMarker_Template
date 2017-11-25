package com.acc.smtp.mail;/*
 * Copyright 2012. the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Email <br/>
 */
public class Email {

	private String from;
	private List<String> recipients = new ArrayList();
	private List<String> bcc = new ArrayList();

	private List<String> cc = new ArrayList();

	private String contextType = "text/html";
	private String body;
	private String htmlBody;
	private String subject;

	private Map attachments = new HashMap();

	public Email(String to, String from, String subject, String emailBody) {
		List<String> _to = new ArrayList<String>();
		for (String s : to.split(";")) {
			_to.add(s);
		}

		recipients = _to;
		this.from = from;
		this.subject = subject;
		this.htmlBody = emailBody;
	}

	public String getHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public List<String> addRecipient(String recipient) {
		recipients.add(recipient);
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Map<String, Object> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map attachments) {
		this.attachments = attachments;
	}

	public void addAttachments(String fileName, File file) {
		attachments.put(fileName, file);
	}

	public void addAttachments(String fileName, ByteArrayDataSource file) {
		attachments.put(fileName, file);
	}

	@Override
	public String toString() {
		return "Email{" + ", from='" + from + '\'' + ", recipients="
				+ recipients + ", bcc=" + bcc + ", cc=" + cc
				+ ", contextType='" + contextType + '\'' + ", body='" + body
				+ '\'' + ", htmlBody='" + htmlBody + '\'' + ", subject='"
				+ subject + '\'' + ", attachments=" + attachments + '}';
	}
}
