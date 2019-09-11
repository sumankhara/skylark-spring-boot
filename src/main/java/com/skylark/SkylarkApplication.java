package com.skylark;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.skylark.persistence.entity.Insurance;
import com.skylark.persistence.entity.PremiumMode;
import com.skylark.persistence.entity.Provider;
import com.skylark.persistence.repository.InsuranceRepository;
import com.skylark.persistence.repository.ProviderRepository;

@SpringBootApplication
public class SkylarkApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SkylarkApplication.class);
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private ProviderRepository ProviderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SkylarkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			Provider provider = ProviderRepository.save(new Provider("Santanu", "ABSLI", "945162789"));
			insuranceRepository.save(new Insurance("1234", "Jeevan Saral", 30123, PremiumMode.HLY, 1500000, 0, "01/01/2010", "06/15/2012", 25, provider));
			
			for(Insurance insurance: insuranceRepository.findAll()) {
				log.info("The insurance is: " + insurance);
			}
		};
	}

}
