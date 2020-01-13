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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@SuppressWarnings({"JavaDoc"})
public class ReaderUtilTest {
	@Test
	public void getRemaining() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(STRING);
		String collected = ReaderUtil.getRemaining(reader, 50, 50);

		Assert.assertEquals("Not collected correctly", STRING, collected);
	}
}
