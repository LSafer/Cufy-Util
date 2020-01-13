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
public class ObjectUtilTest {
	@Test
	public void requireNotNullElse() {
		Object o = ObjectUtil.requireNonNullElse('O', 'D');
		Object p = ObjectUtil.requireNonNullElse(null, 'D');

		Assert.assertEquals("Wrong instance", 'O', o);
		Assert.assertEquals("Wrong instance", 'D', p);

		//noinspection ResultOfMethodCallIgnored
		ObjectUtil.requireNonNullElse('O', null);

		try {
			//noinspection ResultOfMethodCallIgnored
			ObjectUtil.requireNonNullElse(null, null);
			Assert.fail("No null pointer exception");
		} catch (NullPointerException ignored) {
		}
	}

	@Test
	public void requireNotNullElseGet() {
		Object o = ObjectUtil.requireNonNullElseGet('O', () -> 'D');
		Object p = ObjectUtil.requireNonNullElseGet(null, () -> 'D');

		Assert.assertEquals("Wrong instance", 'O', o);
		Assert.assertEquals("Wrong instance", 'D', p);

		ObjectUtil.requireNonNullElseGet('O', () -> null);

		try {
			ObjectUtil.requireNonNullElseGet(null, () -> null);
			Assert.fail("No null pointer exception");
		} catch (NullPointerException ignored) {
		}
	}
}
