package org.mangelt.test.threads.example.java8;

public interface MyInterface {
	
	abstract int sum();
	
	default int sum(int a, int b){
		return 0;
	}
	
	static double suma(int a, int b){
		return 0;
	}

}
