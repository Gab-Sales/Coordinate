package com.foody.coordinates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foody.coordinates.domain.dto.CoordinatesDTO;
import com.foody.coordinates.service.CalculateDistanceImpl;

@RestController
@RequestMapping("distance")
public class Coordinates {
	
	@Autowired 
	private CalculateDistanceImpl calculateDistanceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public CoordinatesDTO getMeters(@RequestParam(required = true,name="initialCoord") String initialCoord,@RequestParam(required = true,name="finalCoord") String finalCoord) {
		return calculateDistanceImpl.getDistance(initialCoord,finalCoord);
	}
	
}
