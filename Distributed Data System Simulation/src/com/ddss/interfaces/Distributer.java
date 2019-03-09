package com.ddss.interfaces;

public interface Distributer {

	void connectWithConsumer(Consumer x);
	void disconnectWithConsumer(Consumer x);
	void disconnectAll();
	void printDelegatingStats();
}
