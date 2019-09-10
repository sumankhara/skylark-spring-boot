package com.skylark.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.skylark.entity.Insurance;
import com.skylark.entity.Provider;
import com.skylark.repository.InsuranceRepository;
import com.skylark.repository.ProviderRepository;

@Controller
public class InsuranceController {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@GetMapping("/insurances")
	public String retrieveInsurances(Model model) {
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
	
	@GetMapping("/addInsurance")
	public String createInsurance(Model model) {
		Provider provider = new Provider();
		Insurance insurance = new Insurance();
		insurance.setProvider(provider);
		model.addAttribute("insurance", new Insurance());
		return "addInsurance";
	}
	
	@PostMapping("/addInsurance")
	public String addInsurance(@Valid Insurance insurance, BindingResult result, Model model) {
		if(result.hasErrors()) {
			result.getAllErrors().forEach(elt -> System.out.println(elt));
			return "addInsurance";
		}
		
		Provider provider = insurance.getProvider();
		providerRepository.save(provider);
		insurance.setProvider(provider);
		insuranceRepository.save(insurance);
		
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
}
