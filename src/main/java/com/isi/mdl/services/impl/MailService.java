package com.isi.mdl.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.isi.mdl.utils.MailStructure;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {
	
	@Autowired
	private JavaMailSender emailSender;

	@Value("$(spring.mail.username)")
	private String fromMail;

	public void sendMmail(String mail, MailStructure mailStrucutre)

	{
	

	SimpleMailMessage message = new SimpleMailMessage();

		    message.setFrom(fromMail);
			message.setSubject(mailStrucutre.getSubject());
			message.setText(mailStrucutre.getMessage());
			message.setTo(mail);
		

			emailSender.send(message);
			

	}

}
