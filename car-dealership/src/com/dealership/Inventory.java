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

	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
	
	public int discount(int price) {                  //this method is to apply discount to 120+ residence cars
		double newPrice =  (price) - (price * .10);
		price = (int)newPrice;
		return price;
	}
	
	
	public void special(ArrayList<Car> cars) {    //this is to update the array and apply the discounts
		for(Car car: cars) {
			if(car.getResidence() > 120) {
				car.setPrice(discount(car.getPrice()));
			}
		}
		
	}
	

	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
		
		
	}
	
	
	
	public void setCar(ArrayList<Car> carList) {
		this.carList = carList;
	}
	
	public int compare(Customer o1, Customer o2) {
		return o2.getDate().compareTo(o1.getDate());
	}
	
	
	public Inventory() {
       
		loadInventory();
		loadPurchase();
	
	
	}

	
public void loadInventory() {
		 FileReader fopen;
	        BufferedReader opened;
	        String line;


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
	                	
	                	carList.add(new Car(fields[0],fields[1],fields[2],fields[3],mileage,residence,fields[6],fields[7],used,price,purchased,fields[11])); //therefore we create a new car and we add it to the list of cars
	                	
	                	
	                	
	                	lineCounter = 0;
	                	
	                	}

	            }
	           
	            
	            special(carList);
	            
	            opened.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
		
	}
	
public void loadPurchase() {
	 FileReader fopen;
     BufferedReader opened;
     String line;
     
     try {
         fopen = new FileReader("/Users/nicholassandy/git/car-dealership/car-dealership/src/com/dealership/purchaselog.txt");
         opened = new BufferedReader(fopen);
	
         int parameters = 15; // we have 15 fields customer class
         String[] fields = new String[parameters]; // to temporary store fields values read line by line
         int lineCounter = 0;
         while ((line = opened.readLine()) != null) {
             fields[lineCounter] = line;
             lineCounter++;
             if ((lineCounter) % parameters == 0) { //it means we have all 15 fields values for a customer
                int mileage = Integer.parseInt(fields[7]);
                int residence = Integer.parseInt(fields[8]);
                boolean used = Boolean.parseBoolean(fields[11]);
                 int price = Integer.parseInt(fields[12]);
            	boolean purchased =Boolean.parseBoolean(fields[13]);
             	
             	customerList.add(new Customer(fields[0],fields[1],fields[2],new Car(fields[3],fields[4],fields[5],fields[6],mileage,residence,fields[9],
             			fields[10],used,price,purchased,fields[14]))); //therefore we create a new car and we add it to the list of cars
                
             	lineCounter = 0;
             	
             	}

         }
        
       
        customerList.sort(new DateSorter()); //we sort the customers by date of purchase here..
         opened.close();
     } catch (IOException e) {
         e.printStackTrace();
     } 
      
    
}
}