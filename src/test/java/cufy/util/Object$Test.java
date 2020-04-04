/*
 * Copyright (c) 2019, LSafer, All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * -You can edit this file (except the header).
 * -If you have change anything in this file. You
 *   shall mention that this file has been edited.
 *   By adding a new header (at the bottom of this header)
 *   with the word "Editor" on top of it.
 */

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
