package com.sb.firstspringbootproj.service;

import java.util.List;
import com.sb.firstspringbootproj.entity.ForeignTour;
import com.sb.firstspringbootproj.entity.LocalTour;
import com.sb.firstspringbootproj.entity.Traveller;

public interface TravellerService {

	public Traveller addTraveller(Traveller traveller);
	
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	
	public List<Traveller> listAllTravellers();
}
