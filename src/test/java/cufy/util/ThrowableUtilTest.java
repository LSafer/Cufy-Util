package cufy.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.function.Supplier;

@SuppressWarnings("JavaDoc")
public class ThrowableUtilTest {
	@Test(expected = IOException.class)
	public void ignite() {
		try {
			//noinspection TrivialFunctionalExpressionUsage
			((Supplier<Object>) () -> {
				throw ThrowableUtil.ignite(new IOException());
			}).get();
		} catch (Exception e) {
			throw ThrowableUtil.ignite(e);
		}

		Assert.fail("The exception haven't been caught");
	}
}
