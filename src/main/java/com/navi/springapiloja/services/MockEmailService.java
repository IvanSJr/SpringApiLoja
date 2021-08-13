package com.navi.springapiloja.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractMailService{

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage obj) {
		LOG.info("Simulando envio de email...");
		LOG.info(obj.toString());
		LOG.info("E-mail enviado.");
	}
	
	@Override
	public void sendHtmlEmail(MimeMessage obj) {
		LOG.info("Simulando envio de email html...");
		LOG.info(obj.toString());
		LOG.info("E-mail enviado.");
	}
	
}
