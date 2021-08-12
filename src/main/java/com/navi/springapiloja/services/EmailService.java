package com.navi.springapiloja.services;

import org.springframework.mail.SimpleMailMessage;

import com.navi.springapiloja.domain.Pedido;

public interface EmailService {
	
	void senderOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage obj);
	
}
