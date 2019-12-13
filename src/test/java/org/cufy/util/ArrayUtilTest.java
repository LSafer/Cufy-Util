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

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("JavaDoc")
public class ArrayUtilTest {
	public void test() {
		//todo test
	}

	//todo

	/**
	 * @verifies match right
	 * @see ArrayUtil#any(Object, Object[])
	 */
	@Test
	public void testAny_shouldMatchRight() {
		Object[] array = {"A", "B", "C"};
		
		Assert.assertTrue("\"A\" is contained in the array", ArrayUtil.any(array, "R", "X", "a", "A"));
		Assert.assertFalse("All elements are not in the array", ArrayUtil.any(array, "y", "b", "P", "}"));
	}


	/**
	 * @verifies append successfully
	 * @see ArrayUtil#append(Object, Object...)
	 */
	@Test
	public void testAppend_shouldAppendSuccessfully() {
		char[] array = {'A', 'B', 'C'};
		char[] appended = ArrayUtil.append(array, 'D', 'E', 'F');

		Assert.assertEquals("Wrong appended array", "ABCDEF", String.copyValueOf(appended));
	}

	/**
	 * @verifies copy successfully
	 * @see ArrayUtil#arraycopy(Object, int, Object, int, int)
	 */
	@Test
	public void testArraycopy_shouldCopySuccessfully() {
		char[] array = {'A', 'B', 'C'};
		char[] array1 = {'a', 'b', 'c'};

		ArrayUtil.arraycopy(array, 1, array1, 1, 1);

		Assert.assertEquals("Out of range",'a', array1[0]);
		Assert.assertEquals("Out of range", 'c', array1[2]);
		Assert.assertEquals("not copied", 'B', array1[1]);
	}
}
