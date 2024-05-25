package com.isi.mdl.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.core.io.InputStreamResource;
import com.isi.mdl.dto.MailRequest;
import com.isi.mdl.dto.MailResponse;
import com.isi.mdl.web.UserRestController;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	@Value("$(spring.mail.username)")
	private String fromMail;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();

		try {
		
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			//FileSystemResource logoResource = new FileSystemResource(applicationContext.getResource("classpath:logo.png").getFile());
			
			  ClassPathResource logoResource = new ClassPathResource("logo.png");
		        String contentType = "image/png";
		      
			helper.setTo(request.getTo());
			helper.setText(html, true);
			  helper.addInline("logo.png", new ClassPathResource("logo.png"));
			helper.setSubject(request.getSubject());
			helper.setFrom(fromMail);
			sender.send(message);
			Date date = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			response.setMessage("Email a été envoyer avec succès : " + request.getTo() + "  dateEnvoie : " +formatter.format(date));
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Erreur  lors de l'envoie de l'email : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	
	
	
}
