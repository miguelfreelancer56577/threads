package org.mangelt.test.threads.read.file;

public class Utility {

	public static void message(String message){
		
		String nameThread = Thread.currentThread().getName();
		
		System.out.format("%s: %s%n", nameThread, message);
		
	}
	
}
