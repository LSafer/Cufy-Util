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

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Useful utils for {@link Reader}s.
 *
 * <ul>
 *     The meaning of last characters on method names:
 *     <li>n: (next) don't check to the last of the {@link Reader}</li>
 *     <li>t: (trim) don't include whitespace characters on the first or the last of the string</li>
 * </ul>
 *
 * @author LSaferSE
 * @version 1 beta (13-Dec-2019)
 * @since 12-Dec-2019
 */
final public class ReaderUtil {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 */
	private ReaderUtil() {
		throw new AssertionError();
	}

//	/**
//	 * Get if the next string on the given reader (until the end) is equals to the given string.
//	 *
//	 * @param reader to read from
//	 * @param string to compare to
//	 * @return whether the next string of the given reader (until the end) equals to the given string
//	 * @throws IOException if any I/O exception occurs
//	 */
//	public static boolean equals(Reader reader, String string) throws IOException {
//		reader.mark(50);
//		boolean w = true;
//		for (char c : string.toCharArray())
//			if ((char) reader.read() != c) {
//				w = false;
//				break;
//			}
//		w = w && reader.read() == -1;
//		reader.reset();
//		return w;
//	}
//
//	/**
//	 * Get if the next string on the given reader (until the end) is equals to any of the given strings.
//	 *
//	 * @param reader  to read from
//	 * @param strings to compare to
//	 * @return whether the next string of the given reader (until the end) equals to any of the given strings
//	 * @throws IOException if any I/O exception occurs
//	 */
//	@SuppressWarnings("OverloadedVarargsMethod")
//	public static boolean equals(Reader reader, String... strings) throws IOException {
//		for (String string : strings)
//			if (equals(reader, string))
//				return true;
//		return false;
//	}
//
//	/**
//	 * Get if the next string on the given reader is equals to the given string.
//	 *
//	 * @param reader to read from
//	 * @param string to compare to
//	 * @return whether the next string of the given reader equals to the given string
//	 * @throws IOException if any I/O exception occurs
//	 */
//	public static boolean equalsn(Reader reader, String string) throws IOException {
//		reader.mark(50);
//		boolean w = true;
//		for (char c : string.toCharArray())
//			if ((char) reader.read() != c) {
//				w = false;
//				break;
//			}
//		reader.reset();
//		return w;
//	}
//
//	/**
//	 * Get if the next string on the given reader is equals to any of the given strings.
//	 *
//	 * @param reader  to read from
//	 * @param strings to compare to
//	 * @return whether the next string of the given reader equals to any of the given strings
//	 * @throws IOException if any I/O exception occurs
//	 */
//	@SuppressWarnings("OverloadedVarargsMethod")
//	public static boolean equalsn(Reader reader, String... strings) throws IOException {
//		for (String string : strings)
//			if (equalsn(reader, string))
//				return true;
//		return false;
//	}
//
//	/**
//	 * Get if the next string on the given reader (trimmed) is equals to the given string.
//	 *
//	 * @param reader to read from
//	 * @param string to compare to
//	 * @return whether the next string of the given reader (trimmed) equals to the given string
//	 * @throws IOException if any I/O exception occurs
//	 */
//	public static boolean equalsnt(Reader reader, String string) throws IOException {
//		reader.mark(50);
//		skip(reader, Character::isWhitespace);
//		boolean w = true;
//		for (char c : string.toCharArray())
//			if ((char) reader.read() != c) {
//				w = false;
//				break;
//			}
//		reader.reset();
//		return w;
//	}
//
//	/**
//	 * Get if the next string on the given reader (trimmed) is equals to any of the given strings.
//	 *
//	 * @param reader  to read from
//	 * @param strings to compare to
//	 * @return whether the next string of the given reader (trimmed) equals to any of the given strings
//	 * @throws IOException if any I/O exception occurs
//	 */
//	@SuppressWarnings("OverloadedVarargsMethod")
//	public static boolean equalsnt(Reader reader, String... strings) throws IOException {
//		for (String string : strings)
//			if (equalsn(reader, string))
//				return true;
//		return false;
//	}
//
//	/**
//	 * Get if the next string on the given reader (until the end)(trimmed) is equals to the given string.
//	 *
//	 * @param reader to read from
//	 * @param string to compare to
//	 * @return whether the next string of the given reader (until the end)(trimmed) equals to the given string
//	 * @throws IOException if any I/O exception occurs
//	 */
//	public static boolean equalst(Reader reader, String string) throws IOException {
//		reader.mark(50);
//		skip(reader, Character::isWhitespace);
//		boolean w = true;
//		for (char c : string.toCharArray())
//			if ((char) reader.read() != c) {
//				w = false;
//				break;
//			}
//		if (w) {
//			int cha;
//			while (Character.isWhitespace(cha = reader.read())) ;
//			w = cha < 0;
//		}
//		reader.reset();
//		return w;
//	}
//
//	/**
//	 * Get if the next string on the given reader (until the end)(trimmed) is equals to any of the given strings.
//	 *
//	 * @param reader  to read from
//	 * @param strings to compare to
//	 * @return whether the next string of the given reader (until the end)(trimmed) equals to any of the given strings
//	 * @throws IOException if any I/O exception occurs
//	 */
//	@SuppressWarnings("OverloadedVarargsMethod")
//	public static boolean equalst(Reader reader, String... strings) throws IOException {
//		for (String string : strings)
//			if (equalst(reader, string))
//				return true;
//		return false;
//	}

	/**
	 * Check if the string from the given reader equals to any of the given strings.
	 *
	 * @param reader     to read from
	 * @param trim       whether to ignore whitespaces on the first or last of the string
	 * @param fullRead   whether to skip reading once the string matches the read string
	 * @param ignoreCase whether to ignore the characters cases
	 * @param strings    to be checked for
	 * @return whether the string from the given reader equals any of the given strings
	 * @throws IOException if any I/O exception occurs
	 */
	@SuppressWarnings({"OverloadedVarargsMethod", "OverlyComplexMethod"})
	public static boolean equals(Reader reader, boolean trim, boolean fullRead, boolean ignoreCase, String... strings) throws IOException {
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		reader.mark(50);

		if (trim) skip(reader, Character::isWhitespace);
		if (ignoreCase) list.replaceAll(String::toLowerCase);

		int cha;
		while ((cha = reader.read()) != -1) {
			char point = ignoreCase ? Character.toLowerCase((char) cha) : (char) cha;

			if (!trim || !Character.isWhitespace(point))
				list.removeIf(String::isEmpty);

			list.replaceAll(s -> s.isEmpty() ? "" : (ignoreCase ? Character.toLowerCase(s.charAt(0)) : s.charAt(0)) == point ? s.substring(1) : null);
			list.removeIf(Objects::isNull);
			if (!fullRead && list.contains(""))
				return true;
		}

		reader.reset();
		return list.contains("");
	}

	/**
	 * Read all the string from the given reader.
	 *
	 * @param reader to read from
	 * @return all the characters from the given reader
	 * @throws IOException if any I/O exception occurs
	 */
	public static String read(Reader reader) throws IOException {
		reader.mark(50);
		int i;
		StringBuilder builder = new StringBuilder(50);
		while ((i = reader.read()) > -1)
			builder.append((char) i);
		reader.reset();
		return builder.toString();
	}

	/**
	 * {@link Reader#skip Skip} until the predicate returns false on a point on the reader.
	 *
	 * @param reader    to be skipped
	 * @param predicate to apply on the points
	 * @return the number of characters actually skipped
	 * @throws IOException if any I/O exception occurs
	 */
	public static long skip(Reader reader, Predicate<Integer> predicate) throws IOException {
		reader.mark(50);
		long skip = 0;
		while (predicate.test(reader.read()))
			skip++;
		reader.reset();
		return reader.skip(skip);
	}
}
