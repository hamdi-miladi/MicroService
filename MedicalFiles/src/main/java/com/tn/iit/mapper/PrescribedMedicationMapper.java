package com.tn.iit.mapper;

import java.util.ArrayList;
import java.util.List;

import com.tn.iit.domain.PrescribedMedication;
import com.tn.iit.dto.PrescribedMedicationDTO;

public class PrescribedMedicationMapper {
	public static PrescribedMedicationDTO prescribedMedicationToPrescribedMedicationDTO(
			PrescribedMedication prescribedMedication) {

		PrescribedMedicationDTO prescribedMedicationDTO = new PrescribedMedicationDTO();
		prescribedMedicationDTO.setId(prescribedMedication.getId());
		prescribedMedicationDTO.setMedicationId(prescribedMedication.getMedicationId());
		prescribedMedicationDTO.setUnitPrice(prescribedMedication.getUnitPrice());
		return prescribedMedicationDTO;

	}
	 public static List<PrescribedMedicationDTO> prescribedMedicationToPrescribedMedicationDTOList(List<PrescribedMedication> prescribedMedicationS) {
		   List<PrescribedMedicationDTO> presMedDtoList = new ArrayList<>();
		   prescribedMedicationS.forEach(dos -> {
			   presMedDtoList.add(prescribedMedicationToPrescribedMedicationDTO(dos));
		   });
         return presMedDtoList;                            
     }

	public static PrescribedMedication prescribedMedicationDTOToPrescribedMedication(
			PrescribedMedicationDTO prescribedMedicationDTO) {

		PrescribedMedication medication = new PrescribedMedication();
		medication.setId(prescribedMedicationDTO.getId());
		medication.setUnitPrice(prescribedMedicationDTO.getUnitPrice());
		medication.setMedicationId(prescribedMedicationDTO.getMedicationId());
		return medication;
	}

}
