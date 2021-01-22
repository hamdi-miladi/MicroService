package com.tn.iit.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tn.iit.dao.MedicationRepository;
import com.tn.iit.domain.Medication;
import com.tn.iit.dto.MedicationDTO;
import com.tn.iit.mapper.MedicationMapper;

@Service
@Transactional
public class MedicationService {

	private final MedicationRepository medicationRepository;

	public MedicationService(MedicationRepository medicationRepository) {
		this.medicationRepository = medicationRepository;
	}

	public MedicationDTO save(MedicationDTO medicationDTO) {
		Medication medication = MedicationMapper.medicationDtoToMedication(medicationDTO);
		medication = medicationRepository.save(medication);
		MedicationDTO resultDTO = MedicationMapper.medicationToMedicationDto(medication);
		return resultDTO;
	}

	public MedicationDTO update(MedicationDTO medicationDTO) {
		Medication inBase = medicationRepository.getOne(medicationDTO.getId());
		Medication medication = MedicationMapper.medicationDtoToMedication(medicationDTO);
		medication = medicationRepository.save(medication);
		MedicationDTO resultDTO = MedicationMapper.medicationToMedicationDto(medication);
		return resultDTO;

	}

	public MedicationDTO findOne(Integer id) {
		Medication medication = medicationRepository.getOne(id);
		MedicationDTO medicationDTO = MedicationMapper.medicationToMedicationDto(medication);
		return medicationDTO;
	}

	public void delete(int id) {
		medicationRepository.deleteById(id);
	}

}
