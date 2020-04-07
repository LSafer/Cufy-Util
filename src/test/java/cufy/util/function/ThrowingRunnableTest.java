package cufy.util.function;

import org.junit.Test;

import java.io.IOException;

@SuppressWarnings("JavaDoc")
public class ThrowingRunnableTest {
	@Test(expected = IOException.class)
	public void run() {
		//noinspection RedundantCast
		((Runnable) (ThrowingRunnable<IOException>) () -> {
			throw new IOException();
		}).run();
	}
}
