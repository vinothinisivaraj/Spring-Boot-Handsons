package com.example.otp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.otp.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long> {
	Optional<OtpEntity> findByEmailAndOtpAndVerifiedFalse(String email, String otp);
}
