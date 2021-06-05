package com.devsuperior.bds04.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventService service;
	
	@GetMapping
	public ResponseEntity<Page<EventDTO>> findAll(Pageable pageable){
		
		
		Page<EventDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
		
	}
	
	
	@PostMapping
	public ResponseEntity<EventDTO> insert(@Valid @RequestBody EventDTO dto){
		
		dto = service.insert(dto);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.ok(dto);
		
	}
}
