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
		
		//setting the car to purchased 
		car.setPurchased(true);
		
		ArrayList<Car> update = new ArrayList<Car>(); 
		
		for(Car cars: inventory.getCarList()) {
			if(cars.isPurchased() == false) {
				update.add(cars);
			}
		}
		
		//formatting the strings
		String formattedString = update.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();  //remove extra whitespace
			     
		
		//deleting all contents in file
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
		//writing new contents in file
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

	public void customerWriter(ArrayList<Customer> customerlist) {
		
		//formatting string
		
		customerlist.sort(new DateSorter());
		String temp;
		String formattedString = customerlist.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .replaceAll("\\u00A0", "")
			    .trim()  //remove extra whitespace
			    .replace("\n\n", "\n");
		temp = formattedString;
		temp.trim();
		formattedString=temp;
		
		
			     
	
		try {
			 PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/nicholassandy/git/car-dealership/car-dealership/src/com/dealership//purchaselog.txt"));
			   
			    pw.println(formattedString);
			    pw.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	
	}

	public void addCar(Car car, Inventory inventory) {
		
		
		ArrayList<Car> update = inventory.getCarList(); //we get current inventory session here..
		
		//formatting the strings
		String formattedString = update.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();  //remove extra whitespace
			     
		
		//deleting all contents in file
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
		//writing new contents in file
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
