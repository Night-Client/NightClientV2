package booogyboooo.nightclientv2.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Util for delays
 */
public class DelayUtil {
	/**
	 * Run code later (Delay)
	 * <br>
	 * - timeout(code, delay)
	 * <br>
	 * <br>
	 * code
	 * <br>
	 * - A Runnable object () -> {}
	 * <br>
	 * <br>
	 * delay
	 * <br>
	 * - Delay in milliseconds
	 */
	public static void timeout(Runnable code, int delay) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(code, delay, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
	}
}