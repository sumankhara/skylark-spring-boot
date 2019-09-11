package com.skylark.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.skylark.persistence.entity.Insurance;
import com.skylark.persistence.entity.Provider;
import com.skylark.persistence.repository.InsuranceRepository;
import com.skylark.persistence.repository.ProviderRepository;
import com.skylark.persistence.service.ProviderService;

@Controller
public class InsuranceController {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private ProviderService providerService;
	
	@GetMapping("/insurances")
	public String retrieveInsurances(Model model) {
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
	
	@GetMapping("/showNewInsuranceForm")
	public String showNewInsuranceForm(Model model) {
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
		
		Provider provider = providerService.save(insurance.getProvider());
		insurance.setProvider(provider);
		insuranceRepository.save(insurance);
		
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
	
	@GetMapping("/showEditInsuranceForm/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Insurance insurance = insuranceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid insurance id: " + id));
		
		model.addAttribute("insurance", insurance);
		return "updateInsurance";
	}
	
	@PostMapping("/updateInsurance/{id}")
	public String updateInsurance(@PathVariable("id") String id, @Valid Insurance insurance, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "updateInsurance";
		}
		
		insurance.setId(Long.parseLong(id));
		Provider provider = providerService.save(insurance.getProvider());
		insurance.setProvider(provider);
		insuranceRepository.save(insurance);
		
		model.addAttribute("insurances", insuranceRepository.findAll());
		return "insurances";
	}
}
