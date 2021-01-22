package com.tn.iit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tn.iit.dto.MedicationDTO;

@Service
public class StoreManagmentServiceClient {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public List<MedicationDTO> getAllMedication() {
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString("http://localhost:9092/storeManagement/api/medications").build().encode();

		return restTemplate().exchange(uriComponents.toUri(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()),
				new ParameterizedTypeReference<List<MedicationDTO>>() {
				}).getBody();
	}

	public MedicationDTO getMedicationById(Integer id) {
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString("http://localhost:9092/storeManagement/api/medications").path("/{id}").build().expand(id)
				.encode();

		return restTemplate().exchange(uriComponents.toUri(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()),
				new ParameterizedTypeReference<MedicationDTO>() {
				}).getBody();
	}

}
