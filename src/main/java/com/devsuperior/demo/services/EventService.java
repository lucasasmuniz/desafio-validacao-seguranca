package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository reporitory;
	
	@Autowired
	private CityRepository cityRepository;
	
	public Page<EventDTO> findAllPaged(Pageable pageable){
		return reporitory.findAll(pageable).map(x -> new EventDTO(x));
	}
	
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		entity.setCity(cityRepository.getReferenceById(dto.getCityId()));
		entity.setDate(dto.getDate());
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity = reporitory.save(entity);
		return new EventDTO(entity);
	}
}
