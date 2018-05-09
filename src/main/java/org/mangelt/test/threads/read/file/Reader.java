package org.mangelt.test.threads.read.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader implements Runnable {
	
	public Printer printer;
	
	public void run(){
		
		while (true) {
			
			Utility.message("Search for a new document every 1 second.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				printer.getContentFromFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public Reader(Printer p){
		printer = p;
	} 
	
}
