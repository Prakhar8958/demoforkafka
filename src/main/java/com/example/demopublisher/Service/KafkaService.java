package com.example.demopublisher.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demopublisher.Configuration.Constants;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String,String> kafkatemplate;
	
	private Logger log=LoggerFactory.getLogger(KafkaService.class);
	public boolean updateLocation(String location) {
	
		this.kafkatemplate.send(Constants.LOCATION_TOPIC_NAME,location);
		this.log.info("message produced");
	    return true;
	}
	
}
