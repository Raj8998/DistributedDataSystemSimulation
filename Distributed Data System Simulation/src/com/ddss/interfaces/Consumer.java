package com.ddss.interfaces;

import com.ddss.elements.GunOffender;

public interface Consumer {

	void update(DataInstance x);
	String getName();
	int getNumberOfConsumedData();
}
