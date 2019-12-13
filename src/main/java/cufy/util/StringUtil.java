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

/**
 * Useful utils for strings.
 *
 * @author LSafer
 * @version 5 release (02-Nov-2019)
 * @since 11 Jun 2019
 */
final public class StringUtil {
	//TODO improve
	/**
	 * This is a util class. And shall not be instanced as an object.
	 */
	private StringUtil() {
		throw new AssertionError();
	}

	/**
	 * Check if the given string contains all of the given queries.
	 *
	 * @param string  to check
	 * @param queries to check with
	 * @return if given string contains all of the given query
	 */
	public static boolean all(String string, CharSequence... queries) {
		for (CharSequence q : queries)
			if (!string.contains(q))
				return false;

		return true;
	}

	/**
	 * Check if the given string contains any of the given queries.
	 *
	 * @param string  to check
	 * @param queries to check with
	 * @return if given string contains any of the given query
	 */
	public static boolean any(String string, CharSequence... queries) {
		for (CharSequence q : queries)
			if (string.contains(q))
				return true;

		return false;
	}

	/**
	 * Remove first/last characters with specific range.
	 * <br><br><b>example:</b>
	 * <pre>
	 * crop("example string", 2, 3) == "ample str"
	 * </pre>
	 *
	 * @param string String to crop
	 * @param start  range to remove
	 * @param end    range to remove
	 * @return cropped string
	 */
	public static String crop(String string, int start, int end) {
		return String.copyValueOf(string.toCharArray(), start, string.length() - start - end);
	}

	/**
	 * Joining the given strings accordingly with a specific query between them.
	 * <br><br><b>example</b>
	 * <pre>
	 * join("/", "abc", "def", "ghi") == "abc/def/ghi"
	 * </pre>
	 *
	 * @param joiner  query to add between strings
	 * @param string  to start with
	 * @param strings to add to the main string
	 * @return given strings joined accordingly with a specific query between them
	 */
	public static String join(String joiner, String string, String... strings) {
		StringBuilder builder = new StringBuilder(string);

		if (!string.equals("") && strings.length > 0)
			builder.append(strings[0]);

		for (int i = 1; i < strings.length; i++)
			builder.append(joiner).append(strings[i]);

		return builder.toString();
	}

	/**
	 * Format the given string to be used for logs. Replace annoying symbols with the symbol escaped.
	 * <pre>
	 *     example:
	 *     	string = "abc\ndef\tghi"
	 *     	output = "abc\\ndef\\tghi"
	 * </pre>
	 *
	 * @param string original string
	 * @return the given string formatted for logging
	 */
	public static String logging(Object string) {
		return String.valueOf(string)
				.replace("\"", "\\\"")
				.replace("\\", "\\\\")
				.replace("/", "\\/")
				.replace("\b", "\\\b")
				.replace("\f", "\\f")
				.replace("\n", "\\n")
				.replace("\r", "\\r")
				.replace("\t", "\\t");
	}

	/**
	 * Get given string repeated many times as given.
	 * <br><br><b>example</b>
	 * <pre>
	 * repetitive("abc", " ", 3) == "abc abc abc "
	 * </pre>
	 *
	 * @param string  to repeat from
	 * @param spacing to be in the middle of the repeated strings
	 * @param times   to repeat
	 * @return new string created from repeated given string
	 */
	public static String repetitive(String string, String spacing, int times) {
		StringBuilder builder = times < 1 ? new StringBuilder() : new StringBuilder(string);

		for (int i = 2; i <= times; i++)
			builder.append(spacing).append(string);

		return builder.toString();
	}

	/**
	 * From the given string. Replace all given queries with the given replacement.
	 *
	 * @param string      to replace from
	 * @param replacement string to replace with
	 * @param queries     to replace
	 * @return string with replaced queries from it
	 */
	public static String replace(String string, CharSequence replacement, CharSequence... queries) {
		for (CharSequence query : queries)
			string = string.replace(query, replacement);
		return string;
	}
}
