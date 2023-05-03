package com.sb.firstspringbootproj.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.firstspringbootproj.entity.ForeignTour;
import com.sb.firstspringbootproj.entity.LocalTour;
import com.sb.firstspringbootproj.entity.Traveller;
import com.sb.firstspringbootproj.repo.ForeignTourRepository;
import com.sb.firstspringbootproj.repo.LocalTourRepository;
import com.sb.firstspringbootproj.repo.TravellerRepository;

@Service
public class TravellerServiceImpl implements TravellerService {
	
	@Autowired
	private TravellerRepository travellerRepository;

	@Autowired
	private LocalTourRepository localTourRepository;
	@Autowired
	private ForeignTourRepository foreignTourRepository;
	

	@Override
	public Traveller addTraveller(Traveller traveller) {
		return travellerRepository.save(traveller);
	}
	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {
		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		System.out.println("-----------foreign Tour -------" +foreignTour);
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}
	
	@Override
	public List<Traveller> listAllTravellers() {

		return (List<Traveller>) travellerRepository.findAll();
	}
}
