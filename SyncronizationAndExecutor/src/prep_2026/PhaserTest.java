package prep_2026;

/*
Scenario

You have an order that goes through multiple stages:

Payment validation

Inventory reservation

Invoice generation

Shipping preparation

Each stage must complete for all required services before moving to the next stage.

Some services may drop out after a phase (e.g., inventory service not needed later).

Perfect fit for Phaser.
 */
import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);// Main Thread Registered
		new Thread(new OrderProcessionPhaser(phaser, "PaymentService")).start();
		new Thread(new OrderProcessionPhaser(phaser, "InventoryService")).start();
		new Thread(new OrderProcessionPhaser(phaser, "BillingService")).start();
		new Thread(new OrderProcessionPhaser(phaser, "ShippingService")).start();
		phaser.arriveAndDeregister();// Main Thread Leaves
	}
}

class OrderProcessionPhaser implements Runnable{
	
	private final Phaser phaser;
	private final String serviceName;
	
	public OrderProcessionPhaser(Phaser phaser, String serviceName) {
		this.phaser = phaser;
		this.serviceName = serviceName;
		phaser.register();//Register phaser
	}

	@Override
	public void run() {
		try {
			process("Payment Validation", 0);
			process("Inventory Reservation", 1);
			
			// Inventory service not needed after this
			if("InventoryService".equalsIgnoreCase(serviceName)) {
				phaser.arriveAndDeregister();
				System.out.println(serviceName + " deregistered");
                return;
			}
			
			process("Invoice Generation", 2);
			process("Shipping Preparation", 3);
			
			phaser.arriveAndDeregister();
			System.out.println(serviceName + " completed all phases");
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void process(String phaseName, int phase) throws InterruptedException {
		System.out.println("Phase : "+ phase + "," + serviceName + " started " + phaseName);
        Thread.sleep(1000); // simulate work

        System.out.println("Phase : "+ phase + "," + serviceName + " finished " + phaseName);
        phaser.arriveAndAwaitAdvance(); // wait for others
	}
}
