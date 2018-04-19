package org.mangelt.test.threads;

public class Runner implements Runnable {

	public void run() {
//		how to use the runnable interface
		System.out.println("how to use the runnable interface");
	}
	
	public static void main(String ... args){
		new Thread(new Runner()).start();
	}

}
