package cufy.util;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("JavaDoc")
public class Object$Test {
	@Test
	public void requireNotNullElse() {
		Object o = Object$.requireNonNullElse('O', 'D');
		Object p = Object$.requireNonNullElse(null, 'D');

		Assert.assertEquals("Wrong instance", 'O', o);
		Assert.assertEquals("Wrong instance", 'D', p);

		//noinspection ResultOfMethodCallIgnored
		Object$.requireNonNullElse('O', null);

		try {
			//noinspection ResultOfMethodCallIgnored
			Object$.requireNonNullElse(null, null);
			Assert.fail("No null pointer exception");
		} catch (NullPointerException ignored) {
		}
	}
	@Test
	public void requireNotNullElseGet() {
		Object o = Object$.requireNonNullElseGet('O', () -> 'D');
		Object p = Object$.requireNonNullElseGet(null, () -> 'D');

		Assert.assertEquals("Wrong instance", 'O', o);
		Assert.assertEquals("Wrong instance", 'D', p);

		Object$.requireNonNullElseGet('O', () -> null);

		try {
			Object$.requireNonNullElseGet(null, () -> null);
			Assert.fail("No null pointer exception");
		} catch (NullPointerException ignored) {
		}
	}
}
