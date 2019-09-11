package com.skylark.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.skylark.persistence.entity.Insurance;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

}
