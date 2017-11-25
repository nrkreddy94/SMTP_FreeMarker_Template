package com.acc.smtp.mail;

import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class TemplateProcessor {

	/**
	 * Processes email templates
	 * 
	 * @param templateName
	 *            - the path to the template
	 * @param properties
	 *            - Map of properties used in the template. Key - name of object
	 *            in template, Value - object value to be used in template
	 */
	public static String process(String templateName,
			Map<String, Object> properties) {
		try {
			Configuration cfg = new Configuration(new Version("2.3.23"));
			cfg.setClassForTemplateLoading(TemplateProcessor.class, "/");
			cfg.setDefaultEncoding("UTF-8");
			Template template = cfg.getTemplate(templateName);
			FreeMarkerTemplateUtils.processTemplateIntoString(template,
					properties);
			return FreeMarkerTemplateUtils.processTemplateIntoString(template,
					properties);
		} catch (Exception e) {
			throw new RuntimeException("error occurred processing template - "
					+ templateName + " " + e.getMessage(), e);
		}
	}

}
