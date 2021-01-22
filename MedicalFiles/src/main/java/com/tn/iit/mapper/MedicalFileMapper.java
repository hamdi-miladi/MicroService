package com.tn.iit.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import com.tn.iit.domain.MedicalFile;
import com.tn.iit.domain.PrescribedMedication;
import com.tn.iit.dto.MedicalFileDTO;

public class MedicalFileMapper {
	public static MedicalFileDTO medicalfileToMedicalFileDTO(MedicalFile medicalfile) {
		MedicalFileDTO medicalfileDTO=new MedicalFileDTO();
		medicalfileDTO.setId(medicalfile.getId());
		medicalfileDTO.setArrivalDate(medicalfile.getArrivalDate());
		medicalfileDTO.setPatientName(medicalfile.getPatientName());
		medicalfileDTO.setPrescribedMedicationDTO(PrescribedMedicationMapper.prescribedMedicationToPrescribedMedicationDTOList(medicalfile.getMedications()));
	
		return medicalfileDTO;
	}
	
	

	public static MedicalFile medicalFileDTOToMedicalfile(MedicalFileDTO medicalfileDTO) {
		MedicalFile medicalfile=new MedicalFile();
		medicalfile.setId(medicalfileDTO.getId());
		medicalfile.setArrivalDate(medicalfileDTO.getArrivalDate());
		medicalfile.setPatientName(medicalfileDTO.getPatientName());
		medicalfile.setMedications(medicalfileDTO.getPrescribedMedicationDTO().stream().map(medicationDTO->{
			PrescribedMedication medication=PrescribedMedicationMapper.prescribedMedicationDTOToPrescribedMedication(medicationDTO);
			medication.setMedicalFile(medicalfile);
			return medication;
		}).collect(Collectors.toList()));
		return medicalfile;
	}

}
