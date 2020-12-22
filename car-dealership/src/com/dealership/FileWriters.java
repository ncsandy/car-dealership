package com.dealership;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileWriters {
	
	
	
	
	public void carWriter(Car car, Inventory inventory) {
		
		car.setPurchased(true);
		ArrayList<Car> update = new ArrayList<Car>();
				
		for(Car cars: inventory.getCarList()) {
			if(cars.isPurchased() == false) {
				update.add(cars);
			}
		}
		
		
		String formattedString = update.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();  //remove extra whitespace
			     
		
		
		BufferedWriter writer;
		try {
			writer = Files.newBufferedWriter(Paths.get("/Users/nicholassandy/git/car-dealership/car-dealership/src/com/dealership//cars.txt"));
			writer.write("");
			writer.flush();
			writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		 PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/nicholassandy/git/car-dealership/car-dealership/src/com/dealership//cars.txt"));
		   
		    pw.println(formattedString);
		    pw.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
