package org.mangelt.test.threads.read.file;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		
		Printer p = new Printer(new File("C:\\Users\\vn0x53q\\workspaceLuna\\threads\\source"));
		
		int i = 0;
		
//		for (i = 0; i < 10; i++) {
			
			Reader r = new Reader(p);
			
			Output n = new Output(p);
			
			new Thread(r, r.getClass().getSimpleName()+i).start();
			new Thread(n, n.getClass().getSimpleName()+i).start();
			
//		}
		
//		00:43:10
		
		
//		String pathDir = "";
//		
//		Printer printer = new Printer();
//		
//		Reader reader = new Reader(printer);
//		
//		Searcher searcher = new Searcher(reader, new File("C:\\Users\\vn0x53q\\workspaceLuna\\threads\\source"));
//
//		new Thread(printer, "Printer").start();
//		new Thread(reader, "Reader").start();
//		new Thread(searcher, "Searcher").start();
		
	}

}
