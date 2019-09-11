package com.skylark.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylark.persistence.entity.Insurance;
import com.skylark.persistence.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	public Insurance save(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
	
	public Insurance findById(Long id) {
		Optional<Insurance> insurance = insuranceRepository.findById(id);
		if(insurance.isPresent()) {
			return insurance.get();
		}
		throw new IllegalArgumentException("Invalid insurance id: " + id);
	}
	
	public Iterable<Insurance> findAll() {
		return insuranceRepository.findAll();
	}
	
	public void delete(Long id) {
		Optional<Insurance> insurance = insuranceRepository.findById(id);
		if(insurance.isPresent()) {
			insuranceRepository.delete(insurance.get());
		}
	}
}
