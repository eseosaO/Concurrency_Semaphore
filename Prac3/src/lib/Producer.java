package lib;

import java.util.concurrent.*;

public class Producer extends Thread{
	private int[] ar;
	private Semaphore empty;
	private Semaphore full;
	int in ;

	public Producer(int[] a, Semaphore e, Semaphore f) {
		ar = a;
		empty = e;
		full = f;
	    in = 0;
	}
	
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				empty.acquire();
				ar[in] = i ;
				System.out.println("added " + i + " at index in = " + in);
				in = (in + 1) % ar.length;
				System.out.println("Next available slot at " + "index in = " + in);
				//System.out.println("No. of Available slot: " + "empty = " + empty.availablePermits());
				System.out.println("\n");
				full.release();
			}
		}
		catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	
}
}
