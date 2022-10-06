package com.filehandling.bll;

import java.io.*;

public class CarList {
	private String filename;
	
	public CarList (String filename){
		this.filename = filename;
	}
	
	public int countNewCars() throws IOException {
		FileReader fread = new FileReader(filename);
		BufferedReader buffer_read = new BufferedReader(fread);
		int count = 0;
		Car c = Car.read(buffer_read);
		while (c != null) {
			if (c.getKilometers() == 0)
				count++;
			c = Car.read(buffer_read);
		}
		buffer_read.close();
		
		return count;
	}
	
	public Car mostExpensiveCar() throws IOException {
		FileInputStream is = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		double max = 0;
		Car cmax = null;
		Car c = Car.read(br);
		while (c != null) {
			if (c.getPrice() > max) {
				max = c.getPrice();
				cmax = c;
			}
			c = Car.read(br);
		}
		br.close();
		return cmax;
	}
	
	public void addCar(Car c) throws IOException {
		FileWriter fw = new FileWriter(filename, true);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(c.getModel());
		pw.println(c.getManufacturingYear());
		pw.println(c.getKilometers());
		pw.println(c.getPrice());
		pw.close();
	}
	
	public void removeCar(Car c) throws IOException {
		File file = new File(filename);
		FileInputStream inputs = new FileInputStream(file);
		InputStreamReader input_stream_reader = new InputStreamReader(inputs);
		
		BufferedReader br = new BufferedReader(input_stream_reader);
		
		File newfile = new File("E://newcar.txt");
		FileOutputStream fos = new FileOutputStream(newfile);
		PrintWriter pw = new PrintWriter(fos);
		Car car = Car.read(br);
		while (car != null) {
			if (!car.equalTo(c)) {
				pw.println(car.getModel());
				pw.println(car.getManufacturingYear());
				pw.println(car.getKilometers());
				pw.println(car.getPrice());
			}
			car = Car.read(br);
		}
		br.close();
		pw.close();
		newfile.renameTo(file);
	}
}