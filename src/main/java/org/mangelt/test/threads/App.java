package org.mangelt.test.threads;

/**
 * Hello world!
 *
 */
public class App extends Thread
{
	@Override
	public void run(){
		System.out.println("Hello world from the thread.");
	}
	
    public static void main( String[] args )
    {
        new App().start();
    }
}
