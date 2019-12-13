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

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

/**
 * Utils for {@link Collection collections}.
 *
 * @author LSaferSE
 * @version 2 release (28-Sep-19)
 * @since 25-Sep-19
 */
final public class CollectionUtil {
	//TODO improve
	/**
	 * Util classes shouldn't be instanced.
	 */
	private CollectionUtil() {
		throw new AssertionError();
	}

	/**
	 * Fill the given {@link Collection}. Using the given supplier. Until it reaches the given size.
	 *
	 * @param collection to be filled
	 * @param size       limit to fill until
	 * @param supplier   to use for filling
	 * @param <E>        type of the list's elements
	 */
	public static <E> void fill(Collection<E> collection, int size, Function<Integer, E> supplier) {
		for (int i = collection.size(); i < size; i++)
			collection.add(supplier.apply(i));
	}

	/**
	 * @param object
	 * @return
	 */
	public static Collection<?> from(Object object) {
		if (object == null)
			return null;
		if (object instanceof Collection)
			return (Collection<?>) object;
		if (object.getClass().isArray())
			return Arrays.asList(ArrayUtil.objectify(object));

		throw new IllegalArgumentException("Nether collection nor array " + object.getClass());
	}
}
//	/**
//	 * @param map
//	 * @param function
//	 * @param <K>
//	 * @param <V>
//	 * @param <E>
//	 * @return
//	 */
//	@Deprecated
//	public static <K, V, E> ArrayList<E> collect(Map<K, V> map, BiFunction<K, V, E> function) {
//		ArrayList<E> list = new ArrayList<>();
//		map.forEach(((k, v) -> list.add(function.apply(k, v))));
//		return list;
//	}
//
//	/**
//	 * @param map
//	 * @param predicate
//	 * @param <K>
//	 * @param <V>
//	 * @return
//	 */
//	@Deprecated
//	public static <K, V> HashMap<K, V> filter(Map<K, V> map, BiPredicate<K, V> predicate) {
//		HashMap<K, V> collected = new HashMap<>();
//		map.forEach((k, v) -> {
//			if (predicate.test(k, v))
//				collected.put(k, v);
//		});
//		return collected;
//	}
//
//	/**
//	 * Get the element by index given on the given list. Or return the defaultValue param if the given index out of bounds.
//	 *
//	 * @param index        of the targeted element
//	 * @param defaultValue if the index out of the list bounds
//	 * @param list         to get the element from
//	 * @param <E>          type of the targeted element
//	 * @return the element on the given index on the given list. Or defaultValue if index out of bounds
//	 */
//	public static <E> E getOrCompute(List<E> list, int index, Supplier<E> defaultValue) {
//		return list.size() > index ? list.get(index) : defaultValue.get();
//	}
//
//	/**
//	 * Get the element by index given on the given list. Or return the defaultValue param if the given index out of bounds.
//	 *
//	 * @param index        of the targeted element
//	 * @param defaultValue if the index out of the list bounds
//	 * @param list         to get the element from
//	 * @param <E>          type of the targeted element
//	 * @return the element on the given index on the given list. Or defaultValue if index out of bounds
//	 */
//	public static <E> E getOrDefault(ArrayList<E> list, int index, E defaultValue) {
//		return list.size() > index ? list.get(index) : defaultValue;
//	}
