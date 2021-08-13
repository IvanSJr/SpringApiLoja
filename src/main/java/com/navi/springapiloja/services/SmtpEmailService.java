package com.navi.springapiloja.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractMailService{

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage obj) {
		LOG.info("Simulando envio de email");
		mailSender.send(obj);
		LOG.info("Email enviado");
	}
	
	@Override
	public void sendHtmlEmail(MimeMessage obj) {
		LOG.info("Simulando envio de email HTML");
		javaMailSender.send(obj);
		LOG.info("Email enviado");
		
	}

}
