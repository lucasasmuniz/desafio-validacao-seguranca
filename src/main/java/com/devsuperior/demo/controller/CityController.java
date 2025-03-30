package com.devsuperior.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.services.CityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService service;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO dto){
		dto = service.insert(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(dto.getId()).toUri();
	        return ResponseEntity.created(uri).body(dto);
	}
}
