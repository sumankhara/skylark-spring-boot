package com.skylark.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skylark.repository.InsuranceRepository;

@Controller
public class InsuranceController {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@GetMapping("/insurances")
	public String retrieveInsurances(Model model) {
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
}
