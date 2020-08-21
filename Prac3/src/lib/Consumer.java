package lib;

import java.util.concurrent.*;

public class Consumer extends Thread{
	private int[] ar;
	private Semaphore empty;
	private Semaphore full;
	int out;
	int val;

	public Consumer(int[] a, Semaphore e, Semaphore f) {
		ar = a;
		empty = e;
		full = f;
		out = 0;
	}
	
	public void run() {
		try {
			
			
			for(int i = 0; i < 10; i++) {
				full.acquire();
				val = ar[out];			 
				ar[out] = 0;
				System.out.println("removed " + val + " at position " + out);				
				out = (out + 1) % ar.length;
				System.out.println("\n");
				empty.release();
			}
							
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}


}
