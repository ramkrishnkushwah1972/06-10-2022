package com.filehandling.bll;

import java.io.BufferedReader;
import java.io.IOException;

public class Car {
	private String model;
	private int manufacturingYear; 
	private int kilometers; 
	private double price;
	
	//Parameterized constructor
	public Car(String model, int manufacturingYear, int kilometers, double price) {
		this.model = model;
		this.manufacturingYear = manufacturingYear;
		this.kilometers = kilometers;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
	public int getKilometers() {
		return kilometers;
	}
	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean equalTo(Car c) {
		return 	(this.model.equals(c.model) &&
				this.manufacturingYear == c.manufacturingYear &&
				this.kilometers == c.kilometers &&
				this.price == c.price);
	}
	
	public static Car read(BufferedReader br) throws IOException {
		String s = br.readLine();
		Car car=null;
		if (s == null)
			return car;
		else {
			car = new Car(s, Integer.parseInt(br.readLine()),
					Integer.parseInt(br.readLine()),
					Double.parseDouble(br.readLine()));
		}
		return car;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", manufacturingYear=" + manufacturingYear + ", kilometers=" + kilometers
				+ ", price=" + price + "]";
	}
	
	
	

}
