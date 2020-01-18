package cufy.util;

import org.junit.Test;

import java.io.IOException;
import java.util.function.Supplier;

@SuppressWarnings("JavaDoc")
public class ThrowableUtilTest {
	@Test(expected = IOException.class)
	public void ignite() {
		//noinspection TrivialFunctionalExpressionUsage
		((Supplier<Object>) () -> {
			throw ThrowableUtil.ignite(new IOException());
		}).get();
	}
}