package org.mangelt.test.threads.read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Printer{

	private String content = null;
	
	private File pathToDirectory;
	
	public Printer(File d){
		pathToDirectory = d;
	}
	
	private synchronized String getContent() {
		return content;
	}

	private synchronized void setContent(String content) {
		this.content = content;
	}

	private File getPathToDirectory() {
		return pathToDirectory;
	}

	private void setPathToDirectory(File pathToDirectory) {
		this.pathToDirectory = pathToDirectory;
	}
	
	final synchronized private boolean isContentNull(){
		boolean result = false;
		if(content == null)
			return true;
		return result;
	}
	
	final synchronized private boolean isPathToDirectoryNull(){
		boolean result = false;
		if(content == null)
			return true;
		return result;
	}
	
	final synchronized void getContentFromFile() throws IOException{
		
		while (!isContentNull()) {
			try {
				Utility.message("wait until content becomes null.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		File[] listFiles = pathToDirectory.listFiles();
		
		for (File file : listFiles) {
			
			String nameConcurrentFile = file.getName().toString();
			
			String extensionFile = nameConcurrentFile.substring((file.getName().length()-4),file.getName().length());
			
			if(extensionFile.equalsIgnoreCase(".txt")){
				
				Utility.message("getting file: " + file);
				
				setContent(new String(Files.readAllBytes(Paths.get(file.getAbsolutePath()))));
				
				file.delete();
				
				break;
				
			}
				
		}
		
		notifyAll();
		
	}
	
	final synchronized void toPrint(){
		
		while (isContentNull()) {
			
			try {
				Utility.message("wait until content has something.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Utility.message(getContent());
		
		setContent(null);
		
		notifyAll();
		
	}
	

	
}
