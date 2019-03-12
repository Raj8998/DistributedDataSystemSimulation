package com.ddss.tests.arbiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.ddss.elements.DataArbiter;
import com.ddss.elements.GunOffender;

class ArbiterTests {
	
	int numberOfSystems = 3;
	DataArbiter arbiter = new DataArbiter(numberOfSystems);
	
	@Test
	void testDataDistribution() {
		GunOffender offenderOne = new GunOffender("Jon","Doe","Zip123");
		GunOffender offenderTwo = new GunOffender("Jon","Doe","Zip123");
		assertTrue(offenderOne.equals(offenderTwo) && offenderTwo.equals(offenderOne));
		assertEquals(arbiter.delegateData(offenderOne.hashCode()),arbiter.delegateData(offenderTwo.hashCode()));
	}

}
