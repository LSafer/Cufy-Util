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
public class Reader$Test {
	@Test
	public void getRemaining() throws IOException {
		final String STRING = "ABCDEF";
		Reader reader = new StringReader(STRING);
		String collected = Reader$.getRemaining(reader, 50, 50);

		Assert.assertEquals("Not collected correctly", STRING, collected);
	}

	@Test
	public void isRemainingEquals() throws IOException {
		StringReader reader = new StringReader("AbCdEf");

		reader.mark(0);

		//no trim & no fullRead & no ignoreCase
		Assert.assertEquals("Should equals", 2, Reader$.isRemainingEquals(reader, false, false, false, "AB", "X", "AbC", "ABCDEF"));
		reader.reset();
		Assert.assertEquals("Should not equals", -1, Reader$.isRemainingEquals(reader, false, false, false, "AbCD", "  AbCdEf  ", "E", "ABCDEF"));
		reader.reset();

		//no trim & no fullRead & ignoreCase
		Assert.assertEquals("should equals", 3, Reader$.isRemainingEquals(reader, false, false, true, "x", "Y", "E", "ABCDEF", "AbCx"));
		reader.reset();

		//no trim & fullRead & no ignoreCase

		//no trim & fullRead & ignoreCase
		Assert.assertEquals("Should equals", 3, Reader$.isRemainingEquals(reader, false, true, true, "A", "X", "ABC", "ABCDEF"));
		reader.reset();
		Assert.assertEquals("Should not equals", -1, Reader$.isRemainingEquals(reader, false, true, true, "A", "  AbCdEf  ", "E", "R"));
		reader.reset();

		//trim & no fullRead & no ignoreCase

		//trim & no fullRead & ignoreCase

		//trim & fullRead & no ignoreCase

		//trim & fullRead & ignoreCase
	}
}
