package com.foody.coordinates.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.foody.coordinates.domain.dto.CoordinatesDTO;

@Service
public class CalculateDistanceImpl {
	private static final int EARTH_RADIUS = 6371;
	private static final DecimalFormat df = new DecimalFormat("#.##");
	
	public CoordinatesDTO getDistance(String startCoord, String finalCoord) {
		
		String[] coordinatesIni = startCoord.split(",");
		double startLat = Double.parseDouble(coordinatesIni[0]);
		double startLong = Double.parseDouble(coordinatesIni[1]);
	
		String[] coordinatesFinal = finalCoord.split(",");
		double endLat = Double.parseDouble(coordinatesFinal[0]);
		double endLong = Double.parseDouble(coordinatesFinal[1]);
		
		double dLat  = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));
		
		startLat = Math.toRadians(startLat);
		endLat   = Math.toRadians(endLat);
		
		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		BigDecimal distance = new BigDecimal((EARTH_RADIUS * c)*1000);
		Long distanceRounded = Math.round((EARTH_RADIUS * c)*1000);
		
		CoordinatesDTO ret = new CoordinatesDTO(startCoord,finalCoord,distance.setScale(2,BigDecimal.ROUND_HALF_EVEN),distanceRounded);
		
		return ret;
	}
			
	public static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

}
