package com.tn.iit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.iit.domain.MedicalFile;
import com.tn.iit.dto.MedicalFileDTO;
import com.tn.iit.dto.MedicationDTO;
import com.tn.iit.mapper.MedicalFileMapper;
import com.tn.iit.repository.MedicalFileRepository;

@Service
@Transactional
public class MedicalFileService {
	
	private final MedicalFileRepository medicalFileRepository;

	private final StoreManagmentServiceClient storeManagmentServiceClient;

	public MedicalFileService(MedicalFileRepository medicalFileRepository,
			StoreManagmentServiceClient storeManagmentServiceClient) {
	
		this.medicalFileRepository = medicalFileRepository;
		this.storeManagmentServiceClient = storeManagmentServiceClient;
	}

	public MedicalFileDTO save(MedicalFileDTO medicalFileDTO) {
		MedicalFile medicalFile = MedicalFileMapper.medicalFileDTOToMedicalfile(medicalFileDTO);
		medicalFile = medicalFileRepository.save(medicalFile);
		MedicalFileDTO resultDTO = MedicalFileMapper.medicalfileToMedicalFileDTO(medicalFile);
		return resultDTO;

	}

	public MedicalFileDTO update(MedicalFileDTO medicalFileDTO) {
		MedicalFile inBase = medicalFileRepository.getOne(medicalFileDTO.getId());

		MedicalFile medicalFile = MedicalFileMapper.medicalFileDTOToMedicalfile(medicalFileDTO);
		medicalFile = medicalFileRepository.save(medicalFile);
		MedicalFileDTO resultDTO = MedicalFileMapper.medicalfileToMedicalFileDTO(medicalFile);
		return resultDTO;

	}

	public MedicalFileDTO findOne(Integer id) {
		MedicalFile medicalFile = medicalFileRepository.getOne(id);
		MedicalFileDTO medicalFileDTO = MedicalFileMapper.medicalfileToMedicalFileDTO(medicalFile);

		List<MedicationDTO> medicationDTOS = storeManagmentServiceClient.getAllMedication();

		medicalFileDTO.getPrescribedMedicationDTO().forEach(prescribedMed -> {
			MedicationDTO medicationDTO = medicationDTOS.stream()
					.filter(medication -> medication.getId().equals(prescribedMed.getMedicationId())).findFirst()
					.orElseThrow();
			prescribedMed.setMedicationName(medicationDTO.getName());
			prescribedMed.setMedicationCategory(medicationDTO.getCategoryName());
		});
		return medicalFileDTO;
	}
	  public void delete(int id) {
	    	medicalFileRepository.deleteById(id);
	    }

}
