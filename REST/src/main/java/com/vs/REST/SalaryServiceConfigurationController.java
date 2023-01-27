package com.vs.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryServiceConfigurationController {

	@Autowired
	SalaryServiceConfiguration salaryServiceConfiguration;

	@RequestMapping("/salary-service")
	public SalaryServiceConfiguration retrieveAllEmployeesSalary() {
		return salaryServiceConfiguration;
	}

}
