package org.mangelt.test.threads.read.file;

import java.io.File;
import java.io.FileNotFoundException;

public class Searcher implements Runnable{
	
	protected Reader reader;
	
	protected File pathToDirectory;
	
	protected static final String patternFileToSelect;
	
	static{
		patternFileToSelect = ".txt";
	}

	public void run(){
		
		Utility.message("start searching files.");
		
		while(true) {
			
			try {
					
				onValidate();
				
				onSearch();
				
				Utility.message("Search a new file every 30 seconds.");
				Thread.sleep(30000);
				
			} catch (InterruptedException e) {
				Utility.message("There was an error to try sleeping thread.");
			} catch (FileNotFoundException e) {
				Utility.message(e.getMessage());
			} catch (Exception e) {
				Utility.message("there was something wrong else.");
			}
			
		}
		
	}
	
	public synchronized void onSearch(){
		
		File[] listFiles = pathToDirectory.listFiles();
		
		for (File file : listFiles) {
			
			String nameConcurrentFile = file.getName().toString();
			
			String extensionFile = nameConcurrentFile.substring((file.getName().length()-4),file.getName().length());
			
			if(extensionFile.equalsIgnoreCase(patternFileToSelect)){
				
				Utility.message("getting file: " + file);
				
//				reader.cuncurrentFile = file;
				
				notify();
				
				break;
				
			}
				
		}
		
	}
	
	public Searcher(Reader reader, File pathToDirectory){
		this.reader = reader;
		this.pathToDirectory = pathToDirectory;
	}
	
	public synchronized void onValidate () throws FileNotFoundException{
		if(!this.pathToDirectory.exists())
			throw new FileNotFoundException("Directory doesn't exit");
	}
	
}
