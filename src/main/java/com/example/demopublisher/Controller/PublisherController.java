package com.example.demopublisher.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demopublisher.Service.KafkaService;

@RestController
@RequestMapping("/location")
public class PublisherController {

	@Autowired
	private KafkaService kafkaservice;

	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		for(int i=1; i<=100; i++) {
		this.kafkaservice
				.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + ")");
		}
		return new ResponseEntity<>(Map.of("Message", "Location"), HttpStatus.OK);
	}

}
