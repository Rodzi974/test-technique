package com.fa.test.technique;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.fa.test.technique.app.service.TestTechniqueService;

@RunWith(SpringRunner.class)
public class ServiceTest {

	@Autowired
	private TestTechniqueService testTechniqueService;
	
	@Test
	public void calculerTaxes() {
		BigDecimal resultatSansTaxes = testTechniqueService.calculerTaxes(new BigDecimal("12.49"), new HashSet<>());
		assertEquals(BigDecimal.ZERO, resultatSansTaxes);
		
		BigDecimal resultatAvecTVA = testTechniqueService.calculerTaxes(new BigDecimal("16.49"), new HashSet<>());
		assertEquals(new BigDecimal("1.65"), resultatAvecTVA);
		
	}
	
}
