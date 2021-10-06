package com.suisse.credit.eventlogs.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.suisse.credit.eventlogs.entity.EventDetail;

public interface EventService {

	public List<EventDetail> findAllEvents();
	public void save(MultipartFile file);
}
