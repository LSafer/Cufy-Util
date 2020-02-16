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

import java.lang.reflect.Field;
import java.util.*;
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
	 * Get a map that whenever the method {@link Map#put(Object, Object)} is invoked to it. It will put the value to an existing PUBLIC NON-FINALE
	 * field with the name of the key's value (only if it is string). And whenever the method {@link Map#get(Object)} is invoked to it. It will get
	 * the value of an existing PUBLIC field.
	 *
	 * @param object     the instance
	 * @param restricted if it is allowed to throw exception
	 * @return a remote map to that instance
	 * @apiNote the returned map WILL contain ALL the accessible fields of the given instance! so be careful when using it!.
	 */
	public static Map<String, Object> remoteMap(Object object, boolean restricted) {
		Objects.requireNonNull(object, "object");
		return new AbstractMap<String, Object>() {
			/**
			 * The entry-set of this map.
			 */
			private Set<Map.Entry<String, Object>> entrySet;

			@Override
			public Object put(String key, Object value) {
				for (Entry<String, Object> entry : this.entrySet())
					if (entry.getKey().equals(key))
						return entry.setValue(value);

				if (restricted)
					throw new UnsupportedOperationException();

				return null;
			}
			@Override
			public Set<Entry<String, Object>> entrySet() {
				if (this.entrySet == null) {
					HashSet tempSet = new HashSet();
					for (Field field : Reflect$.getAllFields(object.getClass()))
						tempSet.add(new Entry<String, Object>() {
							@Override
							public String getKey() {
								return field.getName();
							}
							@Override
							public Object getValue() {
								try {
									field.setAccessible(true);
									return field.get(object);
								} catch (Throwable e) {
									if (restricted)
										throw new UnsupportedOperationException(e);
								}

								return null;
							}
							@Override
							public Object setValue(Object value) {
								try {
									Object old = this.getValue();
									field.set(object, value);
									return old;
								} catch (Throwable e) {
									if (restricted)
										throw new UnsupportedOperationException(e);
								}
								return null;
							}
						});
					this.entrySet = Collections.unmodifiableSet(tempSet);
				}

				return this.entrySet;
			}
		};
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
