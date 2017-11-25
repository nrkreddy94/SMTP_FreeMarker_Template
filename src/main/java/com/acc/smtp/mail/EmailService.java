package com.acc.smtp.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.acc.smtp.models.UserAccount;

@Component
public class EmailService {
	private static final Logger logger = LoggerFactory
			.getLogger(EmailService.class);

	private String smtpHost;
	private String smtpUsername;
	private String smtpPassword;

	@PostConstruct
	public void init() {
		smtpHost = "smarthost.gmail.com";
		smtpUsername = "";
		smtpPassword = "";
	}

	private static byte[] readBytes(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		byte fileContent[] = new byte[(int) file.length()];
		fis.read(fileContent);
		return fileContent;
	}

	public void send(final Email email) {

		int port = 25;
		boolean authenticationRequired = false;

		Transport transport = null;
		try {
			Session session = null;
			Properties props = null;

			props = System.getProperties();
			if (authenticationRequired) {
				props.put("mail.smtp.auth", "true");
			} else {
				props.put("mail.smtp.auth", "false");
			}

			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", smtpHost);

			session = Session.getInstance(props, null);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email.getFrom()));

			List<String> recipients = email.getRecipients();
			List<String> bccRecipients = email.getBcc();
			List<String> ccRecipients = email.getCc();

			Address[] to_recipients = parseRecipients(recipients);
			Address[] cc_recipients = parseRecipients(ccRecipients);
			Address[] bcc_recipients = parseRecipients(bccRecipients);

			message.addRecipients(Message.RecipientType.TO, to_recipients);
			message.addRecipients(Message.RecipientType.CC, cc_recipients);
			message.addRecipients(Message.RecipientType.BCC, bcc_recipients);

			message.setSubject(email.getSubject());

			Multipart multipart = new MimeMultipart("alternative");

			// create plain text
			if (email.getBody() != null) {
				BodyPart plainText = new MimeBodyPart();
				plainText.setText(email.getBody());
				multipart.addBodyPart(plainText);
			}

			// create html content
			if (email.getHtmlBody() != null) {
				BodyPart htmlContent = new MimeBodyPart();
				htmlContent.setText(email.getHtmlBody());
				htmlContent.setContent(email.getHtmlBody(), "text/html");
				multipart.addBodyPart(htmlContent);
			}

			for (String key : email.getAttachments().keySet()) {
				// add attachments
				BodyPart attachment = new MimeBodyPart();
				Object data = email.getAttachments().get(key);
				DataSource source = null;
				if (data instanceof File) {
					source = new FileDataSource((File) data);
				} else if (data instanceof String) {
					source = new FileDataSource(data.toString());
				} else if (data instanceof ByteArrayDataSource) {
					source = (ByteArrayDataSource) data;
				} else {
					continue;
				}

				attachment.setDataHandler(new DataHandler(source));
				attachment.setFileName(key);
				multipart.addBodyPart(attachment);
			}

			message.setContent(multipart);
			message.saveChanges();

			transport = session.getTransport("smtp");
			transport.connect(smtpHost, 587, smtpUsername, smtpPassword);
			transport.send(message, message.getAllRecipients());

		} catch (Throwable e) {
			System.out.println("email failure. " + e);

		} finally {
			try {
				if (transport != null)
					transport.close();
			} catch (Exception e) {
				// do nothing
			}
		}
	}

	private static Address[] parseRecipients(List<String> list)
			throws AddressException {
		Address rec[] = new InternetAddress[list.size()];
		int x = 0;
		for (Object to : list) {
			rec[x++] = new InternetAddress((String) to);
		}
		return rec;
	}

	/**
	 * Sending MFA instructions email to user or DL
	 */
	public void sendMFAInstructionsEmail(UserAccount userAccount) {
		Map<String, Object> properties = createEmailProperties("user",
				userAccount);

		String to = userAccount.getEmail();
		String from = userAccount.getFromAddress();
		String subject = userAccount.getSubject();
		String emailBody = TemplateProcessor.process(
				"/email-templates/mfaInstructions.html", properties);

		Email email = new Email(to, from, subject, emailBody);
		send(email);
	}

	public Map<String, Object> createEmailProperties(String key, Object value) {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(key, value);
		properties.put("fontFamily", "Arial, Helvetica, sans-serif");

		return properties;
	}

}
