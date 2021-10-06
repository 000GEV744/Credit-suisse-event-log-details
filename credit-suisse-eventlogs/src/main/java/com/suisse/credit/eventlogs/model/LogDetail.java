package com.suisse.credit.eventlogs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogDetail {
	
	private String id;
    private String state;
    private Long timestamp;
    private String type;
    private String host;

}
