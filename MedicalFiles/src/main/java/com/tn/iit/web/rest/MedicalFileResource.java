package com.tn.iit.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tn.iit.dto.MedicalFileDTO;
import com.tn.iit.service.MedicalFileService;

@RestController
@RequestMapping("/api")
public class MedicalFileResource {
	private static final String ENTITY_NAME = "medicalfile";
	private final MedicalFileService medicalFileService;

	public MedicalFileResource(MedicalFileService medicalFileService) {
		super();
		this.medicalFileService = medicalFileService;
	}

	@PostMapping(path = "/medicalfiles")
	public ResponseEntity<MedicalFileDTO> createMedicalFile(@Valid @RequestBody MedicalFileDTO medicalFileDTO,
			BindingResult bindingResult) throws URISyntaxException {
		MedicalFileDTO save = medicalFileService.save(medicalFileDTO);
		return ResponseEntity.created(new URI("api/medicalefiles/" + save.getId())).body(save);
	}

}
