package org.mangelt.test.threads.read.file;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		
		String pathDir = "";
		
		Printer printer = new Printer();
		
		Reader reader = new Reader(printer);
		
		Searcher searcher = new Searcher(reader, new File("C:\\Users\\vn0x53q\\workspaceLuna\\threads\\source"));

		new Thread(printer, "Printer").start();
		new Thread(reader, "Reader").start();
		new Thread(searcher, "Searcher").start();
		
	}

}
