package com.tn.iit.service;

import com.tn.iit.domain.PrescribedMedication;
import com.tn.iit.dto.PrescribedMedicationDTO;
import com.tn.iit.mapper.PrescribedMedicationMapper;
import com.tn.iit.repository.PrescribedMedicationRepository;

public class PrescribedMedicationService {

	private final PrescribedMedicationRepository prescribedMedicationRepository;
	private final StoreManagmentServiceClient storeManagmentServiceClient;

	public PrescribedMedicationService(PrescribedMedicationRepository prescribedMedicationRepository,
			StoreManagmentServiceClient storeManagmentServiceClient) {
		super();
		this.prescribedMedicationRepository = prescribedMedicationRepository;
		this.storeManagmentServiceClient = storeManagmentServiceClient;
	}

	public PrescribedMedicationDTO save(PrescribedMedicationDTO presMedDTO) {
		PrescribedMedication presMed = PrescribedMedicationMapper
				.prescribedMedicationDTOToPrescribedMedication(presMedDTO);
		presMed = prescribedMedicationRepository.save(presMed);
		PrescribedMedicationDTO resultDTO = PrescribedMedicationMapper
				.prescribedMedicationToPrescribedMedicationDTO(presMed);
		return resultDTO;

	}

	public PrescribedMedicationDTO update(PrescribedMedicationDTO prescribedMedicationDTO) {
		PrescribedMedication inBase = prescribedMedicationRepository.getOne(prescribedMedicationDTO.getId());

		PrescribedMedication prescribedMedication = PrescribedMedicationMapper
				.prescribedMedicationDTOToPrescribedMedication(prescribedMedicationDTO);
		prescribedMedication = prescribedMedicationRepository.save(prescribedMedication);
		PrescribedMedicationDTO resultDTO = PrescribedMedicationMapper
				.prescribedMedicationToPrescribedMedicationDTO(prescribedMedication);
		return resultDTO;

	}
	public void delete(int id) {
		prescribedMedicationRepository.deleteById(id);
	}

}
