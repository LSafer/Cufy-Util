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

import cufy.util.function.Lambda;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("JavaDoc")
public class ArrayUtilTest {
	@Test
	public void all() {
		char[] chars = "Sulaiman".toCharArray();

		Assert.assertEquals("X should be missing", (Character) 'X', ArrayUtil.all(chars, 'm', 'a', 'S', 'X', 'n'));
		Assert.assertNull("No char should be missing", ArrayUtil.all(chars, 'S', 'u', 'n', 'a'));
	}

	@Test
	public void any() {
		Object[] array = {'A', 'B', 'C'};

		Assert.assertEquals("'A' is contained in the array", 'A', ArrayUtil.any(array, 'R', 'X', 'a', 'A'));
		Assert.assertNull("All elements are not in the array", ArrayUtil.any(array, 'y', 'b', 'P', '}'));
		Assert.assertEquals("An array should contains it's elements", 'A', ArrayUtil.any(array, array));
	}

	@Test
	public void asList() {
		char[] chars = "Sulaiman".toCharArray();
		List<Character> characters = ArrayUtil.asList(chars);

		for (int i = 0; i < chars.length; i++)
			Assert.assertEquals("Wrong character", chars[i], (char) characters.get(i));
	}

	@Test
	public void copyOf() {
		char[] chars = "Sulaiman".toCharArray();
		int[] ints = (int[]) ArrayUtil.copyOf0(chars, 4, int[].class);

		Assert.assertEquals("Wrong length", 4, ints.length);

		for (int i = 0; i < ints.length; i++)
			Assert.assertEquals("Wrong letter", ints[i], chars[i]);
	}

	@Test
	public void hardcopy() {
		char[] array = {'A', 'B', 'C'};
		char[] array1 = {'a', 'b', 'c'};

		ArrayUtil.hardcopy0(array, 1, array1, 1, 1);

		Assert.assertEquals("Out of range", 'a', array1[0]);
		Assert.assertEquals("Out of range", 'c', array1[2]);
		Assert.assertEquals("not copied", 'B', array1[1]);
	}

	@Test
	public void indexOf() {
		Object[] objects = {"A", "B", "C", "D", "E", "F"};
		Assert.assertEquals("Wrong Index", 3, ArrayUtil.indexOf(objects, "D"));
		Assert.assertEquals("Wrong Index", -1, ArrayUtil.indexOf(objects, "G"));
		Assert.assertEquals("Wrong Index", -1, ArrayUtil.indexOf(new Object[]{"X", "Y", "Z"}, "P", "R", "N"));
		Assert.assertEquals("Wrong Index", 1, ArrayUtil.indexOf(new Object[]{"O", "P"}, "P"));

	}

	@Test
	public void iterator() {
		Iterator<Character> iterator = ArrayUtil.iterator('A', 'B', '.', 'Z');

		Assert.assertTrue("Should has next", iterator.hasNext());
		Assert.assertEquals("Wrong item", (Character) 'A', iterator.next());
		Assert.assertEquals("Wrong item", (Character) 'B', iterator.next());
		Assert.assertEquals("Wrong item", (Character) '.', iterator.next());
		Assert.assertEquals("Wrong item", (Character) 'Z', iterator.next());
		Assert.assertFalse("Shouldn't has next", iterator.hasNext());
	}

	@Test
	public void last() {
		char[] chars = {'A', 'B', '.', 'Z'};

		Assert.assertEquals("Not the last element", (Character) chars[chars.length - 1], ArrayUtil.last(chars, 0));
		Assert.assertEquals("Reversed Index Not working", (Character) chars[chars.length - 2], ArrayUtil.last(chars, 1));
	}

	@Test
	public void max() {
		char[][] array = {"sulaiman".toCharArray(), "cufy".toCharArray()};

		char[] max = (char[]) ArrayUtil.max0(array, (a0, a1) -> {
			char max0 = (char) ArrayUtil.max0(a0, Comparator.naturalOrder());
			char max1 = (char) ArrayUtil.max0(a1, Comparator.naturalOrder());

			return Character.compare(max0, max1);
		});

		char deRealMax = ArrayUtil.max(max, Comparator.naturalOrder());

		Assert.assertEquals("Not the max", 'a', deRealMax);
	}

	@Test
	public void merge() {
		char[] array = {'A', 'B', 'C'};
		char[] array0 = {'D', 'E', 'F'};
		char[] product0 = ArrayUtil.merge(array, array0, new char[]{'D', 'E', 'F'});
		Assert.assertEquals("Wrong product0 array", "ABCDEFDEF", String.copyValueOf(product0));
	}

	@Test
	public void replace() {
		char[] chars = "Sulaiman".toCharArray();

		ArrayUtil.replace(chars, ch -> ch.equals('S') ? 'E' : ch.equals('a') ? 'R' : ch);

		Assert.assertEquals("Not replaced properly", "EulRimRn", new String(chars));
	}

	@Test
	public void replaceIf() {
		char[] chars = "Sulaiman".toCharArray();

		ArrayUtil.replaceIf(chars, ch -> ch.equals('S') || ch.equals('a'), ch -> ch.equals('S') ? 'E' : 'R');

		Assert.assertEquals("Not replaced properly", "EulRimRn", new String(chars));
	}

	@Test
	public void subarray() {
		String name = "Sulaiman";
		char[] chars = name.toCharArray();
		int length = name.length();

		for (int i = 0; i < length / 2; i++) {
			int l = length - i;
			char[] subarray = ArrayUtil.subarray(chars, i, l);
			char[] substring = name.substring(i, l).toCharArray();
			Assert.assertArrayEquals("invalid subarray on i=" + i + " l=" + l, substring, subarray);
		}

		char[] c = ArrayUtil.subarray(chars, chars.length, chars.length);
		char[] cc = name.substring(name.length()).toCharArray();
		Assert.assertEquals("Invalid subarray on bounds edges", String.copyValueOf(cc), String.copyValueOf(c));
	}

	@Test
	public void sum() {
		Assert.assertEquals("Wrong sum", 12, ArrayUtil.sum(new int[]{5, 4, 3}, Lambda::it));
	}
}
