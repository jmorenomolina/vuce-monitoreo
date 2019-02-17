package pe.gob.vuce.alertas.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(MailSender mailSender, JavaMailSender javaMailSender, MailProperties mailProperties) {
		super();
		this.mailSender = mailSender;
		this.javaMailSender = javaMailSender;
		this.mailProperties = mailProperties;
	}

	@Autowired
	MailProperties mailProperties;

	public void sendTextMail(String to, String subject, String body, String cc, String bcc) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setText(body);
		message.setSubject(subject);
		if (cc != null)
			message.setCc(cc);
		if (bcc != null)
			message.setBcc(bcc);
		mailSender.send(message);
	}

	public void sendHtmlMail(String to, String cc, String subject, String body) throws MessagingException, UnsupportedEncodingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(to);
		helper.setCc(cc);
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(mail);
	}
	
	

}
