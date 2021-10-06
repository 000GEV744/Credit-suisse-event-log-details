package com.suisse.credit.eventlogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suisse.credit.eventlogs.entity.EventDetail;

public interface EventRepository extends JpaRepository<EventDetail, String>{
	
	@Override
	List<EventDetail> findAll();

}
