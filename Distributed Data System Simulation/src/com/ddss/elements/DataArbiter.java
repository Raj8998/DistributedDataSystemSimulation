package com.ddss.elements;

import java.util.ArrayList;
import java.util.List;

import com.ddss.interfaces.Consumer;
import com.ddss.interfaces.DataInstance;
import com.ddss.interfaces.FileHandlerEssentials;
import com.ddss.interfaces.Distributer;
import com.ddss.interfaces.Receiver;

public class DataArbiter implements Distributer,Receiver {

	private int availableComputingSystemsCount;
	
	private int totalDataCount;
	private List<Consumer> computingSystemList;
	private FileHandlerEssentials handler;
	
	public DataArbiter(Integer availableComputingSystems) {
		this.availableComputingSystemsCount = availableComputingSystems;
	}
	
	public List<Consumer> getComputingSystemList() {
		return computingSystemList;
	}

	public void setComputingSystemList(List<Consumer> computingSystemList) {
		this.computingSystemList = computingSystemList;
	}


	

	public int getAvailableComputingSystems() {
		return availableComputingSystemsCount;
	}


	
	public int getTotalDataCount() {
		return totalDataCount;
	}


	public int delegateData(int hashCode) {
		int calculatedSystemID = hashCode % this.availableComputingSystemsCount;
		this.totalDataCount++;	
		return calculatedSystemID;
	}

	@Override
	public void connectWithConsumer(Consumer x) {
		if(this.computingSystemList.size() < this.availableComputingSystemsCount) {
			this.computingSystemList.add(x);
		}
	}

	@Override
	public void disconnectWithConsumer(Consumer x) {
		this.computingSystemList.remove(x);	
	}

	@Override
	public void disconnectAll() {
		this.computingSystemList.clear();
		
	}

	@Override
	public void dataArrived(DataInstance data) {
		int assignedConsumerSystem = this.delegateData(data.hashCode());
		Consumer chosenSystem = this.computingSystemList.get(assignedConsumerSystem);
		chosenSystem.update(data);
		
	}

	public FileHandlerEssentials getHandler() {
		return handler;
	}

	public void setHandler(FileHandlerEssentials handler) {
		this.handler = handler;
	}
	@Override
	public void printDelegatingStats() {
		System.out.println("-----------DELEGATING STATS-----------");
		for(Consumer each : this.computingSystemList) {
			System.out.println(each.getName() + " : "+ each.getNumberOfConsumedData());
		}
		System.out.println("-----------TOTAL DATA COUNT-----------");
		System.out.println("Total: "+this.totalDataCount);
	}
}
