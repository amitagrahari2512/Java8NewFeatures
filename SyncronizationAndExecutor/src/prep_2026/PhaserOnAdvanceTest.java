package prep_2026;

import java.util.concurrent.Phaser;

public class PhaserOnAdvanceTest {

	public static void main(String[] args) {
		MyPhaser phaser = new MyPhaser(3);
		Runnable task = () ->{
			while (!phaser.isTerminated()) {
                System.out.println(Thread.currentThread().getName()
                        + " working in phase " + phaser.getPhase());

                phaser.arriveAndAwaitAdvance();
            }
		};
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
	}

}
class MyPhaser extends Phaser {
	public MyPhaser(int parties) {
		super(parties);
	}

	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		 System.out.println("Phase " + phase + " completed.");
         System.out.println("Registered parties: " + registeredParties);

         // Terminate after phase 2 OR if no parties remain
         return phase >= 2 || registeredParties == 0;
	}
}
