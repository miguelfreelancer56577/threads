package org.mangelt.test.threads;

public class PauseWorker extends Thread{
	
	protected final static String[] words;
	
	static{
		words = new String[4];
		words[0] = "What's ";
		words[1] = "it ";
		words[2] = "going";
		words[3] = " ?";
	}
	
	@Override
	public void run(){
		
			for (int i = 0; i < words.length; i++) {
				
	//			print current word
				System.out.print(words[i]);
	//			sleep during 5 seconds
				
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		
	}

//	print each word every 3 seconds
	public static void main(String[] args) throws InterruptedException {
		
		PauseWorker pw = new PauseWorker();
		
		pw.start();
		
		pw.join();
		
		System.out.println("\nThe second thread has finished.");
				
	}
	
}
