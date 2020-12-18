package com.dealership;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Car> carList = new ArrayList<Car>();
	
	public ArrayList<Car> getCarList() {
		return carList;
	}

	public void setCar(ArrayList<Car> carList) {
		this.carList = carList;
	}


	
	public Inventory() {
        FileReader fopen;
        BufferedReader opened;
        String line;

        ArrayList<Car> carlot = new ArrayList<Car>();
        try {
            fopen = new FileReader("/Users/nicholassandy/eclipse-workspace/car-dealership/build/classes/com/dealership/cars.txt");
            opened = new BufferedReader(fopen);

            int parameters = 10; // we have 8 fields in the Car class
            String[] fields = new String[parameters]; // to temporary store fields values read line by line
            int lineCounter = 0;
            while ((line = opened.readLine()) != null) {
                fields[lineCounter] = line;
                lineCounter++;
                if ((lineCounter) % parameters == 0) { //it means we have all 8 fields values for a car
                    int mileage = Integer.parseInt(fields[4]);
                    int residence = Integer.parseInt(fields[5]);
                    boolean used = Boolean.parseBoolean(fields[8]);
                	
                	carlot.add(new Car(fields[0],fields[1],fields[2],fields[3],mileage,residence,fields[6],fields[7],used,fields[9])); //therefore we create a new car and we add it to the list of cars
                    lineCounter = 0;
                	
                	}

            }
            carList = carlot;
            
            opened.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

	public void discount(String price){
		price = price.replaceAll("[^0-9]", "");
		int newPrice = Integer.parseInt(price);
		double discountPrice = (newPrice - (newPrice * .10));
		newPrice = (int)discountPrice;
	}
	


}