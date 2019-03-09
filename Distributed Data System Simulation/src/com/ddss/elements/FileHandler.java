package com.ddss.elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ddss.interfaces.DataInstance;
import com.ddss.interfaces.FileHandlerEssentials;
import com.ddss.interfaces.Receiver;

public class FileHandler implements FileHandlerEssentials {
	

	private Receiver receiver;
	private DataInstance buffer;
	private File inputFile; 

	public FileHandler(String filePath) {
		this.inputFile = new File(filePath);
	}
	
	@Override
	public void notifyReceiver(Receiver receiver) {
		this.receiver.dataArrived(this.buffer);
	}



	@Override
	public void setReceiverInstance(Receiver receiver) {
		this.receiver = receiver;
		
	}



	@Override
	public void startHandling() {
	
		try(Scanner scanner = new Scanner(this.inputFile)){
			StringBuilder collector = new StringBuilder();
			
			while(scanner.hasNextLine()) {
				collector.append(scanner.nextLine());
			}
			JSONParser dataParser = new JSONParser();
			JSONObject totalDataInput = (JSONObject)dataParser.parse(collector.toString());
			JSONArray array = (JSONArray)totalDataInput.get("data");
			
			int zipcodeIndex = 8;
			int nameIndex = 11;
			int surnameIndex = 12;
			for(int each=0; each<array.size(); each++) {
				JSONArray personData = (JSONArray)array.get(each);
				String name = (String)personData.get(nameIndex);
				String surname = (String)personData.get(surnameIndex);
				String zipcode = (String)personData.get(zipcodeIndex);
				
				this.receiver.dataArrived(new GunOffender(name,surname,zipcode));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
