package com.ddss.interfaces;

public interface FileHandlerEssentials {

	void setReceiverInstance(Receiver receiver);
	void notifyReceiver(Receiver receiver);
	void startHandling();
}
