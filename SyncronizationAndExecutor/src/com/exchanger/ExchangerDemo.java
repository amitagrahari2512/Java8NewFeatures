package com.exchanger;

import java.util.concurrent.Exchanger;


/**
 * 
 * Exchanger is the most interesting synchronization class of Java. 
 * It facilitates the exchange of elements between a pair of threads by creating a synchronization point. 
 * It simplifies the exchange of data between two threads. Its operation is simple: 
 * it simply waits until two separate threads call its exchange() method. When that occurs, it exchanges the data supplied by the threads. 
 * It can also be viewed as a bidirectional SynchronousQueue.
 *
 */

public class ExchangerDemo {
	public static void main(String args[]) {
		Exchanger<String> exgr = new Exchanger<String>();
		new UseString(exgr);
		new MakeString(exgr);
	}
}

// A Thread that constructs a string.
class MakeString implements Runnable {
	Exchanger<String> ex;
	String str;

	MakeString(Exchanger<String> c) {
		ex = c;
		str = new String();
		new Thread(this).start();
	}

	public void run() {
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			// Fill Buffer
			for (int j = 0; j < 5; j++)
				str += ch++;
			try {
				// Exchange a full buffer for an empty one.
				str = ex.exchange(str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}

// A Thread that uses a string.
class UseString implements Runnable {
	Exchanger<String> ex;
	String str;

	UseString(Exchanger<String> c) {
		ex = c;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				// Exchange an empty buffer for a full one.
				str = ex.exchange(new String());
				System.out.println("Got: " + str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}
