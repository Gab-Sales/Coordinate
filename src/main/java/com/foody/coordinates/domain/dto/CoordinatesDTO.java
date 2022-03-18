package com.foody.coordinates.domain.dto;

import java.math.BigDecimal;

public class CoordinatesDTO {
	
	private String initialCoordinates;
	private String finalCoordinates;
	private BigDecimal distanceMeters;
	private Long distanceMetersRounded;
	
	public CoordinatesDTO() {
		
	}
	
	public CoordinatesDTO(String initialCoord,String finalCoord,BigDecimal distance, Long distanceRounded) {
		this.initialCoordinates = initialCoord;
		this.finalCoordinates = finalCoord;
		this.distanceMeters = distance;
		this.distanceMetersRounded = distanceRounded;
	}
	
	public String getInitialCoordinates() {
		return initialCoordinates;
	}
	public void setInitialCoordinates(String initialCoordinates) {
		this.initialCoordinates = initialCoordinates;
	}
	public String getFinalCoordinates() {
		return finalCoordinates;
	}
	public void setFinalCoordinates(String finalCoordinates) {
		this.finalCoordinates = finalCoordinates;
	}
	public BigDecimal getDistanceMeters() {
		return distanceMeters;
	}
	public void setDistanceMeters(BigDecimal distanceMeters) {
		this.distanceMeters = distanceMeters;
	}
	public Long getDistanceMetersRounded() {
		return distanceMetersRounded;
	}
	public void setDistanceMetersRounded(Long distanceMetersRounded) {
		this.distanceMetersRounded = distanceMetersRounded;
	}
	
	
	
	
}
