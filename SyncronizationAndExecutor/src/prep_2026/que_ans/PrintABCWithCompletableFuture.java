package prep_2026.que_ans;

import java.util.concurrent.CompletableFuture;

public class PrintABCWithCompletableFuture {

	public static void main(String[] args) {
		CompletableFuture<Void> chain = CompletableFuture.completedFuture(null);
		for(int i = 0 ; i < 10; i++) {
			chain.thenRun(() -> System.out.print("A"))
					.thenRun(() -> System.out.print("B"))
					.thenRun(() -> System.out.print("C"));
			
			chain.join();
		}
	}

}
