package org.mangelt.test.threads.read.file;

public class Printer implements Runnable {

	public static String content = null;
	
	public void run(){
		
		Utility.message("tring to print content.");
		
		while(true){
			try {
				Utility.message("Check every 5 seconds if there is something to print.");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Utility.message("There was an error to sleep this thread.");
			}
			
			if(!isNull())
				onPrint();
				
		}
		
	}
	
	final synchronized private boolean isNull(){
		boolean result = false;
		if(content == null)
			return true;
		return result;
	} 
	
	public synchronized void onPrint(){
		
		Utility.message("Printing message.");
		Utility.message(content);
		content = null;
		
	}
	
}
