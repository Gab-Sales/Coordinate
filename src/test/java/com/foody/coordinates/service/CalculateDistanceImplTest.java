package com.foody.coordinates.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.foody.coordinates.domain.dto.CoordinatesDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CalculateDistanceImplTest {
	
	@Autowired
	private CalculateDistanceImpl calculateDistanceImpl;
	
	@Test
	public void getDistanceTest() {
		CoordinatesDTO coordenadas = calculateDistanceImpl.getDistance("-1.471176, -48.489161","-1.470266, -48.488169");
		assertEquals(150L, coordenadas.getDistanceMetersRounded());
		assertEquals(new BigDecimal(149.66).setScale(2,BigDecimal.ROUND_HALF_EVEN), coordenadas.getDistanceMeters());
	}
	
}
