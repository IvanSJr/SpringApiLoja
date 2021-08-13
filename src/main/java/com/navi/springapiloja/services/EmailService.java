package com.navi.springapiloja.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.navi.springapiloja.domain.Pedido;

public interface EmailService {
	
	void senderOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage obj);
	void senderOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage obj);
	
}
