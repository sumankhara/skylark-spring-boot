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
import com.skylark.persistence.service.InsuranceService;
import com.skylark.persistence.service.ProviderService;

@Controller
public class InsuranceController {

	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private InsuranceService insuranceService;
	
	@GetMapping("/insurances")
	public String retrieveInsurances(Model model) {
		model.addAttribute("insurances", insuranceService.findAll());
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
		insuranceService.save(insurance);
		
		model.addAttribute("insurances", insuranceService.findAll());
		return "insurances";
	}
	
	@GetMapping("/showEditInsuranceForm/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Insurance insurance = insuranceService.findById(id);
		
		model.addAttribute("insurance", insurance);
		return "updateInsurance";
	}
	
	@PostMapping("/updateInsurance/{id}")
	public String updateInsurance(@PathVariable("id") Long id, @Valid Insurance insurance, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "updateInsurance";
		}
		
		insurance.setId(id);
		Provider provider = providerService.save(insurance.getProvider());
		insurance.setProvider(provider);
		insuranceService.save(insurance);
		
		model.addAttribute("insurances", insuranceService.findAll());
		return "insurances";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteInsurance(@PathVariable("id") Long id, Model model) {
		insuranceService.delete(id);
		
		model.addAttribute("insurances", insuranceService.findAll());
		return "insurances";
	}
}
