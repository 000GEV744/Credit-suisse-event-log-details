package com.suisse.credit.eventlogs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suisse.credit.eventlogs.entity.EventDetail;
import com.suisse.credit.eventlogs.services.EventService;


@RestController
@RequestMapping("/api/event")
public class EventDetailController {
	
	private static final Logger log = LoggerFactory.getLogger(EventDetailController.class);
	
	@Autowired
	private EventService eventService;

	@PostMapping("/save-Event-Logs")
	public ResponseEntity<Object> saveFileContent(@RequestParam("file") MultipartFile file){
		log.info("inside saveFileContent() method in EventDetailController Class");
		eventService.save(file);
		return ResponseEntity.status(HttpStatus.OK).body("Content Saved Successfully");
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventDetail>> findAllEvents(){
		log.info("inside findAllEvents() method in EventDetailController Class");
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findAllEvents());		
	}
}
