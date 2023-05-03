package com.sb.firstspringbootproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.firstspringbootproj.entity.ForeignTour;
import com.sb.firstspringbootproj.entity.LocalTour;
import com.sb.firstspringbootproj.entity.Traveller;
import com.sb.firstspringbootproj.repo.TravellerRepository;
import com.sb.firstspringbootproj.service.TravellerService;

@RestController
public class TravellerRestController {

	@Autowired
	TravellerService TravellerService;

	@Autowired
	TravellerRepository travellerRepository;

	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi VJ";
	}

	@PostMapping("/addTraveller")
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		return TravellerService.addTraveller(traveller);
	}

	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return TravellerService.saveLocalTourRequest(localTour);
	}

	@PostMapping("/requestforeigntour")
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return TravellerService.saveForeignTourRequest(foreignTour);
	}

	@GetMapping("/listtravellers")
	public List<Traveller> listAllTravellers() {
		return TravellerService.listAllTravellers();
	}
}