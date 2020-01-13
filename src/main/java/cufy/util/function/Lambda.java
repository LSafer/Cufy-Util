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
package cufy.util.function;

/**
 * A collection of common lambdas.
 *
 * @author LSaferSE
 * @version 2 release (13-Jan-2020)
 * @since 31-Dec-2019
 */
final public class Lambda {
	/**
	 * This is a util class and shouldn't be instanced.
	 *
	 * @throws AssertionError when called
	 */
	private Lambda() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Return the given param.
	 *
	 * Useful to be used as:- <br/>
	 * <pre>
	 *     do({@link Lambda}::{@link #it});
	 * </pre>
	 *
	 * @param t   to be returned
	 * @param <T> the type of the given param
	 * @return the given param
	 */
	public static <T> T it(T t) {
		return t;
	}
	/**
	 * Return the first param.
	 *
	 * @param t   to be returned
	 * @param o   ignored
	 * @param <T> the type of the returned value
	 * @return the first parameter
	 */
	public static <T> T it0(T t, Object o) {
		return t;
	}
	/**
	 * Return the first param.
	 *
	 * @param o   to be returned
	 * @param t   ignored
	 * @param <T> the type of the returned value
	 * @return the first parameter
	 */
	public static <T> T it1(Object o, T t) {
		return t;
	}
}
