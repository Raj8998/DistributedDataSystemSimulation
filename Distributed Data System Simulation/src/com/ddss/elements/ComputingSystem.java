package com.ddss.elements;

import java.util.HashMap;

import com.ddss.interfaces.Consumer;
import com.ddss.interfaces.DataInstance;

public class ComputingSystem implements Consumer{

	private String systemID;
	private HashMap<Integer,DataInstance> dataStorage;
	
	public ComputingSystem(String systemID) {
		this.systemID = systemID;
		this.dataStorage = new HashMap<>();
	}


	@Override
	public void update(DataInstance newDataInstance) {
		System.out.println(systemID + ": " + newDataInstance.toString());
		this.dataStorage.put(newDataInstance.hashCode(),newDataInstance);
	}


	@Override
	public String getName() {
		return this.systemID;
	}


	@Override
	public int getNumberOfConsumedData() {
		return this.dataStorage.size();
	}
	
	
	

}
