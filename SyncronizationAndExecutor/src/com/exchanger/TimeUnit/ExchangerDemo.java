package com.exchanger.TimeUnit;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
				str = ex.exchange(str , 1000 , TimeUnit.NANOSECONDS);
			} catch (TimeoutException exc) {
				System.out.println(exc);
			}catch (InterruptedException exc) {
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
				str = ex.exchange(new String() , 1000 , TimeUnit.NANOSECONDS);
				System.out.println("Got: " + str);
			} catch (TimeoutException exc) {
				System.out.println(exc);
			}catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}