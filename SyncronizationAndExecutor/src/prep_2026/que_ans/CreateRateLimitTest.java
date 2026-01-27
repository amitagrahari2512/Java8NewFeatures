package prep_2026.que_ans;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/*
 * 
Rate Limiter

Allow N requests per second

Thread-safe

High throughput
 */
public class CreateRateLimitTest {
	public static void main(String[] args) throws InterruptedException {
		TokenBucketRateLimit rateLimit = new TokenBucketRateLimit(100, 10);
		ExecutorService virtualService = Executors.newVirtualThreadPerTaskExecutor();
		for(int i = 0 ; i < 200 ; i++) {
			virtualService.submit(() -> System.out.println(rateLimit.allowRequest() ? "Allowed" : "Not Allowed"));
			Thread.sleep(20);
		}
	}
}

class TokenBucketRateLimit {
	
	private final long capacity;
	private final long refillRate; //Tokens Per second
	private final AtomicLong tokens;
	private volatile long lastRefillTime;
	
	public TokenBucketRateLimit(long capacity, long refillRate) {
		super();
		this.capacity = capacity;
		this.refillRate = refillRate;
		this.tokens = new AtomicLong(capacity);
		this.lastRefillTime = System.nanoTime();
	}
	
	public synchronized boolean allowRequest() {
		refill();
		if(tokens.get() > 0) {
			tokens.decrementAndGet();
			return true;
		}
		return false;
	}
	
	public synchronized void refill() {
		long now = System.nanoTime();
		long elapasedNanos = now - lastRefillTime; 
		
		long tokenToAdd = (elapasedNanos * refillRate) / 1_000_000_000L;
		
		if(tokenToAdd > 0) {
			long newCount = Math.min(capacity, tokens.get() + tokenToAdd);
			tokens.set(newCount);
			lastRefillTime = now;
		}
	}
}
