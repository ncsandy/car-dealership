package com.dealership;



public class Customer implements Comparable<Customer>  {

	private String firstName;
	private String lastName;
	private String date;
	private Car car;
	
	public Customer() {
		
		
	}
	

	public Customer(String firstName, String lastName, String date, Car car) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.car = car;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


	@Override
	public String toString() {
		return firstName + "\n" + lastName + "\n" + date + "\n" + car + "\n";
	}
		
	@Override
	public int compareTo(Customer o) {
		return getDate().compareTo(o.getDate());
	}
	
}
