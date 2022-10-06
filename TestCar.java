/*	3.	We want to realize a program for handling new and used cars to sell.
		
		For each car to sell, the information about the car is stored on a text file.
		
		Realize a class Car, to handle a single car.
		 
		Each car is characterized by the following information: 
			model,
			manufacturing year, 
			driven kilometers, 
			and price. 
			
		New cars can be distinguished by the fact that the driven kilometers are 0.
		
		The class Car should export the following methods:
		
		• a constructor to construct a car object, given all the data about the car as parameters;
		
		• suitable get-methods to obtain the data about the car;
		
		• a toString method, which does overriding of the toString method inherited from Object, and returns a string containing the data about the car;
		
		• boolean equalTo(Car c) : that returns true if the car coincides with the car c in all of its data, and false otherwise.
		
		• public static Car read(BufferedReader br) throws IOException : that returns a Car object reading from the file.
		
		Realize a class CarList, each of whose objects represents a list of cars to sell. 
		
		A CarList object does not directly store the data about the cars to sell, but maintains the name of a text file in which such data are stored, according to the following format:
		
		model
		manufacturing year (year)
		driven kilometers (km)
		price
		
		The class CarList should export the following methods:
		
		• CarList(String filename) : constructor with a parameter of type String, representing the name of the file in which the data about the cars to sell are stored;
		
		• int countNewCars() : that returns the number of new cars in the list of cars to sell;
		
		• Car mostExpensiveCar() : that returns the Car object corresponding to the most expensive car in the list of cars to sell.
		
		• void addCar(Car c) : that adds the car c to the end of the list of cars to sell.
		
		• void remove(Car c) : that removes from the list of cars to sell the car whose data coincides with that of c, if such a car is present, and leaves the list unchanged otherwise.
*/
package com.filehandling.bll;

import java.io.File;
import java.io.IOException;

public class TestCar {

	public static void main(String[] args) {
		try {
			
			Car car1 = new Car("Toyoto001",2022,0,1282);
			Car car2 = new Car("Toyoto001",2022,0,12);
			Car car3 = new Car("Toyoto003",2022,0,13);
			Car car4 = new Car("Toyoto004",2022,0,14);
			Car car5 = new Car("Toyoto005",2022,0,15);
			Car car6 = new Car("Toyoto006",2022,0,16);
			
			//Creat a array for storing cars
			Car cars[] =new Car[]{car1,car2,car3,car4,car5,car6};
			
			CarList carlist = new CarList("E://car.txt");
			
			File file = new File("E://car.txt");
			file.delete();
			
			//Add car objects in a file
			for(Car car: cars) {
				carlist.addCar(car);
			}
			
			
			System.out.println("Total New Cars :"+carlist.countNewCars());
			
			System.out.println("Most Expensive Car :"+carlist.mostExpensiveCar());
			
			carlist.removeCar(car2);
			System.out.println("Total New Cars After remove car :"+carlist.countNewCars());
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
