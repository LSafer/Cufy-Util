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

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Useful utils for {@link Object objects}.
 *
 * @author LSaferSE
 * @version 1
 * @since 07-Nov-2019
 */
final public class ObjectUtil {
	//TODO improve
	/**
	 * This is a util class. And shall not be instanced as an object.
	 */
	private ObjectUtil() {
		throw new AssertionError();
	}

	/**
	 * Apply the given function then return the results. If the given object is not equals to null. Else return null.
	 *
	 * @param object to check whether null or not
	 * @param action to be applied when the given object isn't null
	 * @param <T>    the type of the object
	 * @param <U>    the type if the returned value
	 * @return the returns from the applied function. Or null if the given object is null
	 */
	public static <T, U> U doIfNotNull(T object, Function<T, U> action) {
		return object == null ? null : action.apply(object);
	}

	/**
	 * Apply the given function then return the results. If the given object is not equals to null. Else return the defaultObj.
	 *
	 * @param object     to check whether null or not
	 * @param defaultObj to be returned when the given object is null
	 * @param action     to be applied when the given object isn't null
	 * @param <T>        the type of the object
	 * @param <U>        the type if the returned value
	 * @return the returns from the applied function. Or null if the given object is null
	 */
	public static <T, U> U doIfNotNullElse(T object, Function<T, U> action, U defaultObj) {
		return object == null ? defaultObj : action.apply(object);
	}

	/**
	 * Apply the given 'notNullAction' function if the given object not equals to null. Else apply the 'nullAction' function. Then return the results
	 * of the applied function.
	 *
	 * @param object        to check whether null or not
	 * @param notNullAction to be applied when the object isn't null
	 * @param nullAction    to be applied when the object is null
	 * @param <T>           type of the object
	 * @param <U>           type of the returned value
	 * @return the returns from the applied function
	 */
	public static <T, U> U doIfNotNullElseDo(T object, Function<T, U> notNullAction, Supplier<U> nullAction) {
		return object == null ? nullAction.get() : notNullAction.apply(object);
	}

	public static boolean equals(Object a, Object b) {
		//noinspection EqualsReplaceableByObjectsCall
		return a == b || a != null && a.equals(b);
	}

	public static boolean hashEquals(Object a, Object b) {
		//noinspection UnnecessaryParentheses
		return a == b || (a != null && a.equals(b) && a.hashCode() == b.hashCode());
	}

	/**
	 * Cast the given object using generic casting method. Useful when something can't be casted during to syntax errors. But it can be casted on
	 * runtime.
	 *
	 * @param object to be casted
	 * @param <T>    to cast the object to
	 * @return the object casted to the given generic type
	 * @apiNote this is just to exceed compiler check. It don't actually cast the object or produce any exception on it's own
	 */
	public static <T> T genericCast(Object object) {
		return (T) object;
	}

	public static <T> T requireNonNull(T obj) {
		if (obj == null) {
			throw new NullPointerException();
		} else {
			return obj;
		}
	}

	public static <T> T requireNonNull(T obj, String message) {
		if (obj == null) {
			throw new NullPointerException(message);
		} else {
			return obj;
		}
	}

	/**
	 * Returns the first argument if it is non-null and otherwise returns the non-null second argument. Note: this is a copy/paste from {@link
	 * java.util.Objects#requireNonNullElseGet(Object, Supplier)}!
	 *
	 * @param obj        an object
	 * @param defaultObj a non-null object to return if the first argument is null
	 * @param <T>        the type of the reference
	 * @return the first argument if it is non-null and otherwise the second argument if it is non-null
	 * @throws NullPointerException if both obj is null and defaultObj is null
	 * @see java.util.Objects#requireNonNullElse(Object, Object)
	 */
	public static <T> T requireNonNullElse(T obj, T defaultObj) {
		return obj != null ? obj : java.util.Objects.requireNonNull(defaultObj, "defaultObj");
	}

	/**
	 * Returns the first argument if it is non-null and otherwise returns the non-null value of supplier.get(). Note: this is a copy/paste from {@link
	 * java.util.Objects#requireNonNullElse(Object, Object)} (Object, Object)}!
	 *
	 * @param obj      an object
	 * @param supplier of a non-null object to return if the first argument is null
	 * @param <T>      the type of the first argument and return type
	 * @return the first argument if it is non-null and otherwise the value from supplier.get() if it is non-null
	 * @throws NullPointerException if both obj is null and either the supplier is null or the supplier.get() value is null
	 * @see java.util.Objects#requireNonNullElseGet(Object, Supplier)
	 */
	public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
		return obj != null ? obj : java.util.Objects.requireNonNull(java.util.Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
	}
}
