package com.example.otp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOtpEmail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Your One Time Pw");

		String html = """
				<h3>OTP Verification</h3>
				<p>Your OTP is:</p>
				<h1 style="color:blue;">%s</h1>
				<p>Valid for 5 minutes.</p>
				""".formatted(otp);
		mimeMessageHelper.setText(html,true);
		javaMailSender.send(mimeMessage);
	}

}
