package org.mangelt.test.threads.read.file;

public class Output implements Runnable {
	
	public Printer printer;
	
	public Output(Printer p){
		printer = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true){
			
			Utility.message("Search for a new string to print every 1 seconds.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			printer.toPrint();
			
		}
		
	}

}
