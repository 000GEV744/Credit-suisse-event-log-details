package com.suisse.credit.eventlogs.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.suisse.credit.eventlogs.controller.EventDetailController;
import com.suisse.credit.eventlogs.entity.EventDetail;
import com.suisse.credit.eventlogs.exception.NotFoundException;
import com.suisse.credit.eventlogs.model.LogDetail;
import com.suisse.credit.eventlogs.repository.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	private static final Logger log = LoggerFactory.getLogger(EventService.class);
	
	@Autowired
	private EventRepository eventRepo;
	
	@Override
	public List<EventDetail> findAllEvents() {
		log.info("Inside findAllEvents() method in the EventServiceImpl class");
		List<EventDetail> events = eventRepo.findAll();
		if(events.size()!= 0) return events;
		throw new NotFoundException("No Events found");
	}

	@Override
	public void save(MultipartFile file) {
		
		log.info("Inside save() method in the EventServiceImpl class");
		try (Reader reader = new InputStreamReader(file.getInputStream())) {

            Gson gson = new Gson();
            LogDetail[] logs = gson.fromJson(reader, LogDetail[].class);
            List<LogDetail> logList = Arrays.asList(logs);

            List<String> idList = logList.stream().map(x-> x.getId()).toList();

            HashSet<String> hset = new HashSet<String>(idList);
            List<EventDetail> eventLogs = new ArrayList<>();
            hset.forEach(id ->{

                List<LogDetail> logsWithSameId = logList.stream().filter(x -> id.equals(x.getId())).collect(Collectors.toList());
                LogDetail obj1 = logsWithSameId.get(0);
                LogDetail obj2 = logsWithSameId.get(1);
                long duration = obj1.getTimestamp()-obj2.getTimestamp() > 0 ? obj1.getTimestamp()-obj2.getTimestamp() :obj2.getTimestamp()-obj1.getTimestamp();

                EventDetail eventLog = new EventDetail();
                eventLog.setEventId(obj1.getId());
                eventLog.setEventDuration(duration);
                eventLog.setHost(obj1.getHost());
                eventLog.setType(obj1.getType());
                eventLog.setAlert(duration > 4 ? Boolean.TRUE : Boolean.FALSE);
                eventLogs.add(eventLog);
            });
            eventRepo.saveAll(eventLogs);
            log.info("Event List found in the log File ");
            for(EventDetail l : eventLogs)
            {
                log.info("having event Detail: {}", l.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
