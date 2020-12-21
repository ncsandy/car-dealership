package com.dealership;

public class Car {
    private String make;  //0
    private String model; //1
    private String year;  //2
    private String dateOfPurchase; //3
    private int mileage; //4  //parse
	private int residence; //5 //parse
    private String image; //6
    private String description; //7
    private	boolean used; //8 //parse
    private int price; //9
    private boolean purchased; //10
    private String vin; //11
   
    public Car(String make, String model, String year, String dateOfPurchase, int mileage, int residence, String image,
			String description, boolean used, int price, boolean purchased, String vin) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.dateOfPurchase = dateOfPurchase;
		this.mileage = mileage;
		this.residence = residence;
		this.image = image;
		this.description = description;
		this.used = used;
		this.price = price;
		this.purchased = purchased;
		this.vin = vin;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

    public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean getUsed() {
		return used;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getResidence() {
        return residence;
    }

    public void setResidence(int residence) {
        this.residence = residence;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
    

	public Car() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  "\n" + make + "\n" + model + "\n" + year + "\n" + dateOfPurchase
				+ "\n" + mileage + "\n" + residence + "\n" + image + "\n"
				+ description + "\n" + used + "\n" + price + "\n" + purchased + "\n" + vin;
	}
	
	
	
	


}
