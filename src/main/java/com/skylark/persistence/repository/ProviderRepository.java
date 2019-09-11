package com.skylark.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.skylark.persistence.entity.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

	public Optional<Provider> findByAgentName(String agentName);
}
