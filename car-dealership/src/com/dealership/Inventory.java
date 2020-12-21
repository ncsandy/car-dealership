package com.dealership;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Car> carList = new ArrayList<Car>();
	
	public ArrayList<Car> getCarList() {
		return carList;
	}

	public void setCar(ArrayList<Car> carList) {
		this.carList = carList;
	}
	public int discount(int price) {
		double newPrice =  (price) - (price * .10);
		price = (int)newPrice;
		return price;
	}
	
	
	public Inventory() {
        FileReader fopen;
        BufferedReader opened;
        String line;

        ArrayList<Car> carlot = new ArrayList<Car>();

        try {
            fopen = new FileReader("/Users/nicholassandy/git/car-dealership/car-dealership/src/com/dealership/cars.txt");
            opened = new BufferedReader(fopen);

            int parameters = 12; // we have 8 fields in the Car class
            String[] fields = new String[parameters]; // to temporary store fields values read line by line
            int lineCounter = 0;
            while ((line = opened.readLine()) != null) {
                fields[lineCounter] = line;
                lineCounter++;
                if ((lineCounter) % parameters == 0) { //it means we have all 8 fields values for a car
                    int mileage = Integer.parseInt(fields[4]);
                    int residence = Integer.parseInt(fields[5]);
                    boolean used = Boolean.parseBoolean(fields[8]);
                    int price = Integer.parseInt(fields[9]);
                	boolean purchased =Boolean.parseBoolean(fields[10]);
                	
                	carlot.add(new Car(fields[0],fields[1],fields[2],fields[3],mileage,residence,fields[6],fields[7],used,price,purchased,fields[11])); //therefore we create a new car and we add it to the list of cars
                   
                	lineCounter = 0;
                	
                	}

            }
            carList = carlot;
            
            opened.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
	
	
	
	}



}