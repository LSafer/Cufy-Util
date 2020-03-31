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

import java.util.Objects;

/**
 * Useful utils for strings.
 *
 * @author LSafer
 * @version 6 release (13-Jan-2020)
 * @since 11 Jun 2019
 */
final public class String$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private String$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Return the first missing query in the given string.
	 *
	 * @param string  to check
	 * @param queries to check for
	 * @return the first missing query on the given string. Or null if no query missing
	 * @throws NullPointerException if the given string or any of the given queries is null. Or the queries array itself is null
	 */
	public static CharSequence all(String string, CharSequence... queries) {
		Objects.requireNonNull(string, "string");
		Objects.requireNonNull(queries, "queries");

		for (CharSequence query : queries) {
			Objects.requireNonNull(query, "query");

			if (!string.contains(query))
				return query;
		}

		return null;
	}

	/**
	 * Return the first query found on the given string. Or null if no query found.
	 *
	 * @param string  to check
	 * @param queries to check for
	 * @return the first found query on the given string. or null if no query found
	 * @throws NullPointerException if the given string or any of the given queries is null. Or the queries array itself is null
	 */
	public static CharSequence any(String string, CharSequence... queries) {
		Objects.requireNonNull(string, "string");
		Objects.requireNonNull(queries, "queries");

		for (CharSequence query : queries) {
			Objects.requireNonNull(query, "query");

			if (string.contains(query))
				return query;
		}

		return null;
	}

	/**
	 * Format the given string to be used for logs. Replace annoying symbols with the symbol escaped.
	 * <pre>
	 *     example:
	 *     	string = "abc\n def\t ghi"
	 *     	output = "abc\\n def\\t ghi"
	 * </pre>
	 *
	 * @param string original string
	 * @return the given string formatted for logging
	 * @throws NullPointerException if the given string is null
	 */
	public static String logging(Object string) {
		Objects.requireNonNull(string, "string");
		return String.valueOf(string)
				.replace("\b", "\\b")
				.replace("\n", "\\n")
				.replace("\r", "\\r")
				.replace("\t", "\\t");
	}

	/**
	 * Get given string repeated many times as given.
	 * <br><br><b>example</b>
	 * <pre>
	 * repeat("abc", " ", 3) == "abc abc abc"
	 * </pre>
	 *
	 * @param string    to repeat from
	 * @param delimiter to be in the middle of the repeated strings
	 * @param times     to repeat
	 * @return new string created from repeated given string
	 * @throws NullPointerException     if the given string or delimiter is null
	 * @throws IllegalArgumentException if the given 'times' is negative
	 */
	public static String repeat(String string, String delimiter, int times) {
		Objects.requireNonNull(string, "string");
		Objects.requireNonNull(delimiter, "delimiter");
		if (times < 0)
			throw new IllegalArgumentException("times is negative");

		if (times == 0)
			return "";

		final int sl = string.length();
		final int dl = delimiter.length();
		final int length = (sl + dl) * times - dl;
		final int lm = length - 1;

		char[] chars = new char[length];
		for (int i = 0; i < length; ) {
			string.getChars(0, sl, chars, i);
			i += sl;

			if (i < lm) {
				delimiter.getChars(0, dl, chars, i);
				i += dl;
			}
		}

		return new String(chars);
	}

	/**
	 * Get given string repeated many times as given.
	 * <br><br><b>example</b>
	 * <pre>
	 * repeat("abc_", 3) == "abc_abc_abc_"
	 * </pre>
	 *
	 * @param string to repeat from
	 * @param times  to repeat
	 * @return new string created from repeated given string
	 * @throws NullPointerException     if the given string or delimiter is null
	 * @throws IllegalArgumentException if the given 'times' is negative
	 */
	public static String repeat(String string, int times) {
		Objects.requireNonNull(string, "string");
		if (times < 0)
			throw new IllegalArgumentException("times is negative");

		if (times == 0)
			return "";

		final int sl = string.length();
		final int length = sl * times;

		char[] chars = new char[length];
		for (int i = 0; i < length; i += sl)
			string.getChars(0, sl, chars, i);

		return new String(chars);
	}
}
