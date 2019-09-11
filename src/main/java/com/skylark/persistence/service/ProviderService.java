package com.skylark.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylark.persistence.entity.Provider;
import com.skylark.persistence.repository.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	public Provider save(Provider provider) {
		Optional<Provider> existingProvider = providerRepository.findByAgentName(provider.getAgentName());
		if(existingProvider.isPresent()) {
			return existingProvider.get();
		}
		return providerRepository.save(provider);
	}
}
