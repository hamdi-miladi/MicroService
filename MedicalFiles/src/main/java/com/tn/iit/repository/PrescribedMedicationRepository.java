package com.tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.iit.domain.PrescribedMedication;

public interface PrescribedMedicationRepository extends JpaRepository<PrescribedMedication,Integer>{

}
