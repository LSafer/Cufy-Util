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

package org.cufy.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@SuppressWarnings({"JavaDoc", "LocalVariableNamingConvention", "NonBooleanMethodNameMayNotStartWithQuestion"})
public class ReaderUtilTest {
	@Test
	public void collect() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(STRING);
		String collected = ReaderUtil.read(reader);

		Assert.assertEquals("Not collected correctly", STRING, collected);
	}

	@Test
	public void equalsFalseTrueFalseSingle() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(STRING);

		boolean w0 = ReaderUtil.equals(reader, false, true, false, STRING);
		boolean w1 = ReaderUtil.equals(reader, false, true, false, "ABC DEF");

		Assert.assertTrue("Equals not detected", w0);
		Assert.assertFalse("Not equals", w1);
	}

	@Test
	public void equalsFalseFalseFalseSingle() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(STRING + "GHI");

		boolean w0 = ReaderUtil.equals(reader, false, false, false, STRING);
		boolean w1 = ReaderUtil.equals(reader, false, false, false, "ABC DEF GHI");

		Assert.assertTrue("Equals not detected", w0);
		Assert.assertFalse("Not equals", w1);
	}

	@Test
	public void equalsTrueFalseFalseSingle() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(" \n\t" + STRING + "DEF \t\n");

		boolean w0 = ReaderUtil.equals(reader, true, false, false, STRING);
		boolean w1 = ReaderUtil.equals(reader, true, false, false, " \t\nABC DEF GHI \t\n");

		Assert.assertTrue("Equals not detected", w0);
		Assert.assertFalse("Not equals", w1);
	}

	@Test
	public void equalsTrueTrueFalseSingle() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(" \n\t" + STRING + " \t\n");

		boolean w0 = ReaderUtil.equals(reader, true, true, false, STRING);
		boolean w1 = ReaderUtil.equals(reader, true, true, false, " \t\nABC DEF GHI \t\n");

		Assert.assertTrue("Equals not detected", w0);
		Assert.assertFalse("Not equals", w1);
	}

	@Test
	public void skip() throws IOException {
		Reader reader = new StringReader("ABC");
		ReaderUtil.skip(reader, i -> i == 'A' || i == 'B');
		Assert.assertEquals("Not skipped", 'C', reader.read());
	}
}
