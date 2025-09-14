package com.Phaser.onAdvance;

import java.util.concurrent.Phaser;

public class PhaserOnAdvanceTest {
	public static void main(String args[]) {
		MyPhaser phsr = new MyPhaser(1, 4);
		System.out.println("Starting\n");
		new MyThreadOnAdvance(phsr, "A");
		new MyThreadOnAdvance(phsr, "B");
		new MyThreadOnAdvance(phsr, "C");
		new MyThreadOnAdvance(phsr, "D");
		new MyThreadOnAdvance(phsr, "E");
		// Wait for the specified number of phases to complete.
		while (!phsr.isTerminated()) {
			phsr.arriveAndAwaitAdvance();
		}
		System.out.println("The Phaser is terminated");
	}
}

// Extend MyPhaser to allow only a specific number of phases
// to be executed.
class MyPhaser extends Phaser {
	int numPhases;

	MyPhaser(int parties, int phaseCount) {
		super(parties);
		numPhases = phaseCount - 1;
	}

	// Override onAdvance() to execute the specified
	// number of phases.
	protected boolean onAdvance(int p, int regParties) {
		// This println() statement is for illustration only.
		// Normally, onAdvance() will not display output.
		System.out.println("Phase " + p + " completed.\n");
		// If all phases have completed, return true
		if (p == numPhases || regParties == 0)
			return true;
		// Otherwise, return false.
		return false;
	}
}

// A thread of execution that uses a Phaser.
class MyThreadOnAdvance implements Runnable {
	Phaser phsr;
	String name;

	MyThreadOnAdvance(Phaser p, String n) {
		phsr = p;
		name = n;
		phsr.register();
		new Thread(this).start();
	}

	public void run() {
		while (!phsr.isTerminated()) {
			System.out.println("Thread " + name + " Beginning Phase " + phsr.getPhase());
			phsr.arriveAndAwaitAdvance();
			// Pause a bit to prevent jumbled output. This is for illustration
			// only. It is not required for the proper operation of the phaser.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}