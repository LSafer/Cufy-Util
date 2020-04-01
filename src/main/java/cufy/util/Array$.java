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

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Useful methods for Arrays.
 *
 * @author LSafer
 * @version 7 release (13-Jan-2020)
 * @since 11 Jun 2019
 */
final public class Array$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private Array$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @param <T>      the type of the elements of the given array
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static <T> int all(T[] array, T... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(boolean[] array, boolean... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(byte[] array, byte... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(char[] array, char... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(double[] array, double... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(float[] array, float... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(int[] array, int... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(long[] array, long... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all(short[] array, short... elements) {
		return all0(array, elements);
	}
	/**
	 * Check whether the given array contains all of the given elements.
	 *
	 * @param array    the array to be checked
	 * @param elements to check for
	 * @return the index of the elements missing on the given array, Or -1 if no element missing
	 * @throws NullPointerException     if ether the given 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' aren't an array
	 */
	public static int all0(Object array, Object elements) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(elements, "elements");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");
		if (!elements.getClass().isArray())
			throw new IllegalArgumentException(elements + " isn't an array");

		int el = Array.getLength(elements);
		int al = Array.getLength(array);
		for0:
		for (int ei = 0; ei < el; ei++) {
			Object eo = Array.get(elements, ei);

			for (int ai = 0; ai < al; ai++) {
				Object ao = Array.get(array, ai);

				if (Objects.equals(eo, ao))
					continue for0;
			}

			return ei;
		}

		return -1;
	}

	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @param <T>      the type of elements to look for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static <T> int any(T[] array, T... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(boolean[] array, boolean... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(byte[] array, byte... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(char[] array, char... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(double[] array, double... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(float[] array, float... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(int[] array, int... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(long[] array, long... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if the given 'array' param is actually not an array
	 */
	public static int any(short[] array, short... elements) {
		return any0(array, elements);
	}
	/**
	 * Check whether the given array contains any of the given elements or not.
	 *
	 * @param array    to check
	 * @param elements to check for
	 * @return the index of the first element found on the given array, Or -1 if no element found
	 * @throws NullPointerException     if ether 'array' or 'elements' are null
	 * @throws IllegalArgumentException if ether the given 'array' or 'elements' param is actually not an array
	 */
	public static int any0(Object array, Object elements) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(elements, "elements");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");
		if (!elements.getClass().isArray())
			throw new IllegalArgumentException(elements + " isn't an array");

		int al = Array.getLength(array);
		int el = Array.getLength(elements);
		for (int ai = 0; ai < al; ai++) {
			Object ao = Array.get(array, ai);

			for (int ei = 0; ei < el; ei++) {
				Object eo = Array.get(elements, ei);

				if (Objects.equals(eo, ao))
					return ai;
			}
		}

		return -1;
	}

	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @param <T>   the type of the elements from the given array
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static <T> List<T> asList(T... array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Boolean> asList(boolean[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Byte> asList(byte[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Character> asList(char[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Double> asList(double[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Float> asList(float[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Integer> asList(int[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Long> asList(long[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List<Short> asList(short[] array) {
		return asList0(array);
	}
	/**
	 * Construct a new list and add all the given elements from the given 'array' object.
	 *
	 * @param array to construct the list with
	 * @return a list containing all the given elements from the given array object
	 * @throws NullPointerException     if the given 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static List asList0(Object array) {
		Objects.requireNonNull(array, "array");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		return new AbstractList() {
			/**
			 * The array that we are wrapping.
			 */
			final private Object a = array;
			/**
			 * The length of the array that we are wrapping.
			 */
			final private int size = Array.getLength(array);

			@Override
			public void forEach(Consumer action) {
				Objects.requireNonNull(action, "action");
				for (int i = 0; i < this.size; i++)
					action.accept(Array.get(this.a, i));
			}

			@Override
			public Object get(int index) {
				return Array.get(this.a, index);
			}

			@Override
			public Object set(int index, Object element) {
				Object old = Array.get(this.a, index);
				Array.set(this.a, index, element);
				return old;
			}

			@Override
			public int indexOf(Object o) {
				return indexOf0(this.a, new Object[]{o});
			}

			@Override
			public Iterator iterator() {
				return iterator0(this.a);
			}

			@Override
			public void replaceAll(UnaryOperator operator) {
				Objects.requireNonNull(operator, "operator");

				for (int i = 0; i < this.size; i++)
					Array.set(this.a, i, operator.apply(Array.get(this.a, i)));
			}

			@Override
			public int size() {
				return this.size;
			}

			@Override
			public boolean contains(Object o) {
				return any0(this.a, new Object[]{o}) != -1;
			}

			@Override
			public Object[] toArray() {
				return (Object[]) Array$.copyOf0(this.a, this.size, Object[].class);
			}

			@Override
			public Object[] toArray(Object[] a) {
				Objects.requireNonNull(a, "a");
				final int length = a.length;

				if (length < this.size) {
					return (Object[]) Array$.copyOf0(this.a, this.size, a.getClass());
				} else {
					if (a.getClass().isAssignableFrom(this.a.getClass()))
						System.arraycopy(this.a, 0, a, 0, this.size);
					else hardcopy0(this.a, 0, a, 0, this.size);

					if (length > this.size) {
						a[this.size] = null;
					}

					return a;
				}
			}
		};
	}

	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @param klass  the type of the new array
	 * @param <T>    the type of the elements of the given array
	 * @param <U>    the type of the elements in the returned array
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static <T extends U, U> U[] copyOf(T[] array, int length, Class<U[]> klass) {
		return (U[]) copyOf0(array, length, klass);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static boolean[] copyOf(boolean[] array, int length) {
		return (boolean[]) copyOf0(array, length, boolean[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static byte[] copyOf(byte[] array, int length) {
		return (byte[]) copyOf0(array, length, byte[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static char[] copyOf(char[] array, int length) {
		return (char[]) copyOf0(array, length, char[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static double[] copyOf(double[] array, int length) {
		return (double[]) copyOf0(array, length, double[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static float[] copyOf(float[] array, int length) {
		return (float[]) copyOf0(array, length, float[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static int[] copyOf(int[] array, int length) {
		return (int[]) copyOf0(array, length, int[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static long[] copyOf(long[] array, int length) {
		return (long[]) copyOf0(array, length, long[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static short[] copyOf(short[] array, int length) {
		return (short[]) copyOf0(array, length, short[].class);
	}
	/**
	 * Get a copy of the given array. Copy to a new array from the given class.
	 *
	 * @param array  the array to be copied
	 * @param length the length of the new
	 * @param klass  the type of the new array
	 * @return a copy of the given array with the type of the given class
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't an array. Or the given class isn't an array class. Or the given length is negative
	 */
	public static Object copyOf0(Object array, int length, Class<?> klass) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(klass, "klass");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");
		if (!klass.isArray())
			throw new IllegalArgumentException(klass + " isn't a class for an array");
		if (length < 0)
			throw new NegativeArraySizeException("negative length provided (" + length + ")");

		Object copy = Array.newInstance(klass.getComponentType(), length);
		if (klass.isAssignableFrom(array.getClass()))
			System.arraycopy(array, 0, copy, 0, Math.min(Array.getLength(array), length));
		else hardcopy0(array, 0, copy, 0, Math.min(Array.getLength(array), length));

		return copy;
	}

	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @param <T>     the type of the first array
	 * @param <U>     the type of the second array
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static <T extends U, U> void hardcopy(T[] src, int srcPos, U[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(boolean[] src, int srcPos, boolean[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(byte[] src, int srcPos, byte[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(char[] src, int srcPos, char[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(double[] src, int srcPos, double[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(float[] src, int srcPos, float[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(long[] src, int srcPos, long[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
	 * destination array. If dest is null, then a NullPointerException is thrown. If src is null, then a NullPointerException is thrown and the
	 * destination array is not modified. Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is
	 * not modified:
	 * <ul>
	 *     <li>The srcPos argument is negative.</li>
	 *     <li>The destPos argument is negative.</li>
	 *     <li>The length argument is negative.</li>
	 *     <li>srcPos+length is greater than src.length, the length of the source array.</li>
	 *     <li>destPos+length is greater than dest.length, the length of the destination array.</li>
	 * </ul>
	 *
	 * @param src     the source array.
	 * @param srcPos  starting position in the source array.
	 * @param dest    the destination array.
	 * @param destPos starting position in the destination data.
	 * @param length  the number of array elements to be copied.
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 */
	public static void hardcopy(short[] src, int srcPos, short[] dest, int destPos, int length) {
		hardcopy0(src, srcPos, dest, destPos, length);
	}
	/**
	 * Copies elements on an array from the specified source array, beginning at the specified position, to the specified position of the destination
	 * array. A subsequence of array components are copied from the source array referenced by src to the destination array referenced by dest. The
	 * number of components copied is equal to the length argument. The components at positions srcPos through srcPos+length-1 in the source array are
	 * copied into positions destPos through destPos+length-1, respectively, of the destination array.If the src and dest arguments refer to the same
	 * array object, then the copying is performed as if the components at positions srcPos through srcPos+length-1 were first copied to a temporary
	 * array with length components and then the contents of the temporary array were copied into positions destPos through destPos+length-1 of the
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
	 * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds.
	 * @throws ArrayStoreException       if an element in the src array could not be stored into the dest array because of a type mismatch.
	 * @throws NullPointerException      if either src or dest is null.
	 * @apiNote the different between this method and {@link System#arraycopy(Object, int, Object, int, int)} is how it deals with primitive array. As
	 * this method don't mind if ether the src or dest have primitive or objective types. It copies anyway.
	 * @see System#arraycopy(Object, int, Object, int, int)
	 */
	public static void hardcopy0(Object src, int srcPos, Object dest, int destPos, int length) {
		Objects.requireNonNull(src, "src");
		Objects.requireNonNull(dest, "dest");

		//actually no need for this method
		if (src == dest || dest.getClass().isAssignableFrom(src.getClass())) {
			System.arraycopy(src, srcPos, dest, destPos, length);
			return;
		}

		if (!src.getClass().isArray())
			throw new ArrayStoreException("src is not an array");
		if (!dest.getClass().isArray())
			throw new ArrayStoreException("dest is not an array");

		int srcLength = Array.getLength(src);
		int destLength = Array.getLength(dest);

		if (length < 0)
			throw new IndexOutOfBoundsException("length is negative");
		if (srcLength < 0)
			throw new IndexOutOfBoundsException("srcLength is negative");
		if (destLength < 0)
			throw new IndexOutOfBoundsException("destLength is negative");
		if (srcPos + length > srcLength)
			throw new IndexOutOfBoundsException("srcPos+length is greater than src.length");
		if (destPos + length > destLength)
			throw new IndexOutOfBoundsException("destPos+length is greater than dest.length");

		Class<?> type = dest.getClass().getComponentType();
		for (int i = 0; i < length; i++)
			try {
				Array.set(dest, destPos++, Reflect$.primitiveCast(type, Array.get(src, srcPos++)));
			} catch (IllegalArgumentException e) {
				throw (ArrayStoreException) new ArrayStoreException(e.getMessage()).initCause(e);
			}
	}

	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @param <T>      the type of elements inside the given array
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static <T> int indexOf(T[] array, T... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(boolean[] array, boolean... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(byte[] array, byte... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(char[] array, char... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(double[] array, double... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(float[] array, float... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(int[] array, int... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(long[] array, long... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException if the given 'array' or 'elements' parameter is null
	 */
	public static int indexOf(short[] array, short... elements) {
		return indexOf0(array, elements);
	}
	/**
	 * Get the index of any of the given elements inside the given array. This will return the first index that equals any fo the given elements.
	 *
	 * @param elements any to find the index of
	 * @param array    that carries any of the given elements
	 * @return the index where any of the given elements is stored at on the given array. Or -1 if the array don't have any of the given elements.
	 * @throws NullPointerException     if the given 'array' or 'elements' parameter is null
	 * @throws IllegalArgumentException if the given 'array' or 'elements' parameter is actually not an array
	 */
	public static int indexOf0(Object array, Object elements) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(elements, "elements");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");
		if (!elements.getClass().isArray())
			throw new IllegalArgumentException(elements + " isn't an array");

		final int l = Array.getLength(array);
		final int m = Array.getLength(elements);
		if (m > 0 && l > 0)
			for (int li = 0; li < l; li++) {
				Object lie = Array.get(array, li);

				for (int mi = 0; mi < m; mi++) {
					Object mie = Array.get(elements, mi);

					if (Objects.equals(lie, mie))
						return li;
				}
			}

		return -1;
	}

	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @param <T>   the type of elements on the returned iterator
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static <T> Iterator<T> iterator(T... array) {
		return (Iterator<T>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Boolean> iterator(boolean[] array) {
		return (Iterator<Boolean>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Byte> iterator(byte[] array) {
		return (Iterator<Byte>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Character> iterator(char[] array) {
		return (Iterator<Character>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Double> iterator(double[] array) {
		return (Iterator<Double>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Float> iterator(float[] array) {
		return (Iterator<Float>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Integer> iterator(int[] array) {
		return (Iterator<Integer>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Long> iterator(long[] array) {
		return (Iterator<Long>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException if the given array is null (the array itself)
	 */
	public static Iterator<Short> iterator(short[] array) {
		return (Iterator<Short>) iterator0(array);
	}
	/**
	 * Get an {@link Iterator} for the given array.
	 *
	 * @param array the array to get an iterator for
	 * @return an iterator for the given array
	 * @throws NullPointerException     if the given array is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static Iterator<?> iterator0(Object array) {
		Objects.requireNonNull(array, "array");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		int length = Array.getLength(array);
		return new Iterator() {
			/**
			 * Where the iterator is currently on the array.
			 */
			private int cursor = 0;

			@Override
			public boolean hasNext() {
				return this.cursor < length;
			}

			@Override
			public Object next() {
				return Array.get(array, this.cursor++);
			}
		};
	}

	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @param <T>   the type of the element
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static <T> T last(T[] array, int index) {
		return (T) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Boolean last(boolean[] array, int index) {
		return (Boolean) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Byte last(byte[] array, int index) {
		return (Byte) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Character last(char[] array, int index) {
		return (Character) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Double last(double[] array, int index) {
		return (Double) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Float last(float[] array, int index) {
		return (Float) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Integer last(int[] array, int index) {
		return (Integer) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Long last(long[] array, int index) {
		return (Long) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null (the array itself)
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Short last(short[] array, int index) {
		return (Short) last0(array, index);
	}
	/**
	 * Get an element by the given index discording from the end of the array.
	 *
	 * @param index the index of the element from the end of the array
	 * @param array to get the element from
	 * @return the element of the given reversed index in the given array
	 * @throws NullPointerException      if the given array is null
	 * @throws IllegalArgumentException  if the given array isn't actually an array
	 * @throws IndexOutOfBoundsException if ether the given index is negative. Or if index is greater-than or equals-to array.length
	 */
	public static Object last0(Object array, int index) {
		Objects.requireNonNull(array, "array");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array!");

		int length = Array.getLength(array);

		if (index < 0)
			throw new IndexOutOfBoundsException("index is negative, index=" + index);
		if (index >= length)
			throw new IndexOutOfBoundsException("index is greater than the array size, index=" + index + " array.length=" + length);

		return Array.get(array, length - 1 - index);
	}

	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @param <T>        the type of the elements on the given array
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static <T> int max(T[] array, Comparator<T> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(boolean[] array, Comparator<Boolean> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(byte[] array, Comparator<Byte> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(char[] array, Comparator<Character> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(double[] array, Comparator<Double> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(float[] array, Comparator<Float> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(int[] array, Comparator<Integer> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(long[] array, Comparator<Long> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max(short[] array, Comparator<Short> comparator) {
		return max0(array, comparator);
	}
	/**
	 * Get the greater element in the given array. Depending on the given comparator.
	 *
	 * @param array      the array to get the greatest element of
	 * @param comparator to be used to compare elements to get the greatest element
	 * @return the index of the greatest element on the given array, Or -1 if the array is empty
	 * @throws NullPointerException     if ether the given 'comparator' or 'array' is null
	 * @throws IllegalArgumentException if the given 'array' isn't actually an array
	 */
	public static int max0(Object array, Comparator<?> comparator) {
		Objects.requireNonNull(comparator, "comparator");
		Objects.requireNonNull(array, "array");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		int length = Array.getLength(array);

		if (length == 0)
			return -1;

		Object max = Array.get(array, 0);
		int index = 0;
		for (int i = 1; i < length; i++) {
			Object element = Array.get(array, i);

			if (((Comparator<Object>) comparator).compare(element, max) < 0) {
				max = element;
				index = i;
			}
		}

		return index;
	}

	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param klass  the type of the new array
	 * @param arrays the arrays to be merged
	 * @param <T>    the type of the given arrays
	 * @param <U>    the type of the returned array
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static <T extends U, U> U[] merge(Class<U[]> klass, T[]... arrays) {
		return (T[]) merge0(klass, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static boolean[] merge(boolean[]... arrays) {
		return (boolean[]) merge0(boolean[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static byte[] merge(byte[]... arrays) {
		return (byte[]) merge0(byte[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static char[] merge(char[]... arrays) {
		return (char[]) merge0(char[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static double[] merge(double[]... arrays) {
		return (double[]) merge0(double[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static float[] merge(float[]... arrays) {
		return (float[]) merge0(float[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static int[] merge(int[]... arrays) {
		return (int[]) merge0(int[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static long[] merge(long[]... arrays) {
		return (long[]) merge0(long[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static short[] merge(short[]... arrays) {
		return (short[]) merge0(short[].class, arrays);
	}
	/**
	 * Merge the given arrays in a new array. The new array will contain the content of the given arrays merged in order.
	 *
	 * @param klass  the type of the new array
	 * @param arrays the arrays to be merged
	 * @return an array that includes all the elements of the given arrays ordered with the order of the arrays given.
	 * @throws IllegalArgumentException if any of the given arrays is not actually an array. Or if the given class isn't an array class
	 * @throws NullPointerException     if 'arrays' param is null. Or if any of the given arrays are null. Or if the given klass is null
	 * @throws ArrayStoreException      if any element from the given arrays can't be stored at the product array
	 */
	public static Object merge0(Class<?> klass, Object[] arrays) {
		Objects.requireNonNull(arrays, "arrays");
		Objects.requireNonNull(klass, "klass");
		if (!klass.isArray())
			throw new IllegalArgumentException(klass + " isn't an array class");

		Object product;
		{
			int length = 0;
			for (Object array : arrays) {
				Objects.requireNonNull(array, "array");
				if (!array.getClass().isArray())
					throw new IllegalArgumentException(array + " isn't an array");
				length += Array.getLength(array);
			}
			product = Array.newInstance(klass.getComponentType(), length);
		}

		int cursor = 0;
		for (Object array : arrays) {
			int length = Array.getLength(array);

			//if the types don't match. Then System.arraycopy() will not work
			if (klass.isAssignableFrom(array.getClass()))
				System.arraycopy(array, 0, product, cursor, length);
			else hardcopy0(array, 0, product, cursor, length);

			cursor += length;
		}

		return product;
	}

	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @param <T>      the type of element on the given array
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static <T> void replace(T[] array, UnaryOperator<T> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(boolean[] array, UnaryOperator<Boolean> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(byte[] array, UnaryOperator<Byte> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(char[] array, UnaryOperator<Character> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(double[] array, UnaryOperator<Double> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(float[] array, UnaryOperator<Float> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(int[] array, UnaryOperator<Integer> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(long[] array, UnaryOperator<Long> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace(short[] array, UnaryOperator<Short> operator) {
		replace0(array, operator);
	}
	/**
	 * Replace every element on the given array using the given operator.
	 *
	 * @param array    the array to replace at
	 * @param operator to be used to replace
	 * @throws NullPointerException     if the given array is null, Or if the given operator is null
	 * @throws IllegalArgumentException if the given array isn't actually an array
	 */
	public static void replace0(Object array, UnaryOperator<?> operator) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(operator, "operator");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + "isn't an array");

		int length = Array.getLength(array);
		for (int i = 0; i < length; i++)
			Array.set(array, i, ((UnaryOperator<Object>) operator).apply(Array.get(array, i)));
	}

	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @param <T>       the type of element on the given array
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static <T> int replaceIf(T[] array, Predicate<T> predicate, UnaryOperator<T> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(boolean[] array, Predicate<Boolean> predicate, UnaryOperator<Boolean> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(byte[] array, Predicate<Byte> predicate, UnaryOperator<Byte> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(char[] array, Predicate<Character> predicate, UnaryOperator<Character> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(double[] array, Predicate<Double> predicate, UnaryOperator<Double> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(float[] array, Predicate<Float> predicate, UnaryOperator<Float> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(int[] array, Predicate<Integer> predicate, UnaryOperator<Integer> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(long[] array, Predicate<Long> predicate, UnaryOperator<Long> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf(short[] array, Predicate<Short> predicate, UnaryOperator<Short> operator) {
		return replaceIf0(array, predicate, operator);
	}
	/**
	 * Replace every element on the given array if that element matches the given predicate conditions. Using the given operator.
	 *
	 * @param array     the array to replace elements on
	 * @param predicate to check the element that to be replaced
	 * @param operator  the operator to get the replacement from
	 * @return the number of replacements that have been applied
	 * @throws NullPointerException     if any of the given parameters are null
	 * @throws IllegalArgumentException if the given array isn't an array
	 */
	public static int replaceIf0(Object array, Predicate<?> predicate, UnaryOperator<?> operator) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(predicate, "predicate");
		Objects.requireNonNull(operator, "operator");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		int length = Array.getLength(array);
		int r = 0;
		for (int i = 0; i < length; i++) {
			Object object = Array.get(array, i);

			if (((Predicate<Object>) predicate).test(object)) {
				Array.set(array, i, ((UnaryOperator<Object>) operator).apply(object));
				r++;
			}
		}

		return r;
	}

	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @param <T>        the type of the elements on the given array
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static <T> T[] subarray(T[] array, int beginIndex, int endIndex) {
		return (T[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static boolean[] subarray(boolean[] array, int beginIndex, int endIndex) {
		return (boolean[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static byte[] subarray(byte[] array, int beginIndex, int endIndex) {
		return (byte[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static char[] subarray(char[] array, int beginIndex, int endIndex) {
		return (char[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static double[] subarray(double[] array, int beginIndex, int endIndex) {
		return (double[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static float[] subarray(float[] array, int beginIndex, int endIndex) {
		return (float[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static int[] subarray(int[] array, int beginIndex, int endIndex) {
		return (int[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static long[] subarray(long[] array, int beginIndex, int endIndex) {
		return (long[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static short[] subarray(short[] array, int beginIndex, int endIndex) {
		return (short[]) subarray0(array, beginIndex, endIndex);
	}
	/**
	 * Remove the last and the first elements of the given {@link Object array}. Depending on the given values.
	 *
	 * @param array      to get a subarray of
	 * @param beginIndex the index to begin
	 * @param endIndex   the index to stop
	 * @return a subarray of the given array
	 * @throws NullPointerException      if the given 'array' is null
	 * @throws IllegalArgumentException  if the given 'array' isn't actually an array
	 * @throws IndexOutOfBoundsException if ether the beginIndex or the endIndex is negative. Or if the endIndex is less than beginIndex. Or if ether
	 *                                   the beginIndex or the endIndex is greater than array.length.
	 * @see String#substring
	 */
	public static Object subarray0(Object array, int beginIndex, int endIndex) {
		Objects.requireNonNull(array, "array");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		int length = Array.getLength(array);
		int subLen = endIndex - beginIndex;

		if (beginIndex < 0)
			throw new IndexOutOfBoundsException("beginIndex is negative");
		if (endIndex < 0)
			throw new IndexOutOfBoundsException("endIndex is negative");
		if (endIndex < beginIndex)
			throw new IndexOutOfBoundsException("endIndex is less than beginIndex");
		if (beginIndex > length)
			throw new IndexOutOfBoundsException("beginIndex is greater than array.length");
		if (endIndex > length)
			throw new IndexOutOfBoundsException("endIndex is greater than array.length");

		Object product = Array.newInstance(array.getClass().getComponentType(), subLen);

		//noinspection SuspiciousSystemArraycopy
		System.arraycopy(array, beginIndex, product, 0, subLen);
		return product;
	}

	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @param <T>      the type of the elements on the given array
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static <T> long sum(T[] array, Function<T, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(boolean[] array, Function<Boolean, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(byte[] array, Function<Byte, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(char[] array, Function<Character, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(double[] array, Function<Double, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(float[] array, Function<Float, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(int[] array, Function<Integer, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(long[] array, Function<Long, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum(short[] array, Function<Short, Number> function) {
		return sum0(array, function);
	}
	/**
	 * Get the total sum of the given array. By applying the given function foreach element of the given array. Then sum all the returned values
	 * together.
	 *
	 * @param array    to sum their elements
	 * @param function the function to get the value of each element
	 * @return the total sum of the given arrays
	 * @throws NullPointerException     if ether the given 'array' or the given 'function' is null
	 * @throws IllegalArgumentException if any of the given array isn't actually an array
	 */
	public static long sum0(Object array, Function<?, ?> function) {
		Objects.requireNonNull(array, "array");
		Objects.requireNonNull(function, "function");
		if (!array.getClass().isArray())
			throw new IllegalArgumentException(array + " isn't an array");

		long sum = 0;

		int l = Array.getLength(array);
		for (int i = 0; i < l; i++)
			sum += ((Function<Object, Number>) function).apply(Array.get(array, i)).longValue();

		return sum;
	}
}
