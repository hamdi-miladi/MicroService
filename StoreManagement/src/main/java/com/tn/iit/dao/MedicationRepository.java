package com.tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tn.iit.domain.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer>{

}
