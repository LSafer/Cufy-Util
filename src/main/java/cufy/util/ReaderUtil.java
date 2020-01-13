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

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

/**
 * Useful utils for {@link Reader}s.
 *
 * @author LSaferSE
 * @version 2 release (13-Jan-2020)
 * @since 12-Dec-2019
 */
final public class ReaderUtil {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private ReaderUtil() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Read all the string from the given reader.
	 *
	 * @param reader          to read from
	 * @param bufferCapacity  the capacity of the buffer (higher takes more RAM, lower takes more processing power and time)
	 * @param builderCapacity the initial capacity of the builder (higher takes more RAM, lower takes more processing power and time)
	 * @return all the characters from the given reader
	 * @throws NullPointerException     if the given reader is null
	 * @throws IllegalArgumentException if ether the given 'bufferCapacity' or 'builderCapacity' is less than 1
	 * @throws IOException              if any I/O exception occurs
	 */
	public static String getRemaining(Reader reader, int bufferCapacity, int builderCapacity) throws IOException {
		Objects.requireNonNull(reader, "reader");
		if (bufferCapacity < 1)
			throw new IllegalArgumentException("bufferCapacity is less than 1");
		if (builderCapacity < 1)
			throw new IllegalArgumentException("builderCapacity is less than 1");

		StringBuilder builder = new StringBuilder(builderCapacity);
		char[] buffer = new char[bufferCapacity];

		int l;
		while ((l = reader.read(buffer)) != -1)
			builder.append(buffer, 0, l);

		return builder.toString();
	}
}
