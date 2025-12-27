package com.example.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.service.OtpService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@PostMapping("/sendEmail")
	public String SendOtp(@RequestParam String email) throws MessagingException {
		otpService.sendOtp(email);
		return "OTP Email Sent Successfully";
	}

	@PostMapping("/Verify")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
		return otpService.verifyOtp(email, otp) ? "Otp Verified successfully" : "Invalid Otp or Expired";
	}

}
