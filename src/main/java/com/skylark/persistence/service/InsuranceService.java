package com.skylark.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylark.persistence.repository.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;
}
