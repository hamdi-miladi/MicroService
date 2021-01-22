package com.tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tn.iit.domain.MedicalFile;

public interface MedicalFileRepository extends JpaRepository<MedicalFile,Integer>{

}
