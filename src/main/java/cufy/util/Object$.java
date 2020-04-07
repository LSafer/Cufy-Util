/*
 *	Copyright 2020 Cufyorg
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package cufy.util;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Useful utils for {@link Object objects}.
 *
 * @author LSaferSE
 * @version 2 release (13-Jan-2020)
 * @since 07-Nov-2019
 */
final public class Object$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private Object$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Returns the first argument if it is non-null and otherwise returns the non-null second argument. Note: this is a copy/paste from {@link
	 * java.util.Objects#requireNonNullElseGet(Object, Supplier)}. For lower java-lang levels.
	 *
	 * @param obj        an object
	 * @param defaultObj a non-null object to return if the first argument is null
	 * @param <T>        the type of the reference
	 * @return the first argument if it is non-null and otherwise the second argument if it is non-null
	 * @throws NullPointerException if both obj is null and defaultObj is null
	 * @see java.util.Objects#requireNonNullElse(Object, Object)
	 */
	public static <T> T requireNonNullElse(T obj, T defaultObj) {
		return obj != null ? obj : Objects.requireNonNull(defaultObj, "defaultObj");
	}

	/**
	 * Returns the first argument if it is non-null and otherwise returns the non-null value of supplier.get(). Note: this is a copy/paste from {@link
	 * java.util.Objects#requireNonNullElse(Object, Object)} (Object, Object)}. For lower java-lang levels.
	 *
	 * @param obj      an object
	 * @param supplier of a non-null object to return if the first argument is null
	 * @param <T>      the type of the first argument and return type
	 * @return the first argument if it is non-null and otherwise the value from supplier.get() if it is non-null
	 * @throws NullPointerException if both obj is null and either the supplier is null or the supplier.get() value is null
	 * @see java.util.Objects#requireNonNullElseGet(Object, Supplier)
	 */
	public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
		return obj != null ? obj : Objects.requireNonNull(Objects.requireNonNull(supplier, "supplier").get(), "supplier.get()");
	}
}
