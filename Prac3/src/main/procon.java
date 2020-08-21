package main;

import lib.*;
import java.util.concurrent.*;

public class procon {

	public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[5];
		
		Semaphore empty = new Semaphore(5);
		Semaphore full = new Semaphore(0);
		
		
		Producer m1 = new Producer(arr, empty,full);
	    Consumer m2 = new Consumer(arr, empty,full);
		
		m1.start();
		m2.start();
		m1.join();
		m2.join();
		

	}

}
