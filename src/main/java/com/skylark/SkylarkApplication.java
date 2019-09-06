package com.skylark;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.skylark.entity.Insurance;
import com.skylark.entity.PremiumMode;
import com.skylark.entity.Provider;
import com.skylark.repository.InsuranceRepository;
import com.skylark.repository.ProviderRepository;

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
			Provider provider = ProviderRepository.save(new Provider("Santanu", "ABSLI", 945162789));
			insuranceRepository.save(new Insurance("1234", "Jeevan Saral", 30123, PremiumMode.HLY, 1500000, 0, new Date(), new Date(), 25, provider));
			
			for(Insurance insurance: insuranceRepository.findAll()) {
				log.info("The insurance is: " + insurance);
			}
		};
	}

}
