/*	1.	Write a Java program to store text file content line by line 
 		into an array. 
*/

package com.filehandling.bll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreTextFile {
		 
	    public static void main(String args[]){
	        
	        
	        String arr[]= {};
	        try {
	        	BufferedReader in = new BufferedReader(new FileReader("E://Information/test.txt"));
		    	String str;
		    	List<String> list = new ArrayList<String>();
		    	
		    	while((str = in.readLine()) != null){
		    	    list.add(str);
		    	}
		    	/*int i = 0;
		    	while((str = in.readLine()) != null){
		    	    arr[i] = str;
		    	    i++;
		    	}*/
		
		    	arr = list.toArray(new String[0]);

		    	//Display value of array
		    	for(String s:arr)
		    	System.out.println(s);
		    	
		    	in.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }
	}

}
