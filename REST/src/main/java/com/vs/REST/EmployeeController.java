package com.vs.REST;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
 
	@RequestMapping("/Employees")
	public List<Employees> retrieveAllEmployees(){
		return Arrays.asList(new Employees(1,"vino","ADM"),new Employees(2,"Karthik","CDE"),new Employees(3,"Vimal","AVM"));
	}
	
}
