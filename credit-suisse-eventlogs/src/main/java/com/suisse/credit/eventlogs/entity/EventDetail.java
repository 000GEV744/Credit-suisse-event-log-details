package com.suisse.credit.eventlogs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_detail")
public class EventDetail {

	@Id
    private String eventId;
	
	@Column(name = "event_duration")
    private Long eventDuration;
	
	@Column(name = "type")
    private String type;
	
	@Column(name = "host")
    private String host;
	
	@Column(name = "alert")
    private Boolean alert;
}
