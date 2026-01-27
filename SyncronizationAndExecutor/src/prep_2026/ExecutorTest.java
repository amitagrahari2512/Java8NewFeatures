package prep_2026;

import java.util.concurrent.Executor;

public class ExecutorTest {
	public static void main(String[] args) {
		Executor e = command -> new Thread(command).start();
		e.execute(() -> System.out.println("Executor"));
	}
}
