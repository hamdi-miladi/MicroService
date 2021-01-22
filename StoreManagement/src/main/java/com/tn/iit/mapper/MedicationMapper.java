package com.tn.iit.mapper;

import com.tn.iit.domain.Medication;
import com.tn.iit.dto.MedicationDTO;

public class MedicationMapper {
	public static Medication medicationDtoToMedication(MedicationDTO medicationDTO) {
		Medication medication = new Medication();
		medication.setId(medicationDTO.getId());
		medication.setName(medicationDTO.getName());
		medication.setPrice(medicationDTO.getPrice());
		return medication;
	}

	public static MedicationDTO medicationToMedicationDto(Medication medication) {
		MedicationDTO medicationDto = new MedicationDTO();
		medicationDto.setId(medication.getId());
		medicationDto.setName(medication.getName());
		return medicationDto;
	}
}