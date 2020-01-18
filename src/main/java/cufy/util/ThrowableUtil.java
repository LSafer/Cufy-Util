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
 * Useful utils for throwables.
 *
 * @author LSafer
 * @version 6 release (13-Jan-2020)
 * @since 13-Jan-2020
 */
public class ThrowableUtil {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private ThrowableUtil() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * A java syntax glitch to throw any throwable without the need to catch it.
	 *
	 * @param throwable to be ignite
	 * @param <T>       the type of the throwable to trick the compiler that it's the one thrown
	 * @throws T                    exactly the given throwable (unless if the given throwable is null. Then NullPointerException will be thrown)
	 * @throws NullPointerException if the given throwable is null
	 * @return nothing
	 */
	public static <T extends Throwable> T ignite(Throwable throwable) throws T {
		Objects.requireNonNull(throwable, "throwable");
		throw (T) throwable;
	}
}
