package com.example.otp.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otp.Repository.OtpRepository;
import com.example.otp.entity.OtpEntity;

import jakarta.mail.MessagingException;

@Service
public class OtpService {

	@Autowired
	private OtpRepository otpRespository;

	@Autowired
	private EmailService emailService;

	public void sendOtp(String email) throws MessagingException {
		String otp = String.valueOf(new Random().nextInt(900000) + 1000000);
		OtpEntity otpEntity = new OtpEntity();
		otpEntity.setEmail(email);
		otpEntity.setOtp(otp);
		otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
		otpEntity.setVerified(false);
		otpRespository.save(otpEntity);
		emailService.sendOtpEmail(email, otp);

	}

	public boolean verifyOtp(String email, String otp) {
		Optional<OtpEntity> record = otpRespository.findByEmailAndOtpAndVerifiedFalse(email, otp);
		if (record.isPresent()) {
			OtpEntity otpEntity = record.get();
			if (otpEntity.getExpiryTime().isAfter(LocalDateTime.now())) {
				otpEntity.setVerified(true);
				otpRespository.save(otpEntity);
				return true;
			}
		}
		return false;

	}

}
