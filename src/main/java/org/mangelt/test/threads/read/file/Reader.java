package org.mangelt.test.threads.read.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader implements Runnable {
	
	public static File cuncurrentFile = null;
	
	public void run(){
		
		Utility.message("start reading files.");
		
		try {
			onEmpty();
		} catch (InterruptedException e) {
			Utility.message("There was an error to try sleeping this thread.");
		} catch (IOException e) {
			Utility.message("There was an error to try read the content of the File.");
		}
		
	}
	
	public void onEmpty() throws InterruptedException, IOException{
		
		while(true){
			
			Utility.message("Check every 5 seconds if there is a new file to process.");
			Thread.sleep(5000);
			
			if(!isNull())
				onRead();
			
		}
		
	}
	
	public synchronized boolean isNull(){
		boolean result = false;
		if(cuncurrentFile == null)
			return true;
		return result;
	}
	
	public synchronized void onRead() throws IOException{
		
		printer.content = new String(Files.readAllBytes(cuncurrentFile.toPath())).trim();
		
//		StringBuilder sb = new StringBuilder();
//		
//		Stream<String> lines = Files.lines(cuncurrentFile.toPath());
//		
//		lines.forEach( (l) -> {
//			sb.append(l).append("\n");
//		});
//		
//		lines.close();
//		
//		printer.content = sb.toString().trim();
		
		Utility.message("deleting and unasigning current file.");
		cuncurrentFile.delete();
		cuncurrentFile = null;
		Utility.message("File has been deleted and unasigned.");
		
	}
	
	public Reader(Printer p){
		printer = p;
	}
	
	protected Printer printer;
	
}
