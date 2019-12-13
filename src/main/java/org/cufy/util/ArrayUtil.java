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

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.function.Function;

/**
 * Useful methods for Arrays.
 *
 * @author LSafer
 * @version 5 release (28-Sep-2019)
 * @since 11 Jun 2019
 */
@SuppressWarnings("OverloadedVarargsMethod")
final public class ArrayUtil {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 */
	private ArrayUtil() {

	}

	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return whether the given array contains any of the given elements or not
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 * @should match right
	 */
	@SuppressWarnings("OverloadedMethodsWithSameNumberOfParameters")
	public static boolean any(Object array, Object... elements) {
		return any(array, (Object) elements);
	}

	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return whether the given array contains any of the given elements or not
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' or 'elements' param is actually not an array
	 * @should match right
	 */
	@SuppressWarnings({"OverloadedMethodsWithSameNumberOfParameters", "OverlyComplexMethod"})
	public static boolean any(Object array, Object elements) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(elements, "elements");

		if (!array.getClass().isArray() || !elements.getClass().isArray())
			throw new IllegalArgumentException("not an array");

		int iln = Array.getLength(array),
				jln = Array.getLength(elements);
		Integer[] hash = new Integer[jln];

		for (int i = 0; i < iln; i++)
			for (int j = 0; j < jln; j++) {
				Object element = Array.get(elements, j),
						compete = Array.get(array, i);
				if (element == compete ||
					element != null && compete != null &&
					(hash[j] == null ? hash[j] = element.hashCode() : hash[j]) == compete.hashCode() &&
					element.equals(compete))
					return true;
			}
		return false;
	}

	/**
	 * Append the given elements to the end of the given array.
	 *
	 * @param array    to be appended
	 * @param elements to append
	 * @param <T>      type of elements
	 * @return a brand-new array with the given elements appended
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 * @should append successfully
	 */
	public static <T> T append(T array, Object... elements) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(elements, "elements");

		if (!array.getClass().isArray())
			throw new IllegalArgumentException("not an array");

		int length = Array.getLength(array);

		T res = (T) Array.newInstance(array.getClass().getComponentType(), length + elements.length);

		arraycopy(array, 0, res, 0, length);
		arraycopy(elements, 0, res, length, elements.length);
		return res;
	}

	/**
	 * Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array. A
	 * subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The number of
	 * components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are copied
	 * into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same array
	 * object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary array
	 * with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an ArrayStoreException is thrown and the destination is not
	 * modified:
	 * <ul>
	 *     <li>The src argument refers to an object that is not an array.</li>
	 *     <li>The dest argument refers to an object that is not an array.</li>
	 * </ul>
	 * Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 * Otherwise, if any actual component of the source array from position srcPos through srcPos+length-1 cannot be converted to the component type
	 * of the destination array by assignment conversion, an ArrayStoreException is thrown. In this case, let k be the smallest nonnegative integer
	 * less than length such that src[srcPos+k] cannot be converted to the component type of the destination array; when the exception is thrown,
	 * source array components from positions srcPos through srcPos+k-1 will already have been copied to destination array positions destPos through
	 * destPos+k-1 and no other positions of the destination array will have been modified. (Because of the restrictions already itemized, this
	 * paragraph effectively applies only to the situation where both arrays have component types that are reference types.)
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @param <T>     the type of the arrays given
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 * @apiNote the different between this method and {@link System#arraycopy(Object, int, Object, int, int)} is how it deals with primitive array. As
	 * this method don't mind if ether the src or dest have primitive or objective types. It copies anyway.
	 * @should copy successfully
	 * @see System#arraycopy(Object, int, Object, int, int)
	 */
	public static <T> void arraycopy(T src, int srcPos, T dest, int destPos, int length) {
		Objects.requireNonNull(src, "src");
		Objects.requireNonNull(dest, "dest");

		if (!src.getClass().isArray() || !dest.getClass().isArray())
			throw new ArrayStoreException();

		long srcLength, destLength;

		if (length < 0 || (srcLength = Array.getLength(src)) < 0 || (destLength = Array.getLength(dest)) < 0)
			throw new IndexOutOfBoundsException();

		if (srcPos + length > srcLength || destPos + length > destLength)
			throw new IndexOutOfBoundsException();

		for (long l = 0; l < length; l++)
			try {
				Array.set(dest, destPos++, Array.get(src, srcPos++));
			} catch (IllegalArgumentException e) {
				throw new ArrayStoreException(e.getMessage());
			}
	}

	/**
	 * Get the index of the given element inside the given {@link Object array}.
	 *
	 * @param array   to get index from
	 * @param element to get the index of
	 * @param <E>     type of elements
	 * @return the index of the given element inside the given array
	 */
	@SafeVarargs
	public static <E> int indexOf(E element, E... array) {
		for (int i = 0; i < array.length; i++)
			if (array[i] != null)
				if (array[i].equals(element))
					return i;
		return -1;
	}

	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param reversedIndex the index of the element from the end of the array
	 * @param array         to get the element from
	 * @param <E>           the type of the element
	 * @return the element of the given reversed index in the given array
	 */
	@SafeVarargs
	public static <E> E last(int reversedIndex, E... array) {
		return array[array.length - 1 - reversedIndex];
	}

	/**
	 * Get the last element in the given array.
	 *
	 * @param array to get the element from
	 * @param <E>   the type of the element
	 * @return last element on the given array
	 */
	@SafeVarargs
	public static <E> E last(E... array) {
		return last(0, array);
	}

	/**
	 * Fix the given array to have all {@link Object} elements deep inside it.
	 *
	 * @param array to be fixed
	 * @param <T>   type of the elements inside the fixed array
	 * @return fixed array from the given array, or the given array if it's already fixed
	 */
	public static <T> T[] objectify(Object array) {
		Class<?> type = array.getClass().getComponentType();

		for (Class<?> c = type; c != null; c = c.getComponentType())
			if (!c.isArray() && !c.isPrimitive())
				return (T[]) array;

		int length = Array.getLength(array);
		T[] array1 = (T[]) Array.newInstance(ReflectUtil.objectiveClass(type), length);
		ArrayUtil.arraycopy(array, 0, array1, 0, length);
		return array1;
	}

	/**
	 * Remove passed objects from passed array.
	 *
	 * @param array    to remove from
	 * @param elements to remove
	 * @param <T>      type of elements
	 * @return passed array excluded from passed elements
	 */
	@SafeVarargs
	public static <T> T[] remove(T[] array, T... elements) {
		T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - elements.length);
		int i = 0;

		for (T element : array)
			if (!ArrayUtil.any(elements, element)) {
				res[i] = element;
				i++;
			}

		return res;
	}

	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array  to crop
	 * @param start  range to remove
	 * @param length range to remove
	 * @param <T>    type of elements
	 * @return cropped edge version of the given array
	 */
	public static <T> T[] sublist(T[] array, int start, int length) {
		Objects.requireNonNull(array, "array");
		if (array.length < start)
			throw new IndexOutOfBoundsException();
		if (array.length - start < length)
			throw new IndexOutOfBoundsException();

		T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(), length);

		if (start == array.length)

			if (array.length - length - start >= 0)
				System.arraycopy(array, start, res, 0, array.length - length - start);

		return res;
	}

	/**
	 * Get the total sum of the given array. By applying the given function foreach element on the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    the array to sum it's elements
	 * @param function the function to get the value of each element
	 * @param <T>      the component type of the given array
	 * @return the total sum of the given array
	 */
	public static <T> long sum(T[] array, Function<T, Number> function) {
		long sum = 0;
		for (T element : array)
			sum += (long) function.apply(element);
		return sum;
	}
}
//
//	/**
//	 * Check whether the given array contains all the given elements or not.
//	 *
//	 * @param array    to check
//	 * @param elements to check for
//	 * @param <E>      type of elements
//	 * @return whether the given array contains all of the given elements or not
//	 * @throws NullPointerException if ether 'array' or 'elements' is null
//	 * @should return if the arrays are equals
//	 */
//	@SafeVarargs
//	public static <E> boolean equals(E[] array, E... elements) {
//		Objects.requireNonNull(array, "array");
//		Objects.requireNonNull(elements, "elements");
//
//		elements:
//		for (E element : elements)
//			for (E element1 : array) {
//				if (Objects.equals(element, element1))
//					continue elements;
//				return false;
//			}
//		return true;
//	}
//	/**
//	 * Get the element by index given on the given array. Or return the defaultValue param if the given index out of bounds.
//	 *
//	 * @param index        of the targeted element
//	 * @param defaultValue if the index out of the arrays bounds
//	 * @param array        to get the element from
//	 * @param <T>          type of the targeted element
//	 * @return the element on the given index on the given array. Or defaultValue if index out of bounds
//	 */
//	@SafeVarargs
//	public static <T> T getOrCompute(int index, Supplier<T> defaultValue, T... array) {
//		return array.length > index ? array[index] : defaultValue.get();
//	}
//	/**
//	 * Get the element by index given on the given array. Or return the defaultValue param if the given index out of bounds.
//	 *
//	 * @param index        of the targeted element
//	 * @param defaultValue if the index out of the arrays bounds
//	 * @param array        to get the element from
//	 * @param <T>          type of the targeted element
//	 * @return the element on the given index on the given array. Or defaultValue if index out of bounds
//	 */
//	@SafeVarargs
//	public static <T> T getOrDefault(int index, T defaultValue, T... array) {
//		return array.length > index ? array[index] : defaultValue;
//	}
