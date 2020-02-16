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

import java.util.HashSet;
import java.util.Map;

@SuppressWarnings("JavaDoc")
public class Object$Test {
	@Test
	public void remoteMap() {
		class TestObject {
			final public int fin = 5;
			public int pub = 3;
			protected int pro = 8;
			int pac = 4;
			private int pri = 11;
		}

		TestObject instance = new TestObject();
		Map<String, Integer> remote = (Map<String, Integer>) (Map) Object$.remoteMap(instance, true);

		Assert.assertEquals("Can't get public fields", (Integer) 3, remote.get("pub"));
		Assert.assertEquals("Can't get package-private fields", (Integer) 4, remote.get("pac"));
		Assert.assertEquals("Can't get protected fields", (Integer) 8, remote.get("pro"));
		Assert.assertEquals("Can't get private fields", (Integer) 11, remote.get("pri"));

		remote.put("pub", 20);
		remote.put("pro", 30);
		remote.put("pac", 40);
		remote.put("pri", 50);

		Assert.assertEquals("Can't replace public fields", (Integer) 20, remote.get("pub"));
		Assert.assertEquals("Can't replace package-private fields", (Integer) 30, remote.get("pro"));
		Assert.assertEquals("Can't replace protected fields", (Integer) 40, remote.get("pac"));
		Assert.assertEquals("Can't replace private fields", (Integer) 50, remote.get("pri"));

		try {
			remote.remove("pac");
			Assert.fail("Remove should not work");
		} catch (UnsupportedOperationException ignored) {
		}
		try {
			remote.clear();
			Assert.fail("Clear should not work");
		} catch (UnsupportedOperationException ignored) {
		}
		try {
			remote.put("x", 1);
			Assert.fail("No such field!");
		} catch (UnsupportedOperationException ignored) {
		}
		try {
			((Map) remote).put("c", "ABCDEF");
			Assert.fail("ClassCastException is expected");
		} catch (UnsupportedOperationException ignored) {
		}

		HashSet<Integer> set = new HashSet<>();

		((Map) remote).forEach((k, v) -> {
			//this$0 and other arguments :)
			if (v instanceof Integer)
				set.add((int) v);
		});

		Assert.assertTrue("Missing value", set.contains(20));
		Assert.assertTrue("Missing value", set.contains(30));
		Assert.assertTrue("Missing value", set.contains(40));
		Assert.assertTrue("Missing value", set.contains(50));
	}
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
