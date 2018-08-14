package pe.gob.vuce.alertas.component;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailComponent {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	MailProperties mailProperties;

	@Async
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

	@Async
	public void sendHtmlMail(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		javaMailSender.send(mail);
	}

}
